/**
 * 
 */
package com.robolverap.dao.factory;

import java.io.Serializable;
import java.util.List;

/**
 * @author Roberto Olvera
 *
 */
public interface PersistenceDao<E> {
	/**
	 * Guarda o actualiza el valor de una Entity
	 * @param value
	 */
	public void saveOrUpdate(E value);

	/**
	 * 
	 * @param value
	 */
	public void delete(E value);

	/**
	 * Devuelve un Entity donde el criteria dado es igual a valor enviado
	 * @param criteria dato el cual se desea filtrar
	 * @param value valor buscado
	 * @return
	 */
	public E findBy(String criteria, Object value);

	/**
	 *  Devuelve un Entity donde coincida su id con el valor dado
	 * @param id
	 * @return
	 */
	public E findById(Serializable id);

	/**
	 * Devuelve todos los elemnetos de un Entity
	 * @return
	 */
	public List<E> findAll();
}
