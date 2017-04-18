package pl.mkotlinski.online.store.repo;

import pl.mkotlinski.online.store.service.UserRoleService;

public interface UserRoleDao extends UserRoleService
{
	public void initUserProfileRoles();
}
