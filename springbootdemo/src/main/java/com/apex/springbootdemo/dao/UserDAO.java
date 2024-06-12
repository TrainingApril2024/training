package com.apex.springbootdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.apex.springbootdemo.beans.User;

import jakarta.annotation.PostConstruct;

@Repository
public class UserDAO {

	private Connection connection = null;

	@Value("${dbusername}")
	private String dbUsername;

	@Value("${dbpassword}")
	private String dbPassword;

	@PostConstruct
	private void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", dbUsername, dbPassword);
	}

	public int addUser(User user) {
		int executeStatus = 0;
		try {
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement("insert into user (name, age, address) values(?,?,?)");
				statement.setString(1, user.getName());
				statement.setInt(2, user.getAge());
				statement.setString(3, user.getAddress());
				executeStatus = statement.executeUpdate();
				System.out.print(executeStatus);
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return executeStatus;
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from user ");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setName(resultSet.getString(2));
				user.setAge(resultSet.getInt(3));
				user.setAddress(resultSet.getString(4));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public int deleteUser(int id) {
		int executeStatus = 0;
		try {
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement("delete from user where id=?");
				statement.setInt(1, id);
				executeStatus = statement.executeUpdate();
				System.out.print(executeStatus);
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return executeStatus;
	}

	public User getUser(int id) {
		User user = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from user where id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(id);
				user.setName(resultSet.getString(2));
				user.setAge(resultSet.getInt(3));
				user.setAddress(resultSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
