
package com.mercadolibre.examen.traductormorse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.examen.traductormorse.domain.Message;
import com.mercadolibre.examen.traductormorse.domain.MorseMessage;
import com.mercadolibre.examen.traductormorse.dto.MessageDTO;
import com.mercadolibre.examen.traductormorse.repository.MessageRepository;
import com.mercadolibre.examen.traductormorse.service.MessageService;
import com.mercadolibre.examen.traductormorse.service.MorseDecodeService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MorseDecodeService morseService;
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public String sendMessage(MessageDTO message) {
		String messageAsMorse = morseService.decodeBits2Morse(message.getBitMessage());
		String messageAsHumanLanguage = morseService.transalate2Human(new MorseMessage(messageAsMorse));

		Message messageEntity = new Message(messageAsHumanLanguage, message);
		messageRepository.save(messageEntity);
		return messageAsHumanLanguage;
	}

	@Override
	public List<Message> findMessageByRecipient(String recipient) {
		return messageRepository.findByRecipientIgnoreCase(recipient);
	}

}
