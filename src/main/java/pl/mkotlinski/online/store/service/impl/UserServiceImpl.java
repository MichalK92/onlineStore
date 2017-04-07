package pl.mkotlinski.online.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mkotlinski.online.store.exception.user.UserExistsException;
import pl.mkotlinski.online.store.exception.user.UserNotFoundException;
import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.repo.UserDao;
import pl.mkotlinski.online.store.service.UserService;

@Service("userService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserAccount findUserById(long id_user) throws UserNotFoundException {
		
		UserAccount userAccount =  userDao.findUserById(id_user);
			if(userAccount == null){
				throw new UserNotFoundException(id_user);
				
			}
		return userAccount;
	}

	@Override
	public void addUser(UserAccount user) throws UserExistsException
	{
		UserAccount userAccount = findByLogin(user.getLogin());	
		if(userAccount != null){
			throw new UserExistsException(user.getLogin());				
		}
		
		userDao.addUser(user);
	}

	@Override
	public UserAccount findByLogin(String login)
	{		
		return userDao.findByLogin(login);
	}
	
	
}
