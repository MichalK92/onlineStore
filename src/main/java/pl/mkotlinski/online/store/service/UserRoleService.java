package pl.mkotlinski.online.store.service;

import java.util.List;

import pl.mkotlinski.online.store.model.user.UserRole;

public interface UserRoleService
{
	public List<UserRole> findAll();

	public UserRole findById(long id);

	public UserRole findByName(String name);
}
