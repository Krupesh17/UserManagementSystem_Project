package com.project.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.UserDAO;
import com.project.model.User;

public class UserDAOImpl implements UserDAO {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/k17database";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String LOGIN_CHECK = "select * from users where email=? and password=?";
	private static final String INSERT_USER = "insert into users (userId, firstName, lastName, contact, email, password, role) values (?, ?, ?, ?, ?, ?, ?)";
	private static final String LAST_USER_ID = "select max(userId) from users";
	private static final String LIST_OF_ALL_USERS = "select * from users";
	private static final String SELECT_USER_BY_ID = "select firstName, lastName, contact, email, password, role from users where userId = ?;";
	private static final String UPDATE_USER = "update users set firstName = ?, lastName = ?, contact = ?, email = ?, password = ?, role = ? where userId = ?;";
	private static final String FIND_ROLE = "select role from users where email = ?";
	private static final String DELETE_USER = "delete from users where userId = ?";
	
	
// HANDELS DATABASE CONNECTIVITY.
	protected Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		}
		catch(ClassNotFoundException e) {
			
			System.out.println("Error while connecting to database: " + e.getMessage());
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
// Check Login Details
	@Override
	public boolean checkLoginDetails(String email, String password) {
		
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_CHECK);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				return true;
			}
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return false;
	}

// Get Last User Id
	@Override
	public int getLastUserId() {
	
		int userId = 0;
		
		Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(LAST_USER_ID);
			
			while(resultSet.next()) {		// This while loop will run till resultSet has next.
				
				userId = resultSet.getInt(1);
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return userId;
	}

	
// Insert User
	@Override
	public void insertUser(User user) {
		
		Connection connection = getConnection();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.setInt(1, getLastUserId() + 1);
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getContact());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getRole());
			
			int counter = preparedStatement.executeUpdate();
			
			if(counter != 0) {
				
				System.out.println("New user added in database.");
			}
			else {
				
				System.out.println("Error occured while adding new user.");
			}
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
	}

// Get List Of All User
	@Override
	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>();
		
		Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(LIST_OF_ALL_USERS);
			
			User user;
			
			while(resultSet.next()) {
				
				user = new User();
				
				user.setUserId(resultSet.getInt(1));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setContact(resultSet.getString(4));
				user.setEmail(resultSet.getString(5));
				user.setPassword(resultSet.getString(6));
				user.setRole(resultSet.getString(7));
				
				userList.add(user);
			}
		}
		catch(SQLException e) {
			
			System.out.println(e);
		}
		
		return userList;
	}

// Select User By User Id
	@Override
	public User selectUser(int userId) {
		
		User user = null;
		
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, userId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String role = resultSet.getString("role");
				
				user = new User(userId, firstName, lastName, contact, email, password, role);
			}
		}
		catch(SQLException e) {
			
			System.out.println(e);
		}
		
		return user;
	}

	
// Find Role
	@Override
	public User findRole(String email) {
		
		User user = null;
		
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_ROLE);
			preparedStatement.setString(1, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String role = resultSet.getString("role");
				
				user = new User(role);
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return user;
	}
	

// Update User
	@Override
	public boolean updateUser(User user) {
		boolean rowUpdated = false;
		
		Connection connection = getConnection();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getContact());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getRole());
			preparedStatement.setInt(7, user.getUserId());
			
			rowUpdated = preparedStatement.executeUpdate() > 0;
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		
		return rowUpdated;
	}

	
// Delete User
	@Override
	public boolean deleteUser(int userId) {

		boolean rowDeleted = false;
		
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, userId);
			
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		catch(SQLException e) {
			 
			e.printStackTrace();
		}
		
		return rowDeleted;
	}

}
