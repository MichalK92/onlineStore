package pl.mkotlinski.online.store.service;

import java.util.List;

import pl.mkotlinski.online.store.model.user.UserProfile;

public interface UserRoleService
{
	public List<UserProfile> findAll();

	public UserProfile findById(long id);

	public UserProfile findByName(String name);
}
