/**
 * 
 */
package com.robolverap.bo.info;

import java.util.List;

import com.robolverap.model.app.financieros.EstadoFinanciero;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.dto.InfoFinancieraDto;

/**
 * @author jrobolvp
 *
 */
public interface CargaInfoFinancieraBo {

	/**
	 * Devuelve la informacion financiera de un estado financiero
	 * Busca el catalogo de cuentas. 
	 * Busca el valor para cada cuenta
	 * 
	 * @param edoFinanciero
	 * @param year
	 * @param mont
	 * @return
	 */
	List<InfoFinancieraDto> findByEdoFinancieroByFecha(EstadoFinanciero edoFinanciero, Integer year, Integer mont);
	

	/**
	 * Guarda o actualiza la informacion 
	 * @param info informacion a modificar
	 * @param us usuario que modifica	
	 * @param yearSelected anio del periodo	
	 * @param monthSelected mes del periodo
	 */
	void saveInfo(List<InfoFinancieraDto> info, Usuario us, Integer yearSelected, Integer monthSelected);


}
