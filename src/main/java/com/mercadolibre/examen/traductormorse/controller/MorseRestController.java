package com.mercadolibre.examen.traductormorse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.examen.traductormorse.domain.BitMessage;
import com.mercadolibre.examen.traductormorse.domain.MorseMessage;
import com.mercadolibre.examen.traductormorse.service.MorseService;

@RestController("/api")
public class MorseRestController {

	@Autowired
	private MorseService morseService;
	
	@PostMapping("decode2morse")
	public String decode2morse(BitMessage message) {
		return morseService.decodeBits2Morse(message);
	}
	
	@PostMapping("translate2human")
	public String translate2human(MorseMessage morseMessage) {
		return morseService.transalate2Human(morseMessage);
	}
}
