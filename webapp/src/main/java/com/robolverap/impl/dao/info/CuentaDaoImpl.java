package com.robolverap.impl.dao.info;

import org.springframework.stereotype.Repository;

import com.robolverap.dao.info.CuentaDao;
import com.robolverap.impl.dao.factory.PersistenceAppMainDaoImpl;
import com.robolverap.model.app.financieros.Cuenta;

/**
 * 
 * @author jrobolvp
 *
 */
@Repository("cuentaDao")
public class CuentaDaoImpl extends PersistenceAppMainDaoImpl<Cuenta> 
implements CuentaDao<Cuenta>{

}
