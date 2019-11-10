package com.mercadolibre.examen.traductormorse.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MessageSpeed {

	private static final String STANDARD_WORD_PARIS = ". - - .C. -C. - .C. .C. . .W";
	private Map<String, List<String>> standardMessageSeparatedByMorseElements;
	private Map<String, Integer> lenghtsOfMorseElements;
	private BitMessage morseMessage;

	public MessageSpeed(BitMessage morseMessage) {
		this.morseMessage = morseMessage;
		this.standardMessageSeparatedByMorseElements = new HashMap<String, List<String>>();
		calculateSpeed();
	}

	public Integer getMaxLenghtDash() {
		return lenghtsOfMorseElements.get(MorseElements.DASH.getValue());
	}

	public Integer getMaxLenghtDoh() {
		return lenghtsOfMorseElements.get(MorseElements.DOH.getValue());
	}

	public Integer getMaxLenghtSeparatorIntraCharacter() {
		return lenghtsOfMorseElements.get(MorseElements.SEPARATOR_INTRA_CHARACTER.getValue());
	}

	public Integer getMaxLenghtSeparatorInterCharacter() {
		return lenghtsOfMorseElements.get(MorseElements.SEPARATOR_INTER_CHARACTER.getValue());
	}

	public Integer getMaxLenghtWordSeparator() {
		return lenghtsOfMorseElements.get(MorseElements.WORD_SEPARATOR.getValue());
	}

	private void calculateSpeed() {
		Iterator<String> standardMessageParts = morseMessage.getStandardMessageParts().iterator();
		separatedByMorseElements(standardMessageParts);
		calculateLenghts();
	}

	private void separatedByMorseElements(Iterator<String> standardMessageParts) {
		int index = 0;
		while (standardMessageParts.hasNext()) {
			String partOfParisMessage = Character.toString(STANDARD_WORD_PARIS.charAt(index));

			if (!standardMessageSeparatedByMorseElements.containsKey(partOfParisMessage)) {
				standardMessageSeparatedByMorseElements.put(partOfParisMessage, new ArrayList<String>());
			}

			List<String> parts = standardMessageSeparatedByMorseElements.get(partOfParisMessage);
			String partOfMessage = standardMessageParts.next();
			parts.add(partOfMessage);

			if (index == STANDARD_WORD_PARIS.length() - 1) {
				index = 0;
			} else {
				index++;
			}
		}
	}

	private void calculateLenghts() {
		lenghtsOfMorseElements = new HashMap<String, Integer>();
		lenghtsOfMorseElements.put(MorseElements.DOH.getValue(), getLargest(MorseElements.DOH.getValue()).length());
		lenghtsOfMorseElements.put(MorseElements.DASH.getValue(), getLargest(MorseElements.DASH.getValue()).length());
		lenghtsOfMorseElements.put(MorseElements.SEPARATOR_INTRA_CHARACTER.getValue(),
				getLargest(MorseElements.SEPARATOR_INTRA_CHARACTER.getAlias()).length());
		lenghtsOfMorseElements.put(MorseElements.SEPARATOR_INTER_CHARACTER.getValue(),
				getLargest(MorseElements.SEPARATOR_INTER_CHARACTER.getAlias()).length());
		lenghtsOfMorseElements.put(MorseElements.WORD_SEPARATOR.getValue(),
				getLargest(MorseElements.WORD_SEPARATOR.getAlias()).length());
	}

	private String getLargest(String key) {
		return Collections.max(standardMessageSeparatedByMorseElements.get(key), Comparator.comparing(String::length));
	}

	public String getElement(String partOfMessage) {
		for (Entry<String, List<String>> standardMessageElement : standardMessageSeparatedByMorseElements.entrySet()) {
			if (standardMessageElement.getValue().contains(partOfMessage)) {
				return standardMessageElement.getKey();
			}
		}
		return "?";
	}
}
