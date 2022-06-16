package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.daoImpl.UserDAOImpl;

@WebServlet("/delete")
public class deleteUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAOImpl daoImpl = new UserDAOImpl();
		
		int userId = Integer.parseInt(req.getParameter("id"));
		daoImpl.deleteUser(userId);
		resp.sendRedirect("users"); 
	}
}
