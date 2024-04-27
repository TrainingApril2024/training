package com.apex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Init Load for LoginServlet");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entered into Servlet");
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "admin");
			System.out.println(connection);
			Statement statement = connection.createStatement();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			ResultSet resultSet = statement.executeQuery(
					"select * from user where username='" + username + "' and password='" + password + "'");
			if (!resultSet.next()) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginPage.html");
				requestDispatcher.include(request, response); // In case of failure we have to show user same login page.
			}
			while (resultSet.next()) {
				if (resultSet.getString(1) != null) {
					// Success
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("successServlet");
					requestDispatcher.forward(request, response); // In case of success we have to forward our request to success servlet.
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
