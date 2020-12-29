package com.mychat.mychat.dto;

import java.util.Date;

public class ChatMessageDTO {
	private Integer userSenderId;
	private Integer userReceiverId;
	private String userSender;
	private Date sendDate;
	private String messageText;
	
	public Integer getUserSenderId() {
		return userSenderId;
	}
	public void setUserSenderId(Integer userSenderId) {
		this.userSenderId = userSenderId;
	}
	public Integer getUserReceiverId() {
		return userReceiverId;
	}
	public void setUserReceiverId(Integer userReceiverId) {
		this.userReceiverId = userReceiverId;
	}
	public String getUserSender() {
		return userSender;
	}
	public void setUserSender(String userSender) {
		this.userSender = userSender;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	

}

//userSender:string;
//sendDate:string;
//messageText:string;