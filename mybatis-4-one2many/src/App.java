import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ts.pojo.User;
import com.ts.pojo.Post;

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
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int userid = 1;
			User user = (User) session.selectOne("Dao.getUser", 1);
			System.out.println("username: " + user.getUsername() + ",");
			List<Post> posts = user.getPosts();
			for (Post p : posts) {
				System.out.println("Title:" + p.getTitle());
				System.out.println("Content:" + p.getContent());
			}

		} finally {
			session.close();
		}
	}
}
