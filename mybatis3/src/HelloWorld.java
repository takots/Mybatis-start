import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ts.mybatis.models.User;
import com.ts.mybatis.dao.IUser;

public class HelloWorld {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//			sqlSessionFactory.getConfiguration().addMapper(IUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	public static void main(String[] args) {
		Test Test = new Test();
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			Test.Insert(session);
//			Test.Update(session);
//			Test.Delete(session);
			Test.getUserList(session);
		} finally {
			session.close();
		}
	}
}
