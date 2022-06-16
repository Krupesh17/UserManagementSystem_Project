package com.project.dao;

import java.util.List;

import com.project.model.User;

public interface UserDAO {
	
	public boolean checkLoginDetails(String email, String password);
	public int getLastUserId();
	public void insertUser(User user);
	public List<User> getAllUsers();
	public User selectUser(int userId);
	public User findRole(String email);
	public boolean updateUser(User user);
	public boolean deleteUser(int userId);
}
