package tiku.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tiku.dao.ExercisesDao;
import tiku.dao.UserDao;
import tiku.domain.Exercises;
import tiku.domain.User;
import tiku.config.CreateSqlSession;

@Controller
public class LoginController{
	private static final Log logger = 
			LogFactory.getLog(LoginController.class);
	
	@GetMapping(value="/login")
	public String loginForm() {
		logger.info("inputLogin called");
		return "loginForm";
	}
	
	@PostMapping(value="/login")
	public String login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String
			password, RedirectAttributes model) throws IOException {
		logger.info("login request called");
		// 获得应用的上下文
		ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		
		// 通过自定义类得到SqlSession
		SqlSession sqlSession = CreateSqlSession.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		//获取用户对象
		User user_ob = userDao.checkUser(username, password);
       if(user_ob!=null) {
    	   if(user_ob.getInfo().equals("admin")){
    		 //model.addAttribute("username", username);
        	   model.addAttribute("page", 1);
        	   // 释放资源
               sqlSession.close();
        	   return "redirect:/main";
    	   }
    	   else if(user_ob.getInfo().equals("user")){
    		   return "redirect:/common";
    	   }
    	   else{return "loginFaillure";}
       }
       
       // 释放资源
       sqlSession.close();
		
		return "loginFaillure";
	}
	
	
}
