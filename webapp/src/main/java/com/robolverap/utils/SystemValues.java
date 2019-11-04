package com.robolverap.utils;

public enum SystemValues {
	USER_IN_SESSION("userSesion"),
	DEFAULT_SUFIX(".xhtml"), 
	DEFAULT_MTTO("Mtto");
	private String valor;
	
	SystemValues(String valor){
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
}
