package com.ts.mybatis.dao;

import com.ts.mybatis.models.User;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IUser {
//	@Select("SELECT * FROM USER")
	public List<User> getUserList();
//	@Insert("INSERT INTO USER(name ,dept ,website ,phone) VALUES(#{name}, #{dept}, #{website}, #{phone})")
	public void insertUser(User user);
//	@Update("UPDATE USER SET name = #{name}, dept = #{dept}, website = #{website}, phone = #{phone} WHERE id = #{id}")
	public void updateUser(User user);
//	@Delete("DELETE FROM USER WHERE id = #{id}")
	public void deleteUser(int userId);
//	@Select("SELECT * FROM USER where id = #{id}")
	public User getUser(int id);
}
