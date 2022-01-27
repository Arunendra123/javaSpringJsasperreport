package demo.spring.orm.userDTO;

import demo.spring.orm.userEntity.LocalUser;

public class UserDto {
	 
	private int userId;
    private String userName;
    private String email;
    private String title;
     
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(LocalUser user) {
		this.userId=user.getUserId();
		this.userName=user.getUserName();
		this.email=user.getEmail();
		this.title=user.getTitle();
	}
	
	public UserDto(int userId, String userName, String email, String title) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.title = title;
	}

	public UserDto of(LocalUser user) {
		if(user!=null) {
			return new UserDto(user);
		}else {
			return null;
		}
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
