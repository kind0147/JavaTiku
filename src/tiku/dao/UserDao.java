package tiku.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tiku.domain.User;

public interface UserDao {
	
	public int insert(User user);
	
	public int update(User user);
	
	public int delete(String userName);
	
	public List<User> selectAll();
	
	public int countAll();
	
	public User findByUserName(String userName);
	
	public User checkUser(@Param("user_name")String userName, @Param("user_pw")String password);
	
}
