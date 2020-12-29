package com.mychat.mychat.business;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mychat.mychat.dto.ChatMessageDTO;
import com.mychat.mychat.entities.SendedMessage;
import com.mychat.mychat.entities.User;
import com.mychat.mychat.repositories.SendedMessageRepository;

@Service
public class MessageBusiness {
	@Autowired
	private SendedMessageRepository sendedMessageRepository;
	@Autowired
	private UserBusiness userBusiness;
	
	public void saveMessage(ChatMessageDTO chatMessageDTO) {
		
 		SendedMessage sendedMessage = new SendedMessage();
 		User sender = userBusiness.getUserById(chatMessageDTO.getUserSenderId());
 		User receiver = userBusiness.getUserById(chatMessageDTO.getUserReceiverId());
 		sendedMessage.setSendedMessageDate(chatMessageDTO.getSendDate());
 		sendedMessage.setSendedMessageText(chatMessageDTO.getMessageText());
 		sendedMessage.setUserSendedMessage(sender);
 		sendedMessage.setUserContactSendedMessage(receiver);
 		sendedMessageRepository.save(sendedMessage);
	}
	
	public ArrayList<SendedMessage> getMessagesBySenderAndReceiverOrderedByDate(Integer senderId, Integer receiverId) {
		return sendedMessageRepository.getMessagesBySenderAndReceiverOrderedByDate(senderId, receiverId);
	}
	
	public ArrayList<SendedMessage> getAllMessages(){
		return (ArrayList<SendedMessage>) sendedMessageRepository.findAll();
	}
}
