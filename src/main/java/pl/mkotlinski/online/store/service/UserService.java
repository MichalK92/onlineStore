package pl.mkotlinski.online.store.service;

import pl.mkotlinski.online.store.model.User;

public interface UserService {

	public User getUserById(int id_user);
	
	public void addUser(User user);
}
