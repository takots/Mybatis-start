package com.ts.maper;

import java.util.List;

import com.ts.pojo.Order;
import com.ts.pojo.User;

public interface UserMaper {
	public User getUserById(int id);
	public List<Order> getUserOrders(int id);
}
