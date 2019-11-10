package com.mercadolibre.examen.traductormorse.dto;

import com.mercadolibre.examen.traductormorse.domain.BitMessage;

public class MessageDTO {

	private BitMessage bitMessage;
	private String from;
	private String recipient;

	public BitMessage getBitMessage() {
		return bitMessage;
	}

	public void setBitMessage(BitMessage bitMessage) {
		this.bitMessage = bitMessage;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
