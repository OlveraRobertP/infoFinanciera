/**
 * 
 */
package com.robolverap.impl.dao.admon;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.admon.EmpresaDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.admon.Empresa;

/**
 * @author jrobolvp
 *
 */
@Repository("empresaDao")
public class EmpresaDaoImpl  extends PersistenceAppMainDaoImpl<Empresa> 
implements EmpresaDao<Empresa>{

}
