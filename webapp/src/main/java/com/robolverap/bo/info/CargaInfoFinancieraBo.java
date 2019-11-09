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
public interface CargaInfoFinancieraBo {

	/**
	 * Devuelve la informacion financiera de un estado financiero
	 * @param edoFinanciero
	 * @param year
	 * @param mont
	 * @return
	 */
	List<Cuenta> findByEdoFinancieroByFecha(EstadoFinanciero edoFinanciero, Integer year, Integer mont);


}
