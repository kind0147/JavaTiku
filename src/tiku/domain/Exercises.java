package tiku.domain;
import java.io.Serializable;

public class Exercises implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704626106654751356L;
	private int e_id;
	private String e_desc = "";
	private String e_answer = "";
	private String e_diff = "";
	private String e_type = "";	
	private String e_point = "";	
	private String e_img = "";	
	private String e_tag = "";	
	
	public Exercises() {}
	
	public Exercises(String e_desc, String e_answer, String e_diff, String e_type, String e_point, String e_img, String e_tag) {
		this.e_desc = e_desc;
		this.e_answer = e_answer;
		this.e_diff = e_diff;
		this.e_type = e_type;
		this.e_point = e_point;
		this.e_img = e_img;
		this.e_tag = e_tag;
	}
	
	public Exercises(String e_diff, String e_type, String e_point) {
		this.e_diff = e_diff;
		this.e_type = e_type;
		this.e_point = e_point;
	}
	
	//题目ID
	public int getId() {
		return this.e_id;
	}
	
	public void setId(int e_id) {
		this.e_id = e_id;
	}
	
	//题目描述
	public String getEdesc() {
		return this.e_desc;
	}
	
	public void setEdesc(String e_desc) {
		this.e_desc = e_desc;
	}
	//答案
	public String getEanswer() {
		return this.e_answer;
	}
	
	public void setEanswer(String e_answer) {
		this.e_answer = e_answer;
	}
	//难度
	public String getEdiff() {
		return this.e_diff;
	}
	
	public void setEdiff(String e_diff) {
		this.e_diff = e_diff;
	}
	//题目类型
	public String getEtype() {
		return this.e_type;
	}
	
	public void setEtype(String e_type) {
		this.e_type = e_type;
	}
	//知识点
	public String getEpoint() {
		return this.e_point;
	}
	
	public void setEpoint(String e_point) {
		this.e_point = e_point;
	}
	//图片url
	public String getEimg() {
		return this.e_img;
	}
	
	public void setEimg(String e_img) {
		this.e_img = e_img;
	}
	//题目标签
	public String getEtag() {
		return this.e_tag;
	}
	
	public void setEtag(String e_tag) {
		this.e_tag = e_tag;
	}
}
