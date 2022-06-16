package com.project.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.daoImpl.UserDAOImpl;
import com.project.model.User;

@WebServlet("/editUpdate")
public class editUpdateUserServlet extends HttpServlet {
	
	UserDAOImpl daoImpl = new UserDAOImpl();
	
	// To Open editForm.jsp page
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("id"));
		User existingUser = daoImpl.selectUser(userId);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("editForm.jsp");
		req.setAttribute("user", existingUser);
		requestDispatcher.forward(req, resp);
	}
	
	
	// To save update's
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String contact = req.getParameter("contact");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		User updatedUser = new User(userId, firstName, lastName, contact, email, password, role);
		
		daoImpl.updateUser(updatedUser);
		
		resp.sendRedirect("users");
	}
}
