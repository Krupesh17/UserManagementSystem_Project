package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.daoImpl.UserDAOImpl;
import com.project.model.User;

@WebServlet("/login-out")
public class login_logout_Servlet extends HttpServlet {

	// For Login.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAOImpl daoImpl = new UserDAOImpl();
		
		if(daoImpl.checkLoginDetails(email, password)) {
			
			User role = daoImpl.findRole(email);
			String roleOfUser = role.toString();
			
			HttpSession session = req.getSession();
			session.setAttribute("role", roleOfUser);
			session.setAttribute("email", email);
			
			resp.sendRedirect("users");
		}
		else {
			resp.sendRedirect("login.jsp");
		}
	}
	
	
	// For Logout.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.removeAttribute("username");
		session.invalidate();
		
		resp.sendRedirect("login.jsp");
	}
}
