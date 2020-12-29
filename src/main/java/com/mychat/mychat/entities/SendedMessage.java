package com.mychat.mychat.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sended_message_table")
public class SendedMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sended_message_id")
	private Integer id;
	@Column(name = "sended_message_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendedMessageDate;
	@Column(name = "sended_message_text")
	private String sendedMessageText;
	
	@ManyToOne
	@JoinColumn(name = "user_sended_message")
	private User userSendedMessage;
	
	@ManyToOne
	@JoinColumn(name = "user_contact_sended_message")
	private User userContactSendedMessage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getSendedMessageDate() {
		return sendedMessageDate;
	}
	public void setSendedMessageDate(Date sendedMessageDate) {
		this.sendedMessageDate = sendedMessageDate;
	}
	public String getSendedMessageText() {
		return sendedMessageText;
	}
	public void setSendedMessageText(String sendedMessageText) {
		this.sendedMessageText = sendedMessageText;
	}
	public User getUserSendedMessage() {
		return userSendedMessage;
	}
	public void setUserSendedMessage(User userSendedMessage) {
		this.userSendedMessage = userSendedMessage;
	}
	public User getUserContactSendedMessage() {
		return userContactSendedMessage;
	}
	public void setUserContactSendedMessage(User userContactSendedMessage) {
		this.userContactSendedMessage = userContactSendedMessage;
	}
}
