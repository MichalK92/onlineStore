package pl.mkotlinski.online.store.repo.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import pl.mkotlinski.online.store.model.user.UserProfile;
import pl.mkotlinski.online.store.model.user.UserRoleTypeEnum;
import pl.mkotlinski.online.store.repo.UserRoleDao;
import pl.mkotlinski.online.store.repo.abstractDao.AbstractDao;

@Repository("userRoleDao")
@Transactional
public class UserRoleDaoImpl extends AbstractDao<Long, UserProfile> implements UserRoleDao
{

	@Autowired
	@Qualifier("transactionManager")
	protected PlatformTransactionManager txManager;

	@PostConstruct
	private void init()
	{
		TransactionTemplate tmpl = new TransactionTemplate(txManager);
		tmpl.execute(new TransactionCallbackWithoutResult()
		{
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status)
			{
				initUserProfileRoles();
			}
		});
	}

	@Override
	public List<UserProfile> findAll()
	{
		return null;
	}

	@Override
	public UserProfile findById(long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile findByName(String name)
	{
		Session session = getEntityMenager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserProfile.class).add(Restrictions.eq("role", name));
		UserProfile profile = (UserProfile) criteria.uniqueResult();
		return profile;
	}

	/*
	 * This is method to initializing default user profile roles.
	 */
	@Transactional
	@Override
	public void initUserProfileRoles()
	{
		Session session = getEntityMenager().unwrap(Session.class);
		UserRoleTypeEnum[] rolesTable = UserRoleTypeEnum.class.getEnumConstants();
		for (UserRoleTypeEnum roleName : rolesTable)
		{
			UserProfile r = findByName(roleName.getUserRole());
			if (r == null)
			{
				UserProfile role = new UserProfile();
				role.setRole(roleName.getUserRole());
				persist(role);
			}
		}
	}
}
