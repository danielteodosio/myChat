package com.mychat.mychat.dto;

import java.io.Serializable;

public class NotReadedMessagesDTO implements Serializable{

	private static final long serialVersionUID = -7222955054004887860L;
	
	private Long senderId;
	private Long numberOfMessages;
	
	public NotReadedMessagesDTO(Long senderId, Long numberOfMessages) {
		super();
		this.senderId = senderId;
		this.numberOfMessages = numberOfMessages;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getNumberOfMessages() {
		return numberOfMessages;
	}

	public void setNumberOfMessages(Long numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}
	


}
