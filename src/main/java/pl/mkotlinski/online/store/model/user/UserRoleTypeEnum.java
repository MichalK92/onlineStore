package pl.mkotlinski.online.store.model.user;

public enum UserRoleTypeEnum
{
	USER("USER"), ADMIN("ADMIN");
	
	String userRole;
	
	private UserRoleTypeEnum(String userRole)
	{
		this.userRole = userRole;
	}
	
	public String getUserRole()
	{
		return userRole;
	}
}
