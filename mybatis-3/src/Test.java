import java.text.MessageFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.ts.mybatis.dao.IUser;
import com.ts.mybatis.models.User;

public class Test {
	public static void Insert(SqlSession session) {
		try {
			// ���Mapper
			IUser userMapper = session.getMapper(IUser.class);
			System.out.println("Test insert start...");
			// ���洡�J
			User user = new User();
			user.setId(0);
			user.setName("Google");
			user.setDept("Tech");
			user.setWebsite("http://www.google.com");
			user.setPhone("120");
			userMapper.insertUser(user);
			// ����ư�
			session.commit();

			// ��ܴ��J����User�H��
			System.out.println("After insert");
			getUserList(session);
			System.out.println("Test insert finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ����Τ�C��
	public static void getUserList(SqlSession session) {
		try {
			IUser iuser = session.getMapper(IUser.class);
			// ���User�H��
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
			// �����s
			User user = iuser.getUser(1);
			user.setName("New name");
			iuser.updateUser(user);
			// ����ư�
			session.commit();
			// ��ܧ�s����User�H��
			System.out.println("After update");
			printUsers(iuser.getUserList());
			System.out.println("Test update finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �R���Τ�H��
	public static void Delete(SqlSession session) {
		try {
			IUser iuser = session.getMapper(IUser.class);
			System.out.println("Test delete start...");
			// ��ܧR�����eUser�H��
			System.out.println("Before delete");
			printUsers(iuser.getUserList());
			// ����R��
			iuser.deleteUser(2);
			// ����ư�
			session.commit();
			// ��ܧR������User�H��
			System.out.println("After delete");
			printUsers(iuser.getUserList());
			System.out.println("Test delete finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * ���L�Τ�H���챱��x
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
