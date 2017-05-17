package tiku.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.media.jfxmedia.logging.Logger;

import tiku.config.CreateSqlSession;
import tiku.dao.ExercisesDao;
import tiku.domain.Exercises;

@Controller
public class PageAPI {
	private static final Log logger = 
			LogFactory.getLog(PageAPI.class);
	@RequestMapping(value="/ps", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Exercises> getPage(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("pageNum") int pagenum, 
			@ModelAttribute("diff") String e_diff, 
			@ModelAttribute("type") String e_type, 
			@ModelAttribute("point") String e_point) throws IOException{
		logger.info("e_diff="+e_diff+" e_type="+e_type+" e_point="+e_point);
		// ͨ���Զ�����õ�SqlSession
		SqlSession sqlSession = CreateSqlSession.getSqlSession();
		// ʵ��exercisesDao�ӿ�
		ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
		// ����page�����Ӧ��ʾ��10����¼�����ֵindex
		int index = (pagenum-1)*10;
		// ͨ��exercisesDao�е�selectByPage����ȡ��10����¼
		List<Exercises> exercisesView = exercisesDao.selectByPage(index, e_diff, e_type, e_point);
		logger.info("successfully get page from e_id=" + exercisesView.get(0).getId());
		return exercisesView;
	}
}
