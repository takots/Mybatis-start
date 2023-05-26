package com.ts.maper;

import com.ts.pojo.User;

public interface UserMaper {
	public void insertUser(User user);
	public User getUser(int id);
}
