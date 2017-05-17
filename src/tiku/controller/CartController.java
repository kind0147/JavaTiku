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
		//如果session中没有ecart购物车列表，则新建一个
		if(session.getAttribute("ecart")==null){
			List<Integer> ecart = new LinkedList<Integer>();
			session.setAttribute("ecart", ecart);
		}
		//获得购物车列表
		List<Integer> ecart = (LinkedList<Integer>) session.getAttribute("ecart");
		// 通过自定义类得到SqlSession
		SqlSession sqlSession = CreateSqlSession.getSqlSession();
		// 实现exercisesDao接口
		ExercisesDao exercisesDao = sqlSession.getMapper(ExercisesDao.class);
		//初始化一个试题列表
		List<Exercises> exercisesView = new LinkedList<Exercises>();
		for(int i=0;i<ecart.size();i++){
			exercisesView.add(exercisesDao.findById(ecart.get(i)));
		}
		//统计列表
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
        // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整  
        // 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了  
        File file = null;  
        InputStream fin = null;  
        ServletOutputStream out = null;  
        try {  
            // 调用工具类WordGenerator的createDoc方法生成Word文档  
            file = WordGenerator.createDoc(map, "exercise");  
            fin = new FileInputStream(file);  
              
            resp.setCharacterEncoding("utf-8");  
            resp.setContentType("application/msword");  
            // 设置浏览器以下载的方式处理该文件默认名为sample.doc  
            resp.addHeader("Content-Disposition", "attachment;filename=sample.doc");  
              
            out = resp.getOutputStream();  
            byte[] buffer = new byte[512];  // 缓冲区  
            int bytesToRead = -1;  
            // 通过循环将读入的Word文件的内容输出到浏览器中  
            while((bytesToRead = fin.read(buffer)) != -1) {  
                out.write(buffer, 0, bytesToRead);  
            }  
        } finally {  
            if(fin != null) fin.close();  
            if(out != null) out.close();  
            if(file != null) file.delete(); // 删除临时文件  
        }  
    }  
  
}
