package pl.mkotlinski.online.store.repo.impl;

import org.springframework.stereotype.Repository;

import pl.mkotlinski.online.store.model.User;
import pl.mkotlinski.online.store.repo.UserDao;
import pl.mkotlinski.online.store.repo.abstractDao.AbstractDao;

@Repository("userDaoRepo")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

	@Override
	public User getUserById(int id_user) {
		return getByPrimaryKey(id_user);
	}

	@Override
	public void addUser(User user)
	{
		persist(user);
	}

}
