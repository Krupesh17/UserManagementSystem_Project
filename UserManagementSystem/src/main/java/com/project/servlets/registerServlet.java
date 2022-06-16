package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.daoImpl.UserDAOImpl;
import com.project.model.User;

@WebServlet("/register")
public class registerServlet extends HttpServlet {

	UserDAOImpl userDAOImpl = new UserDAOImpl();
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName"); 
		String lastName = req.getParameter("lastName"); 
		String contact = req.getParameter("contact");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setContact(contact);
		user.setEmail(email);
		user.setPassword(password);
		
		userDAOImpl.insertUser(user);
		
		resp.sendRedirect("login.jsp");
	}
}
