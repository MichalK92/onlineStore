package pl.mkotlinski.online.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mkotlinski.online.store.model.user.UserProfile;
import pl.mkotlinski.online.store.repo.UserRoleDao;
import pl.mkotlinski.online.store.service.UserRoleService;

@Service("userRoleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Transactional
public class UserRoleServiceImpl implements UserRoleService
{
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public List<UserProfile> findAll()
	{
		return userRoleDao.findAll();
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
		return userRoleDao.findByName(name);
	}
}
