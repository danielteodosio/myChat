package com.mychat.mychat.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_hobbie")
	private String hobbie;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_password")
	private String password;
	
	
	//-----------------------
	@OneToMany(mappedBy = "userSendedMessage")
	private Collection<SendedMessage> userSendedMessage;
	
	@OneToMany(mappedBy = "userContactSendedMessage")
	private Collection<SendedMessage> userContactSendedMessage;
	//-----------------------
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobbie() {
		return hobbie;
	}
	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
