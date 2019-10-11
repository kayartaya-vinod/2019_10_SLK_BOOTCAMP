package com.slksoft.web.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.User;
import com.slksoft.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// respond with a HTML form for registering new users
		req.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// handle form submission (for new user registration)
		// 1. read inputs
		User u = new User();
		u.setName(req.getParameter("name"));
		u.setEmail(req.getParameter("email"));
		u.setPhone(req.getParameter("phone"));
		u.setPassword(req.getParameter("password"));
		u.setGender(req.getParameter("gender"));
		u.setCreatedAt(new Date());
		
		// 2. call model method to save model data
		UserService service = new UserService();
		service.init();
		service.registerNewUser(u);
		
		// 3. store model data (if any) in some scope (request/session)
		
		// 4. dispatch to view (clientside/serverside forwarding)
		resp.sendRedirect("./login");
	}

}














