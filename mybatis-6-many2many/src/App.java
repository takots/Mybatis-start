import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ts.pojo.User;

public class App {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		Test Test = new Test();
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			 Test.AddGroup(session);
//			 Test.AddUser(session);
//			 Test.AddUserGroup(session);
			Test.GetGroupAndUsers(session);
		} finally {
			session.close();
		}
	}
}
