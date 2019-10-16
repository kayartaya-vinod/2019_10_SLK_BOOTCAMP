package com.slksoft.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.Message;
import com.slksoft.entity.User;
import com.slksoft.service.MessageService;

@WebServlet("/compose")
public class ComposeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			// not logged in
			resp.sendRedirect("./login");
			return;
		}
		
		req.setAttribute("page", "compose");
		req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			// not logged in
			resp.sendRedirect("./login");
			return;
		}
		Message m = new Message();
		m.setFrom(user.getEmail());
		m.setTo(req.getParameter("to"));
		m.setCc(req.getParameter("cc"));
		m.setSubject(req.getParameter("subject"));
		m.setBody(req.getParameter("body"));
		
		MessageService service = new MessageService();
		service.sendMessage(m);
		
		resp.sendRedirect("./compose?sent=1");
	}

}
