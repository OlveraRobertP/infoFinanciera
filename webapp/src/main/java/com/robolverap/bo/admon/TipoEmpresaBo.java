package com.robolverap.bo.admon;

import java.util.List;

import com.robolverap.model.app.admon.TipoEmpresa;
import com.robolverap.model.app.security.Usuario;

/**
 * 
 * @author jrobolvp
 *
 */
public interface TipoEmpresaBo {

	/**
	 * Devuelve un objeto por su id
	 * 
	 * @param id
	 * @return
	 */
	TipoEmpresa findById(Integer id);

	/**
	 * Devuelve todos los tipod de empresa
	 * 
	 * @return
	 */
	List<TipoEmpresa> findAll();
	
	/**
	 * Guarda o actualiza un tipo de empresa
	 * @param entytiEdit
	 * @param us
	 */
	void saveOrUpdate(TipoEmpresa entytiEdit, Usuario us);

	/**
	 * Elimina un tipo de empresa
	 * @param entytiEdit
	 * @param us
	 */
	void delete(TipoEmpresa entytiEdit, Usuario us);

}
