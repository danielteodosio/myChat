package com.mychat.mychat.websocket;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import com.mychat.mychat.business.MessageBusiness;
import com.mychat.mychat.dto.ChatMessageDTO;

@Controller
public class ChatMessageController {
	
	@Autowired
	MessageBusiness messageBusiness;
	
	@MessageMapping("/test/{id}")
	String sendMessage(@DestinationVariable Long id, @Payload ChatMessageDTO chatMessageDTO) {
		messageBusiness.saveMessage(chatMessageDTO);
		return chatMessageDTO.getUserSenderId().toString();
	}
}
