package com.mercadolibre.examen.traductormorse.service;

import java.util.List;

import com.mercadolibre.examen.traductormorse.domain.Message;
import com.mercadolibre.examen.traductormorse.dto.MessageDTO;

public interface MessageService {

	String sendMessage(MessageDTO bitMessage);
	List<Message> findMessageByRecipient(String recipient);
}
