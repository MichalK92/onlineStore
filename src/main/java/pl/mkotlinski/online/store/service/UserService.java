package pl.mkotlinski.online.store.service;

import pl.mkotlinski.online.store.exception.user.UserException;
import pl.mkotlinski.online.store.exception.user.UserExistsException;
import pl.mkotlinski.online.store.exception.user.UserNotFoundException;
import pl.mkotlinski.online.store.model.user.UserAccount;


/**
 * @author Michal K
 * Date: 10.04.2017
 */
public interface UserService {

	/**
	 * This method try find user by his login. If user doesn't exist, method return null.
	 * @param id_user int value
	 * @return UserAccount
	 * @throws UserException 
	 */
	public UserAccount findUserById(long id_user) throws UserNotFoundException;
	
	/** 
	 * This method try find user by his login. If user doesn't exist, method return null.
	 * 
	 * @param sso String value
	 * @return UserAccount
	 * @throws UserNotFoundException 
	 */
	
	public UserAccount findByLogin(String sso);
	
	/**
	 * This method try add user to repository.
	 * @param user
	 * @throws UserExistsException 
	 * @throws Exception
	 */
	public void addUser(UserAccount user) throws UserExistsException;
	
	
	/**
	 * Method invoked during user registration. Adds a shopping cart to the user.
	 * @param user
	 */
	public void addCartToUser(UserAccount user);
}
