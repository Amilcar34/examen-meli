package com.mercadolibre.examen.traductormorse.domain;

public enum MorseElements {

	DOH("."), DASH("-"), SEPARATOR_INTRA_CHARACTER("", " "), SEPARATOR_INTER_CHARACTER(" ", "C"), WORD_SEPARATOR("  ", "W");
	private String value;
	private String alias;

	private MorseElements(String value, String alias) {
		this.value = value;
		this.alias = alias;
	}

	private MorseElements(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getAlias() {
		return alias;
	}
}
