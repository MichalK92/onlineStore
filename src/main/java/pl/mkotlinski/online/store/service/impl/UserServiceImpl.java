package pl.mkotlinski.online.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mkotlinski.online.store.model.UserAccount;
import pl.mkotlinski.online.store.repo.UserDao;
import pl.mkotlinski.online.store.service.UserService;

@Service("userService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserAccount findUserById(int id_user) {
		return userDao.findUserById(id_user);
	}

	@Override
	public void addUser(UserAccount user) throws Exception
	{
		UserAccount userAccount = findByLogin(user.getLogin());
		
		if(userAccount != null)
			throw new Exception();
		
		userDao.addUser(user);
	}

	@Override
	public UserAccount findByLogin(String login)
	{
		return userDao.findByLogin(login);
	}
	
	
}
