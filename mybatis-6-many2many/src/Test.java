import com.ts.pojo.Group;
import com.ts.pojo.UserGroup;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ts.pojo.User;
import com.ts.maper.GroupMaper;
import com.ts.maper.UserGroupMaper;
import com.ts.maper.UserMaper;

public class Test {
	public static void GetGroupAndUsers(SqlSession session) {
		UserGroup userGroup = new UserGroup();
		try {
			GroupMaper groupMaper = session.getMapper(GroupMaper.class);
			Group group = groupMaper.getGroup(1);
			System.out.println("Group => " + group.getGroupName());
			List<User> users = group.getUsers();
			for (User user : users) {
				System.out.println("\t:" + user.getId() + "\t"
						+ user.getUsername());
			}
		} finally {
			session.close();
		}
	}

	public static void AddUserGroup(SqlSession session) {
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupId(1);
		userGroup.setUserId(2);
		try {
			UserGroupMaper userGroupMaper = session.getMapper(UserGroupMaper.class);
			userGroupMaper.insertUserGroup(userGroup);

			session.commit();
		} finally {
			session.close();
		}

	}

	public static void AddUser(SqlSession session) {
		try {
			User user = new User();
			user.setUsername("User-name-1");
			user.setMobile("13838009988");
			UserMaper userMaper = session.getMapper(UserMaper.class);
			userMaper.insertUser(user);
			session.commit();
			// System.out.println(user.getGroupId());
		} finally {
			session.close();
		}
	}

	public static void AddGroup(SqlSession session) {
		try {
			Group group = new Group();
			group.setGroupName("用户组-1");
			GroupMaper groupMapper = session.getMapper(GroupMaper.class);
			groupMapper.insertGroup(group);
			session.commit();
			System.out.println(group.getGroupId());
		} finally {
			session.close();
		}
	}

}
