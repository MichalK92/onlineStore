package pl.mkotlinski.online.store.service;

import pl.mkotlinski.online.store.model.UserAccount;

public interface UserService {

	public UserAccount findUserById(int id_user);
	
	public UserAccount findByLogin(String sso);
	
	public void addUser(UserAccount user) throws Exception;
}
