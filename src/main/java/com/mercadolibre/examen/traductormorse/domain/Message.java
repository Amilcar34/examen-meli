package com.mercadolibre.examen.traductormorse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mercadolibre.examen.traductormorse.dto.MessageDTO;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	private String sender;
	private String recipient;

	public Message() {
	}

	public Message(String messageAsHumanLanguage, MessageDTO messageDTO) {
		this.message = messageAsHumanLanguage;
		this.sender = messageDTO.getFrom();
		this.recipient = messageDTO.getRecipient();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
