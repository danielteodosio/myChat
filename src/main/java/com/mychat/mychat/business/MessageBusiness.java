package com.mychat.mychat.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mychat.mychat.dto.ChatMessageDTO;
import com.mychat.mychat.dto.NotReadedMessagesDTO;
import com.mychat.mychat.entities.SendedMessage;
import com.mychat.mychat.entities.User;
import com.mychat.mychat.repositories.SendedMessageRepository;

@Service
@Transactional
public class MessageBusiness {
	@Autowired
	private SendedMessageRepository sendedMessageRepository;
	@Autowired
	private UserBusiness userBusiness;

	private final String READED = "R";
	private final String NOT_READED = "NR";
	
	public void saveMessage(ChatMessageDTO chatMessageDTO) {
		
 		SendedMessage sendedMessage = new SendedMessage();
 		User sender = userBusiness.getUserById(chatMessageDTO.getUserSenderId());
 		User receiver = userBusiness.getUserById(chatMessageDTO.getUserReceiverId());
 		sendedMessage.setSendedMessageDate(chatMessageDTO.getSendDate());
 		sendedMessage.setSendedMessageText(chatMessageDTO.getMessageText());
 		sendedMessage.setUserSendedMessage(sender);
		sendedMessage.setUserContactSendedMessage(receiver);
		sendedMessage.setWasMessageReaded(this.NOT_READED);
 		sendedMessageRepository.save(sendedMessage);
	}
	
	public ArrayList<SendedMessage> getMessagesBySenderAndReceiverOrderedByDate(Integer senderId, Integer receiverId) {
		return sendedMessageRepository.getMessagesBySenderAndReceiverOrderedByDate(senderId, receiverId);
	}
	
	public ArrayList<SendedMessage> getAllMessages(){
		return (ArrayList<SendedMessage>) sendedMessageRepository.findAll();
	}

	public Integer getSenderNotReadedMessages(Integer senderId, Integer receiverId){
		Integer numberOfNotReadedMessagesFromSender = 0;
		List<SendedMessage> receivedNotReadedMessages = new ArrayList<SendedMessage>();
		receivedNotReadedMessages = sendedMessageRepository.getMessagesSendedFromSendedToReceiver(senderId, receiverId);

		for(SendedMessage receivedNotReadedMessage : receivedNotReadedMessages){
			if(receivedNotReadedMessage.getWasMessageReaded().equals(this.NOT_READED)){
				numberOfNotReadedMessagesFromSender++;
			}
		}
		return numberOfNotReadedMessagesFromSender;
	}

	public void updateMessagesToReadedBySenderAndReceiver(Integer senderId, Integer receiverId){
		sendedMessageRepository.updateMessagesToReadedBySenderAndReceiver(senderId, receiverId);
	}
	
	public ArrayList<NotReadedMessagesDTO> getNotReadedMessageByUserId(Integer receiverId){
		ArrayList<NotReadedMessagesDTO> dtoList= new ArrayList<NotReadedMessagesDTO>();
		ArrayList<Tuple> tuples  = sendedMessageRepository.getNotReadedMessageByUserId(receiverId);
		for(Tuple tuple : tuples) {
			dtoList.add(new NotReadedMessagesDTO(((BigDecimal)tuple.get(0)).longValue(), ((BigDecimal)tuple.get(1)).longValue()));
		}
		return dtoList;
	}
}
