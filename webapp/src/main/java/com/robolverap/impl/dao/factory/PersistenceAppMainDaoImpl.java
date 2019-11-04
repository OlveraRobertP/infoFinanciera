package com.robolverap.impl.dao.factory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.robolverap.dao.factory.PersistenceDao;

/**
 * Clase base para todas las clases de persistencia; cualquier clase de acceso a
 * datos, debe de heredar esta clase.
 *
 * @author jolverap
 * @version 1.0
 * @param <E>
 * @param <E> El tipo de objeto que esta mapeado a la BD
 */
public class PersistenceAppMainDaoImpl<E> implements PersistenceDao<E> {
	@Autowired
	@Qualifier(value = "appMainSessionFactory")
	private SessionFactory sessionFactory;

	protected Class<E> persistentClass;

	@SuppressWarnings("unchecked")
	public PersistenceAppMainDaoImpl() {
		this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * @param sessionFactory Establece el sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	protected Criteria crearCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	protected Criteria crearCriteriaConAlias(String alias) {
		return getSession().createCriteria(persistentClass, alias);
	}

	public void saveOrUpdate(E value) {
		this.getSession().saveOrUpdate(persistentClass.getName(), value);
	}

	public void delete(E value) {
		this.getSession().delete(persistentClass.getName(), value);
	}

	public List<E> findAll() {
		return this.getSession().createCriteria(persistentClass).list();
	}

	public E findBy(String criteria, Object value) {
		return (E) this.getSession().createCriteria(persistentClass).add(Restrictions.eq(criteria, value))
				.uniqueResult();
	}

	public E findById(Serializable id) {
		return (E) this.getSession().get(persistentClass, id);

	}

}

