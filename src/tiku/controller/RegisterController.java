package tiku.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.*;
import org.springframework.context.support.*;
import com.sun.media.jfxmedia.logging.Logger;

import tiku.domain.User;
import tiku.config.CreateSqlSession;
import tiku.dao.UserDao;

@Controller
public class RegisterController {
	private static final Log logger = 
			LogFactory.getLog(LoginController.class);
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		logger.info("inputRegister called");
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String
			password, @RequestParam("userid") String userid, @RequestParam("userinfo") String userinfo) throws IOException {
		logger.info("inputRegister called");
		// 通过自定义类得到SqlSession
		SqlSession sqlSession = CreateSqlSession.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = new User(userid, username, password, userinfo);
		if(userDao.findByUserName("username")!=null) {
			logger.info("Already Exist");
			return "loginForm";
		}else {
			logger.info("New User");
			userDao.insert(user);
			sqlSession.commit();
		}
		return "loginForm";
	}
}
