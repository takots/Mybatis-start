package com.ts.maper;

import com.ts.pojo.Group;
import com.ts.pojo.User;
import com.ts.pojo.UserGroup;

public interface UserGroupMaper {
	public void insertUserGroup(UserGroup userGroup);
	public User getUsersByGroupId(int group_id);
	public Group getGroupsByUserId(int user_id);
}
