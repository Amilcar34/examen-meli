package com.mercadolibre.examen.traductormorse.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class BitMessage {

	private static final String PATTERN_SEPARATOR_BY_ZEROS = "(?=(?!^)0)(?<!0)|(?!0)(?<=0)";
	@NotBlank(message = "El mensaje no puede ser nulo o vacio")
	@ApiModelProperty(notes = "El mensaje en bits a decodificar.")
	private String message;
	@NotBlank(message = "Es necesario ingresar un mensaje estandar para poder interpretar el mensaje")
	@ApiModelProperty(notes = "Este campo debe contener la palabra 'PARIS' en bits al menos dos veces para lograr interpretar el mensaje.")
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

	@ApiModelProperty(hidden = true)
	public List<String> getMessageParts() {
		return separateByZeros(message);
	}

	@ApiModelProperty(hidden = true)
	public List<String> getStandardMessageParts() {
		return separateByZeros(standardMessage);
	}

	private List<String> separateByZeros(String message) {
		List<String> messageSeparateByZerosAndOnes = Stream.of(Arrays.asList(message.split(PATTERN_SEPARATOR_BY_ZEROS)))
				.flatMap(List::stream).filter(puntoOTrazo -> !puntoOTrazo.equals("")).collect(Collectors.toList());

		if (messageSeparateByZerosAndOnes.get(0).contains("0")) {
			// REMOVE INITIAL PAUSE
			messageSeparateByZerosAndOnes.remove(0);
		}

		return messageSeparateByZerosAndOnes;
	}
}
