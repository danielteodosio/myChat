package com.mychat.mychat.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mychat.mychat.business.MessageBusiness;
import com.mychat.mychat.dto.ChatMessageDTO;
import com.mychat.mychat.entities.SendedMessage;


@Controller
@CrossOrigin
@RequestMapping(value = "/myChat")
public class SendedMessageController {
	
	@Autowired
	private MessageBusiness messageBusiness;
	
	@RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveMessage(@RequestBody ChatMessageDTO chatMessageDTO) {
		messageBusiness.saveMessage(chatMessageDTO);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(value = "/getAllMessage", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<SendedMessage>> saveMessage() {
		return ResponseEntity.ok(messageBusiness.getAllMessages());
	}
	
	@RequestMapping(value = "/getMessagesBySenderAndReceiver", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<SendedMessage>> getMessagesBySenderAndReceiverOrderedByDate(@RequestParam Integer senderId, @RequestParam Integer receiverId){
		return ResponseEntity.ok(messageBusiness.getMessagesBySenderAndReceiverOrderedByDate(senderId, receiverId));
	}
}
