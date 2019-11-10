package com.mercadolibre.examen.traductormorse.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseMessage {

	public static final Map<String, String> MORSE_ALPHABET = new HashMap<String, String>();
	private static final String PATTERN_SEPARATOR_BY_SPACES = "(?=(?!^)\\s)(?<!\\s)|(?!\\s)(?<=\\s)";
	private String message;

	static {
		MORSE_ALPHABET.put(".-", "A");
		MORSE_ALPHABET.put("-...", "B");
		MORSE_ALPHABET.put("-.-.", "C");
		MORSE_ALPHABET.put("-..", "D");
		MORSE_ALPHABET.put(".", "E");
		MORSE_ALPHABET.put("..-.", "F");
		MORSE_ALPHABET.put("--.", "G");
		MORSE_ALPHABET.put("....", "H");
		MORSE_ALPHABET.put("..", "I");
		MORSE_ALPHABET.put(".---", "J");
		MORSE_ALPHABET.put("-.-", "K");
		MORSE_ALPHABET.put(".-..", "L");
		MORSE_ALPHABET.put("--", "M");
		MORSE_ALPHABET.put("-.", "N");
		MORSE_ALPHABET.put("---", "O");
		MORSE_ALPHABET.put(".--.", "P");
		MORSE_ALPHABET.put("--.-", "Q");
		MORSE_ALPHABET.put(".-.", "R");
		MORSE_ALPHABET.put("...", "S");
		MORSE_ALPHABET.put("-", "T");
		MORSE_ALPHABET.put("..-", "U");
		MORSE_ALPHABET.put("...-", "V");
		MORSE_ALPHABET.put(".--", "W");
		MORSE_ALPHABET.put("-..-", "X");
		MORSE_ALPHABET.put("-.--", "Y");
		MORSE_ALPHABET.put("--..", "Z");
		MORSE_ALPHABET.put("-----", "0");
		MORSE_ALPHABET.put(".----", "1");
		MORSE_ALPHABET.put("..---", "2");
		MORSE_ALPHABET.put("...--", "3");
		MORSE_ALPHABET.put("....-", "4");
		MORSE_ALPHABET.put(".....", "5");
		MORSE_ALPHABET.put("-....", "6");
		MORSE_ALPHABET.put("--...", "7");
		MORSE_ALPHABET.put("---..", "8");
		MORSE_ALPHABET.put("----.", "9");
	}

	public MorseMessage(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> separateMessage() {
		List<String> messageSeparateBySpaces = Stream.of(Arrays.asList(message.split(PATTERN_SEPARATOR_BY_SPACES)))
				.flatMap(List::stream).filter(puntoOTrazo -> !puntoOTrazo.equals("")).collect(Collectors.toList());
		return messageSeparateBySpaces;
	}

}