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
public enum RubrosTypes {
	INGRESOS("ING"),COSTOS("COS"),GASTOS("GAS"),OTROS("OTR"),ISR_PTU("ISR_PTU"),
	ACTIVO_CIRCULANTE("ACT_CIR"),ACTIVO_NO_CIRCULANTE("ACT_NO_CIR"),PASIVO_CORTO_PLAZO("PAS_CP"),PASIVO_LARGO_PLAZO("PAS_LP"),CAPITAL("CAP");
	
	private String valor;
	
	RubrosTypes(String valor){
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}

}
