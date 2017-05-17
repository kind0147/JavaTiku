package tiku.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tiku.domain.Exercises;

public interface ExercisesDao {
	
	public void insert(Exercises exercises);
	
	public void update(Exercises exercises);
	
	public int delete(Exercises exercises);
	
	public int countAll();
	
	public List<Exercises> selectAll();  
	
	public List<Exercises> selectByPage(@Param("index")int index, @Param("e_diff")String e_diff, @Param("e_type")String e_type, @Param("e_point")String e_point);   // 根据第index到index+10行的数据
	
	public List<Exercises> findByDTP(Exercises exercises);  // 根据难度(e_diff)，类型(e_type)，知识点(e_point)查找数据
	
	public Exercises findById(int e_id);
}
