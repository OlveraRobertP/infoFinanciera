/**
 * 
 */
package com.robolverap.bo.info;

import java.util.List;

import com.robolverap.model.app.financieros.Cuenta;
import com.robolverap.model.app.financieros.EstadoFinanciero;
import com.robolverap.model.app.security.Usuario;

/**
 * @author jrobolvp
 *
 */
public interface EstadoFinancieroBo {
	
	/**
	 * Devuelve los estados financieros
	 * @return
	 */
	List<EstadoFinanciero> findAll();

	/**
	 * Guarda una cuenta asociada a un estado financiero
	 * @param cuenta Cuenta a guardar	
	 * @param us Usuario que realiza la operacion
	 */
	void saveOrUpdateCuenta(Cuenta cuentaEdit, Usuario us);

	/**
	 * Devuelve un estado financiero que coincida con el id 
	 * @param id
	 * @return
	 */
	EstadoFinanciero findEdoFinById(Integer id);

	/**
	 * Guarda un estado financier
	 * @param entyti
	 * @param us Usuario que realiza la operacion
	 */
	void saveOrUpdateEdoFin(EstadoFinanciero entyti, Usuario us);

	/**
	 * Elimina una cuenta
	 * @param cuenta
	 * @param us Usuario que realiza la operacion
	 */
	void deleteCuenta(Cuenta cuenta, Usuario us);


}
