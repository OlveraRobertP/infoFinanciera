package com.robolverap.bo.admon;

import java.util.List;

import com.robolverap.model.app.admon.Empresa;
import com.robolverap.model.app.security.Usuario;

/**
 * 
 * @author jrobolvp
 *
 */
public interface EmpresaBo {

	/**
	 * Busca todas las empresas
	 * @return
	 */
	List<Empresa> findAll();

	/**
	 * Guarda o actualiza una empresa
	 * @param entytiEdit
	 * @param us
	 */
	void saveOrUpdate(Empresa entytiEdit, Usuario us);

	/**
	 * Borra una empresa
	 * @param entytiEdit
	 * @param us
	 */
	void delete(Empresa entytiEdit, Usuario us);

}
