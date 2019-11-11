package com.mercadolibre.examen.traductormorse.service;

import com.mercadolibre.examen.traductormorse.domain.BitMessage;
import com.mercadolibre.examen.traductormorse.domain.MorseMessage;

public interface MorseDecodeService {

	public String decodeBits2Morse(BitMessage message);
	public String transalate2Human(MorseMessage message);
}
