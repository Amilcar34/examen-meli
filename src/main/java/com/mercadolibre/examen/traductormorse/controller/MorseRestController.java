package com.mercadolibre.examen.traductormorse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.examen.traductormorse.domain.BitMessage;
import com.mercadolibre.examen.traductormorse.domain.MorseMessage;
import com.mercadolibre.examen.traductormorse.service.MorseService;

@RestController
@RequestMapping("/api")
public class MorseRestController {

	@Autowired
	private MorseService morseService;
	
	@PostMapping("transalte2HumaFromBits")
	public String transalte2HumaFromBits(@RequestBody BitMessage message) {
		String messageAsMorse = morseService.decodeBits2Morse(message);
		return morseService.transalate2Human(new MorseMessage(messageAsMorse));
	}
	
	@PostMapping("decode2morse")
	public String decode2morse(@RequestBody BitMessage message) {
		return morseService.decodeBits2Morse(message);
	}
	
	@PostMapping("translate2human")
	public String translate2human(@RequestBody MorseMessage morseMessage) {
		return morseService.transalate2Human(morseMessage);
	}
}
