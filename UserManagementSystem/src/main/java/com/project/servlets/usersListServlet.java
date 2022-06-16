package com.project.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.daoImpl.UserDAOImpl;
import com.project.model.User;

@WebServlet("/users")
public class usersListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		List<User> listOfUsers = userDAOImpl.getAllUsers();
		
		req.setAttribute("listOfUsers", listOfUsers);
		RequestDispatcher  dispatcher = req.getRequestDispatcher("listOfUsers.jsp");
		dispatcher.forward(req, resp);
	}
}
