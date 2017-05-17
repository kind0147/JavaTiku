package tiku.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import tiku.config.CreateSqlSession;
import tiku.dao.ExercisesDao;
import tiku.dao.UserDao;
import tiku.domain.Exercises;
import tiku.domain.User;
import tiku.config.CreateSqlSession;


@Controller
public class CarAPI {
	private static final Log logger = 
			LogFactory.getLog(CarAPI.class);
	
	@RequestMapping(value="/cartapi", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody HashMap<String, String> cartApi(HttpServletRequest request, HttpSession session, @RequestParam("eid") String eid, @RequestParam("op") String operation) {
		//如果session中没有ecart购物车列表，则新建一个
		if(session.getAttribute("ecart")==null){
			List<String> ecart = new LinkedList<String>();
			session.setAttribute("ecart", ecart);
		}
		//获得购物车列表
		List<Integer> ecart = (LinkedList<Integer>) session.getAttribute("ecart");
		Integer e_id = Integer.valueOf(eid);
		HashMap<String, String> state = new HashMap<String, String>();
		if(operation.equals("add")){
			if(ecart.contains(e_id)){
				
			}else{
				ecart.add((Integer)e_id);
				session.setAttribute("ecart", ecart);
				
			}
			state.put("statement", "0");
		}else if(operation.equals("delete")){
			if(ecart.contains(e_id)){
				ecart.remove((Integer)e_id);
				session.setAttribute("ecart", ecart);
				System.out.println(ecart);
			}else{
			}
			state.put("statement", "0");
		}else{
			state.put("statement", "1");
		}
		return state;
	}
}

