/**
 * 
 */
package com.robolverap.web.constants;

/**
 * 
 * LISTA LAS CLAVES DE RAZONES FINANCIERAS
 * VALIDAR EN LA TABLA adm_razonez_financieras
 * @author jrobolvp
 *
 */
public enum RazonFinancieraClaves {
	LIQUIDEZ,
	PRUEBA_ACIDA,
	APALANCAMIENTO,
	DIAS_X_COBRAR,
	DIAS_INVENTARIO,
	DIAS_X_PAGAR,
	CICLO_FINAN,
	NEC_CAP_TRA,
	UTILIDAD_BRUTA,
	UTILIDAD_OPER;
	
	@Override
	public String toString() {
		return super.toString();
	}
}
