package tiku.domain;
import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String user_id = "";
	private String user_name = "";
	private String user_pw = "";
	private String user_info = "";
	
	public User() {}
	
	public User(String userid, String username, String password, String info) {
		this.user_id = userid;
		this.user_name = username;
		this.user_pw = password;
		this.user_info = info;		
	}
	public User(String username, String password) {
		this.user_name = username;
		this.user_pw = password;
	}
	public String getId() {
		return user_id;
	}
	public void setId(String userid) {
		this.user_id = userid;
	}
	public String getUsername() {
		return user_name;
	}
	public void setUsername(String username) {
		this.user_name = username;
	}
	public String getPassword() {
		return user_pw;
	}
	public void setPassword(String password) {
		this.user_pw = password;
	}
	public String getInfo() {
		return user_info;
	}
	public void setInfo(String info) {
		this.user_info = info;
	}
}
