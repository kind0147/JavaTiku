package tiku.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class MainController {
	private static final Log logger = 
			LogFactory.getLog(MainController.class);
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainForm(HttpServletRequest request, @ModelAttribute("page") int page, Model model) throws IOException {
		logger.info("Show Main Page");
		// ���Ӧ�õ�������
		ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		
		if(!model.containsAttribute("exercises")) {
			// ͨ���Զ�����õ�SqlSession
			SqlSession sqlSession = CreateSqlSession.getSqlSession();
			// ʵ��exercisesDao�ӿ�
			ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
			// ����page�����Ӧ��ʾ��10����¼�����ֵindex
			int index = (page-1)*10;
			// ͨ��exercisesDao�е�selectByPage����ȡ��10����¼
			List<Exercises> exercisesView = exercisesDao.selectByPage(index, null, null, null);
			
			model.addAttribute("exercises", exercisesView);
		}
		return "main";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String mainPost(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String
			password) {
		return "longinFaillure";
}
	@RequestMapping(value="/visitor", method=RequestMethod.GET)
	public String visitorGet(HttpServletRequest request, Model model) throws IOException {
		logger.info("Show Main Page");
		// ���Ӧ�õ�������
		ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		
		if(!model.containsAttribute("exercises")) {
			// ͨ���Զ�����õ�SqlSession
			SqlSession sqlSession = CreateSqlSession.getSqlSession();
			// ʵ��exercisesDao�ӿ�
			ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
			// ����page�����Ӧ��ʾ��10����¼�����ֵindex
			int index = 0;
			// ͨ��exercisesDao�е�selectByPage����ȡ��10����¼
			List<Exercises> exercisesView = exercisesDao.selectByPage(index, null, null, null);
			
			model.addAttribute("exercises", exercisesView);
		}
		return "visitorMode";
}
	@RequestMapping(value="/common", method=RequestMethod.GET)
	public String commonGet(HttpServletRequest request, Model model) throws IOException {
		logger.info("Show Main Page");
		// ���Ӧ�õ�������
		ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		
		if(!model.containsAttribute("exercises")) {
			// ͨ���Զ�����õ�SqlSession
			SqlSession sqlSession = CreateSqlSession.getSqlSession();
			// ʵ��exercisesDao�ӿ�
			ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
			// ����page�����Ӧ��ʾ��10����¼�����ֵindex
			int index = 0;
			// ͨ��exercisesDao�е�selectByPage����ȡ��10����¼
			List<Exercises> exercisesView = exercisesDao.selectByPage(index, null, null, null);
			
			model.addAttribute("exercises", exercisesView);
		}
		return "NormalMode";
}
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editGet(HttpServletRequest request, @RequestParam("eid") String eid, Model model) throws IOException {
		//���eid�Ƿ�Ϊ�գ�Ϊ�շ��ؿյı༭ҳ�棬��Ϊ�շ��ش�����Ӧ��Ŀ���ݵı༭ҳ��
		if(eid!=""){
			int e_id = Integer.valueOf(eid);
			// ͨ���Զ�����õ�SqlSession
			SqlSession sqlSession = CreateSqlSession.getSqlSession();
			// ʵ��exercisesDao�ӿ�
			ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
			//ͨ����Ŀid��ȡ��Ŀ����
			Exercises exec = exercisesDao.findById(e_id);
			model.addAttribute("exec", exec);
			return "editFile";
		}
		return "enterFile";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody HashMap<String, String> editPost(HttpServletRequest request, Model model, 
			@RequestParam("edesc") String edesc, 
			@RequestParam("eanswer") String eanswer,
			@RequestParam("ediff") String ediff,
			@RequestParam("etype") String etype,
			@RequestParam("epoint") String epoint
			){
		//����exercise����
		Exercises exec = new Exercises();
		exec.setEdesc(edesc);
		exec.setEanswer(eanswer);
		exec.setEdiff(ediff);
		exec.setEtype(etype);
		exec.setEpoint(epoint);
		HashMap<String, String> state = new HashMap<String, String>();
		// ͨ���Զ�����õ�SqlSession
		SqlSession sqlSession;
		try {
			sqlSession = CreateSqlSession.getSqlSession();
			// ʵ��exercisesDao�ӿ�
			ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
			//������Ŀ�������ݿ���
			exercisesDao.insert(exec);
			sqlSession.commit();
			System.out.println(exec.getEdesc());
			state.put("statement", "1");
			return state;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			state.put("statement", "2");
		}
		return state;
	}
} 
