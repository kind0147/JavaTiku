package tiku.domain;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Sample implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 370462610665475136L;
	private List<Exercises> exercisesView = new LinkedList<Exercises>();

	public Sample(List<Exercises> exercisesView){
		this.exercisesView = exercisesView;
	}
	
	public HashMap<String,String> retSample(){//生成供freemaker使用的HashMap
		int chose , pd , tk , saq , design;
		chose = 1;
		pd = 1; 
		tk = 1;
		saq = 1;
		design = 1;
		HashMap<String,String> ret = new HashMap<String,String>();
		for(int i=0 ; i < exercisesView.size() ; i++){
			 Exercises e = exercisesView.get(i);
			 if(e.getEtype().equals("chose")){
				ret.put("chose"+chose+"_title", e.getEdesc());
				ret.put("chose"+chose+"_answer", e.getEanswer());
				chose ++;
			 }else if(e.getEtype().equals("pd")){
			    ret.put("pd"+pd+"_title", e.getEdesc());
				ret.put("pd"+pd+"_answer", e.getEanswer()); 
				pd ++;
			 }else if(e.getEtype().equals("tk")){
				ret.put("tk"+tk+"_title", e.getEdesc());
				ret.put("tk"+tk+"_answer", e.getEanswer());
				tk ++;
			 }else if(e.getEtype().equals("saq")){
				ret.put("saq"+saq+"_title", e.getEdesc());
				ret.put("saq"+saq+"_answer", e.getEanswer()); 
				saq ++;
		     }else if(e.getEtype().equals("design")){
				ret.put("design"+design+"_title", e.getEdesc());
				ret.put("design"+design+"_answer", e.getEanswer()); 
				design++;
			 }
		}
		//return (chose==10 && pd==10 && tk==10 && saq==3 && design== 2) ? ret : null;
		return ret;
	}

	public List<Exercises> getExercisesView() {
		return exercisesView;
	}

	public void setExercisesView(List<Exercises> exercisesView) {
		this.exercisesView = exercisesView;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
