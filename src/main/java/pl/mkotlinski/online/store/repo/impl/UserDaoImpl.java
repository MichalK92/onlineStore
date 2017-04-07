package pl.mkotlinski.online.store.repo.impl;

import javax.annotation.PostConstruct;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.model.user.UserRoleTypeEnum;
import pl.mkotlinski.online.store.repo.UserDao;
import pl.mkotlinski.online.store.repo.abstractDao.AbstractDao;

@Repository("userDaoRepo")
public class UserDaoImpl extends AbstractDao<Long, UserAccount> implements UserDao{

	@Override
	public UserAccount findUserById(long id_user) {
		return getByPrimaryKey(id_user);
	}

	@Override
	public void addUser(UserAccount user) {
		persist(user);
	}

	@Override
	public UserAccount findByLogin(String sso) {
		Session session = getEntityMenager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserAccount.class).add(Restrictions.eq("login", sso));
		UserAccount user = (UserAccount) criteria.uniqueResult();
		return user;
	}
}
