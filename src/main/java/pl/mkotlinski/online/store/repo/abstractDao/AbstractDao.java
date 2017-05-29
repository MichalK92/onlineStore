package pl.mkotlinski.online.store.repo.abstractDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractDao<PRIMARYKEY extends Serializable, T>
{
	private final Class<T> persistentClass;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractDao()
	{
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public EntityManager getEntityMenager()
	{
		return this.entityManager;
	}

	public T getByPrimaryKey(PRIMARYKEY primaryKEY)
	{
		return (T) entityManager.find(persistentClass, primaryKEY);
	}

	protected void persist(T entity)
	{
		entityManager.persist(entity);
	}
	
	protected void merge(T entity)
	{
		entityManager.merge(entity);
	}
}
