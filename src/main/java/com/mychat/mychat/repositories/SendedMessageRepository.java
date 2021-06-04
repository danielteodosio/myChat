package com.mychat.mychat.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mychat.mychat.dto.NotReadedMessagesDTO;
import com.mychat.mychat.entities.SendedMessage;

public interface SendedMessageRepository extends CrudRepository<SendedMessage, Integer>{
	
	@Query("Select m from SendedMessage m where m.userSendedMessage.id = :senderId and m.userContactSendedMessage.id = :receiverId or m.userSendedMessage.id = :receiverId and  m.userContactSendedMessage.id = :senderId order by m.sendedMessageDate ASC")
	ArrayList<SendedMessage> getMessagesBySenderAndReceiverOrderedByDate(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);
	@Query("Select m from SendedMessage m where m.userSendedMessage.id = :senderId and m.userContactSendedMessage.id = :receiverId")
	ArrayList<SendedMessage> getMessagesSendedFromSendedToReceiver(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);
	@Modifying
	@Query("Update SendedMessage m set m.wasMessageReaded = 'R' where m.userSendedMessage.id = :senderId and m.userContactSendedMessage.id = :receiverId or m.userSendedMessage.id = :receiverId and  m.userContactSendedMessage.id = :senderId")
	void updateMessagesToReadedBySenderAndReceiver(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);
	
	@Query(value = "SELECT sender.USER_ID, COUNT(sender.USER_ID) " + 
			"FROM " + 
			"USER_TABLE sender INNER JOIN SENDED_MESSAGE_TABLE " + 
			"ON sender.USER_ID = SENDED_MESSAGE_TABLE.USER_SENDED_MESSAGE " + 
			"INNER JOIN USER_TABLE receiver " + 
			"ON receiver.USER_ID = SENDED_MESSAGE_TABLE.USER_CONTACT_SENDED_MESSAGE " + 
			"WHERE SENDED_MESSAGE_TABLE.WAS_READED = 'NR' " + 
			"AND receiver.USER_ID = :receiverId " + 
			"GROUP BY sender.USER_ID, receiver.USER_ID", nativeQuery = true)
	ArrayList<Tuple> getNotReadedMessageByUserId(@Param("receiverId") Integer receiverId);
}

