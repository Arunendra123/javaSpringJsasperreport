package demo.spring.orm.userEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class LocalUser {
	  
	  @Id
	  private int userId;
      private String userName;
      private String email;
      private String title;
	
	  public LocalUser() {
		super();
		// TODO Auto-generated constructor stub
	  }

	 public LocalUser(int userId, String userName, String email, String title) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.title = title;
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

	@Override
	public String toString() {
		return "LocalUser [userId=" + userId + ", userName=" + userName + ", email=" + email + ", title=" + title + "]";
	}  
	
}
