package com.mercadolibre.examen.traductormorse.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BitMessage {

	private static final String PATTERN_SEPARATOR_BY_ZEROS = "(?=(?!^)0)(?<!0)|(?!0)(?<=0)";
	private String message;
	private String standardMessage;

	public String getMessage() {
		return message;
	}

	public void setMessage(String messageAsBits) {
		this.message = messageAsBits;
	}

	public String getStandardMessage() {
		return standardMessage;
	}

	public void setStandardMessage(String standardMessage) {
		this.standardMessage = standardMessage;
	}

	public List<String> getMessageParts() {
		return separateByZeros(message);
	}

	public List<String> getStandardMessageParts() {
		return separateByZeros(standardMessage);
	}

	private List<String> separateByZeros(String message) {
		List<String> messageSeparateByZerosAndOnes = Stream
				.of(Arrays.asList(message.split(PATTERN_SEPARATOR_BY_ZEROS))).flatMap(List::stream)
				.filter(puntoOTrazo -> !puntoOTrazo.equals("")).collect(Collectors.toList());

		if(messageSeparateByZerosAndOnes.get(0).contains("0")) {
			//REMOVE INITIAL PAUSE
			messageSeparateByZerosAndOnes.remove(0);
		}
		
		return messageSeparateByZerosAndOnes;
	}
}
