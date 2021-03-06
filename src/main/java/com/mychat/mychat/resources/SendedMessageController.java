package com.mychat.mychat.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mychat.mychat.business.MessageBusiness;
import com.mychat.mychat.dto.ChatMessageDTO;
import com.mychat.mychat.dto.MessageIdsToUpdateDTO;
import com.mychat.mychat.dto.NotReadedMessagesDTO;
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
	
	@RequestMapping(value = "/getSenderNotReadedMessages", method = RequestMethod.GET)
	public ResponseEntity<Integer> getSenderNotReadedMessages(@RequestParam Integer senderId, @RequestParam Integer receiverId){
		return ResponseEntity.ok(messageBusiness.getSenderNotReadedMessages(senderId, receiverId));
	}

	@RequestMapping(value = "/updateMessagesToReadedBySenderAndReceiver", method = RequestMethod.GET)
	public ResponseEntity<Boolean> updateMessagesToReadedBySenderAndReceiver(@RequestParam Integer senderId, @RequestParam Integer receiverId){
		messageBusiness.updateMessagesToReadedBySenderAndReceiver(senderId, receiverId);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(value = "/getNotReadedMessageByUserId", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<NotReadedMessagesDTO>> getNotReadedMessageByUserId(@RequestParam("receiverId") Integer receiverId){
		ArrayList<NotReadedMessagesDTO> response = messageBusiness.getNotReadedMessageByUserId(receiverId);
		return new ResponseEntity<ArrayList<NotReadedMessagesDTO>>(response, HttpStatus.OK);
	}

}
