package tiku.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tiku.config.CreateSqlSession;
import tiku.dao.ExercisesDao;
import tiku.domain.Exercises;
import tiku.domain.Sample;
import tools.WordGenerator;


@Controller
public class CartController {
	private static final Log logger = 
			LogFactory.getLog(MainController.class);
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String showCart(HttpServletRequest request, HttpSession session, Model model) throws IOException {
		//���session��û��ecart���ﳵ�б����½�һ��
		if(session.getAttribute("ecart")==null){
			List<Integer> ecart = new LinkedList<Integer>();
			session.setAttribute("ecart", ecart);
		}
		//��ù��ﳵ�б�
		List<Integer> ecart = (LinkedList<Integer>) session.getAttribute("ecart");
		// ͨ���Զ�����õ�SqlSession
		SqlSession sqlSession = CreateSqlSession.getSqlSession();
		// ʵ��exercisesDao�ӿ�
		ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
		//��ʼ��һ�������б�
		List<Exercises> exercisesView = new LinkedList<Exercises>();
		for(int i=0;i<ecart.size();i++){
			exercisesView.add(exercisesDao.findById(ecart.get(i)));
		}
		//ͳ���б�
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		Integer chose = new Integer(0);
		Integer pd = new Integer(0);
		Integer tk = new Integer(0);
		Integer saq = new Integer(0);
		Integer design = new Integer(0);
		for(int i=0;i<exercisesView.size();i++){
			if("chose".equals(exercisesView.get(i).getEtype())){
				chose++;
			}
			if("pd".equals(exercisesView.get(i).getEtype())){
				pd++;
			}
			if("tk".equals(exercisesView.get(i).getEtype())){
				tk++;
			}
			if("saq".equals(exercisesView.get(i).getEtype())){
				saq++;
			}
			if("design".equals(exercisesView.get(i).getEtype())){
				design++;
			}
		}
		count.put("chose", chose);
		count.put("pd", pd);
		count.put("tk", tk);
		count.put("saq", saq);
		count.put("design", design);
		
		
		Sample sample = new Sample(exercisesView);
		session.setAttribute("sample",sample);
		model.addAttribute("exercisesView",exercisesView);
		model.addAttribute("count", count);
		return "testCart";
	}
	
	@RequestMapping(value="/saveDoc", method=RequestMethod.POST)
	public void SaveDoc(HttpServletRequest request, HttpServletResponse resp , HttpSession session, Model model) throws IOException {
		if(session.getAttribute("sample")==null){
			Sample sample = new Sample(null);
			session.setAttribute("sample", sample);
		}
		Sample sample = (Sample) session.getAttribute("sample");
		HashMap<String,String> map = sample.retSample();
        // ��ʾ���ڵ��ù���������Word�ĵ�֮ǰӦ����������ֶ��Ƿ�����  
        // ����Freemarker��ģ�������ڴ���ʱ���ܻ���Ϊ�Ҳ���ֵ������ ������ʱ�������������  
        File file = null;  
        InputStream fin = null;  
        ServletOutputStream out = null;  
        try {  
            // ���ù�����WordGenerator��createDoc��������Word�ĵ�  
            file = WordGenerator.createDoc(map, "exercise");  
            fin = new FileInputStream(file);  
              
            resp.setCharacterEncoding("utf-8");  
            resp.setContentType("application/msword");  
            // ��������������صķ�ʽ������ļ�Ĭ����Ϊsample.doc  
            resp.addHeader("Content-Disposition", "attachment;filename=sample.doc");  
              
            out = resp.getOutputStream();  
            byte[] buffer = new byte[512];  // ������  
            int bytesToRead = -1;  
            // ͨ��ѭ���������Word�ļ�������������������  
            while((bytesToRead = fin.read(buffer)) != -1) {  
                out.write(buffer, 0, bytesToRead);  
            }  
        } finally {  
            if(fin != null) fin.close();  
            if(out != null) out.close();  
            if(file != null) file.delete(); // ɾ����ʱ�ļ�  
        }  
    }  
  
}
