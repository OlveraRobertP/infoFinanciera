/**
 * 
 */
package com.robolverap.values;

/**
 * 
 * Mantine las claves de los reportes a generar.
 * @author jrobolvp
 *
 */
public enum ReportesTypes {
	ESTADO_RESULTADOS("ER"),
	BALANCE_GENERAL("BG"),
	RAZONES_FINANCIERAS("RZ"),
	FACTURACION("FAC");
	
	
	private String valor;
	
	ReportesTypes(String valor){
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
