package com.ts.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import com.ts.mybatis.models.User;

public interface IUser {
	@Select("select * from user where id= #{id}")
	public User getUserByID(int id);
}
