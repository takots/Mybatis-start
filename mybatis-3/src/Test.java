import java.text.MessageFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.ts.mybatis.dao.IUser;
import com.ts.mybatis.models.User;

public class Test {
	public static void Insert(SqlSession session) {
		try {
			// 獲取Mapper
			IUser userMapper = session.getMapper(IUser.class);
			System.out.println("Test insert start...");
			// 執行插入
			User user = new User();
			user.setId(0);
			user.setName("Google");
			user.setDept("Tech");
			user.setWebsite("http://www.google.com");
			user.setPhone("120");
			userMapper.insertUser(user);
			// 提交事務
			session.commit();

			// 顯示插入之後User信息
			System.out.println("After insert");
			getUserList(session);
			System.out.println("Test insert finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 獲取用戶列表
	public static void getUserList(SqlSession session) {
		try {
			IUser iuser = session.getMapper(IUser.class);
			// 顯示User信息
			System.out.println("Test Get start...");
			printUsers(iuser.getUserList());
			System.out.println("Test Get finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Update(SqlSession session) {
		try {
			IUser iuser = session.getMapper(IUser.class);
			System.out.println("Test update start...");
			printUsers(iuser.getUserList());
			// 執行更新
			User user = iuser.getUser(1);
			user.setName("New name");
			iuser.updateUser(user);
			// 提交事務
			session.commit();
			// 顯示更新之後User信息
			System.out.println("After update");
			printUsers(iuser.getUserList());
			System.out.println("Test update finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 刪除用戶信息
	public static void Delete(SqlSession session) {
		try {
			IUser iuser = session.getMapper(IUser.class);
			System.out.println("Test delete start...");
			// 顯示刪除之前User信息
			System.out.println("Before delete");
			printUsers(iuser.getUserList());
			// 執行刪除
			iuser.deleteUser(2);
			// 提交事務
			session.commit();
			// 顯示刪除之後User信息
			System.out.println("After delete");
			printUsers(iuser.getUserList());
			System.out.println("Test delete finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 打印用戶信息到控制台
	 * 
	 * @param users
	 */
	private static void printUsers(final List<User> users) {
		int count = 0;

		for (User user : users) {
			System.out.println(MessageFormat.format("============= User[{0}]=================", ++count));
			System.out.println("User Id: " + user.getId());
			System.out.println("User Name: " + user.getName());
			System.out.println("User Dept: " + user.getDept());
			System.out.println("User Website: " + user.getWebsite());
		}
	}
}
