/**
 * 
 */
package com.robolverap.web.constants;

/**
 * 
 * LISTA LOS EVENTOS GENERADOS EN EL SISTEMA 
 * VALIDAR EVENTOS EN LA TABLA seg_bitacora_eventos
 * @author jrobolvp
 *
 */
public enum BitacoraEventClaves {
	ADD_USR,MOD_USR,DEL_USR,RESET_PASS_USR,RESET_PASS_USR_ENVIO,
	LOGIN_SYS,LOGOUT_SYS,
	CON_EDO_RES,CON_PDF_EDO_RES,CON_XLS_EDO_RES, 
	ADD_PARAM, MOD_PARAM, DEL_PARAM, 
	CON_BAL_GRL, CON_PDF_BAL_GRL, CON_XLS_BAL_GRL, 
	CON_RZN_FIN, CON_PDF_RZN_FIN, CON_XLS_RZN_FIN, 
	ADD_RZN_FIN, MOD_RZN_FIN, DEL_RZN_FIN, 
	CON_FACTU, CON_PDF_FACTU, CON_XLS_FACTU,
	CON_COBRAN, CON_PDF_COBRAN, CON_XLS_COBRAN, 
	ADD_PRESU, MOD_PRESU,
	ADD_CON_PRES, MOD_CON_PRES, DEL_CON_PRES,
	ADD_PARTIDA, MOD_PARTIDA, DEL_PARTIDA, 
	ADD_AVANCE, MOD_AVANCE, 
	CON_PRESPUESTO;
}
