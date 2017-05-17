package tiku.config;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class CreateSqlSession {
	public static SqlSession getSqlSession() throws IOException {
		//Mybatis 配置文件
		String resource = "tiku/config/appContext-mybatis.xml";
				
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		//创建会话工厂,传入Mybatis的配置文件信息
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
}
