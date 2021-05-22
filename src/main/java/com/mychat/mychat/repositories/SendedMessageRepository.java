package com.mychat.mychat.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mychat.mychat.entities.SendedMessage;

public interface SendedMessageRepository extends CrudRepository<SendedMessage, Integer>{
	
	@Query("Select m from SendedMessage m where m.userSendedMessage.id = :senderId and m.userContactSendedMessage.id = :receiverId or m.userSendedMessage.id = :receiverId and  m.userContactSendedMessage.id = :senderId order by m.sendedMessageDate ASC")
	ArrayList<SendedMessage> getMessagesBySenderAndReceiverOrderedByDate(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);
	@Query("Select m from SendedMessage m where m.userSendedMessage.id = :senderId and m.userContactSendedMessage.id = :receiverId")
	ArrayList<SendedMessage> getMessagesSendedFromSendedToReceiver(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);
	@Modifying
	@Query("Update SendedMessage m set m.wasMessageReaded = 'R' where m.id in (:ids)")
	void updateMessagesToReaded(@Param("ids") List<Integer> ids);
	@Modifying
	@Query("Update SendedMessage m set m.wasMessageReaded = 'R' where m.userSendedMessage.id = :senderId and m.userContactSendedMessage.id = :receiverId or m.userSendedMessage.id = :receiverId and  m.userContactSendedMessage.id = :senderId")
	void updateMessagesToReadedBySenderAndReceiver(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);
}
