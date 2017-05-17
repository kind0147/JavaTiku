package tiku.config;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class CreateSqlSession {
	public static SqlSession getSqlSession() throws IOException {
		//Mybatis �����ļ�
		String resource = "tiku/config/appContext-mybatis.xml";
				
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		//�����Ự����,����Mybatis�������ļ���Ϣ
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		//ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
}
