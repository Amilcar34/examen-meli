package com.mercadolibre.examen.traductormorse.dto;

import java.util.List;

public class MessageResponseDTO {

	private List<String> messages;
	private String from;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessage(List<String> messages) {
		this.messages = messages;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
