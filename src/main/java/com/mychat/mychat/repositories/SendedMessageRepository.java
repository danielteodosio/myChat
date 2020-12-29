package com.mychat.mychat.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mychat.mychat.entities.SendedMessage;

public interface SendedMessageRepository extends CrudRepository<SendedMessage, Integer>{
	
	@Query("Select m from SendedMessage m where m.userSendedMessage.id = :senderId and m.userContactSendedMessage.id = :receiverId or m.userSendedMessage.id = :receiverId and  m.userContactSendedMessage.id = :senderId order by m.sendedMessageDate ASC")
	ArrayList<SendedMessage> getMessagesBySenderAndReceiverOrderedByDate(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);

}
