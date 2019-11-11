package com.mercadolibre.examen.traductormorse.service.impl;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.mercadolibre.examen.traductormorse.domain.BitMessage;
import com.mercadolibre.examen.traductormorse.domain.MessageSpeed;
import com.mercadolibre.examen.traductormorse.domain.MorseElements;
import com.mercadolibre.examen.traductormorse.domain.MorseMessage;
import com.mercadolibre.examen.traductormorse.service.MorseDecodeService;

@Service
public class MorseDecodeServiceImpl implements MorseDecodeService {

	private static final String UNKNOWN_CHARACTER = "?";
	private static final String DOH_OR_DASH_ELEMENT = "1";

	@Override
	public String decodeBits2Morse(BitMessage morseMessage) {
		MessageSpeed messageSpeed = new MessageSpeed(morseMessage);
		Iterator<String> partsOfMessage = morseMessage.getMessageParts().iterator();
		String messageAsMorse = "";

		while (partsOfMessage.hasNext()) {
			String partOfMessage = partsOfMessage.next();
			if (partOfMessage.contains(DOH_OR_DASH_ELEMENT)) {
				messageAsMorse = concatDohOrDash(partOfMessage, messageSpeed, messageAsMorse);
			} else {
				messageAsMorse = concatSeparator(partOfMessage, messageSpeed, messageAsMorse);
			}
		}

		return messageAsMorse;
	}

	@Override
	public String transalate2Human(MorseMessage message) {
		String messageAsHumanLanguage = "";
		for (String partOfMessage : message.separateMessage()) {
			if (isDohOrDash(partOfMessage)) {
				String character = MorseMessage.MORSE_ALPHABET.get(partOfMessage);
				messageAsHumanLanguage = messageAsHumanLanguage
						.concat(character == null ? UNKNOWN_CHARACTER : character);
			} else {
				messageAsHumanLanguage = concatSpace(messageAsHumanLanguage, partOfMessage);
			}
		}
		return messageAsHumanLanguage;
	}

	private String concatDohOrDash(String partOfMessage, MessageSpeed messageSpeed, String messageAsMorse) {
		if (partOfMessage.length() <= messageSpeed.getMaxLenghtDoh()) {
			return messageAsMorse.concat(MorseElements.DOH.getValue());
		} else {
			return messageAsMorse.concat(MorseElements.DASH.getValue());
		}
	}

	private String concatSeparator(String partOfMessage, MessageSpeed messageSpeed, String messageAsMorse) {
		if (partOfMessage.length() <= messageSpeed.getMaxLenghtSeparatorIntraCharacter()) {
			return messageAsMorse;
		} else if (partOfMessage.length() <= messageSpeed.getMaxLenghtSeparatorInterCharacter()) {
			return messageAsMorse.concat(MorseElements.SEPARATOR_INTER_CHARACTER.getValue());
		} else {
			return messageAsMorse.concat(MorseElements.WORD_SEPARATOR.getValue());
		}
	}

	private boolean isDohOrDash(String partOfMessage) {
		return partOfMessage.contains(MorseElements.DOH.getValue())
				|| partOfMessage.contains(MorseElements.DASH.getValue());
	}

	private String concatSpace(String messageAsHumanLanguage, String partOfMessage) {
		if (MorseElements.SEPARATOR_INTRA_CHARACTER.getValue().equals(partOfMessage)) {
			return messageAsHumanLanguage.concat(MorseElements.SEPARATOR_INTRA_CHARACTER.getValue());
		} else if (MorseElements.SEPARATOR_INTER_CHARACTER.getValue().equals(partOfMessage)) {
			return messageAsHumanLanguage.concat("");
		} else {
			return messageAsHumanLanguage.concat(" ");
		}
	}

}
