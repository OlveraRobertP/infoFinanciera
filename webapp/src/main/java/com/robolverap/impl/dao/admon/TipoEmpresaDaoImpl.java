/**
 * 
 */
package com.robolverap.impl.dao.admon;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.admon.TipoEmpresaDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.admon.TipoEmpresa;

/**
 * @author jrobolvp
 *
 */
@Repository("tipoEmpresaDao")
public class TipoEmpresaDaoImpl extends PersistenceAppMainDaoImpl<TipoEmpresa> 
implements TipoEmpresaDao<TipoEmpresa> {

}
