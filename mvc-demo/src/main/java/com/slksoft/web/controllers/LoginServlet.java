package com.slksoft.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.User;
import com.slksoft.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			// not logged in
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("./dashboard");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = new UserService();
		service.init();
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = service.getUserByEmailAndPassword(email, password);
		if (user == null) {
			// invalid login
			req.setAttribute("errMsg", "Invalid username/password");
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("./dashboard");
		}
	}

}
