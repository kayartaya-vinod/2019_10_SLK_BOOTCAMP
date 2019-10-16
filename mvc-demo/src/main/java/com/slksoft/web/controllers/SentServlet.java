package com.slksoft.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.Message;
import com.slksoft.entity.User;
import com.slksoft.service.MessageService;

@WebServlet("/sent")
public class SentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			// not logged in
			resp.sendRedirect("./login");
			return;
		}
		
		MessageService service = new MessageService();
		List<Message> list = service.getMessagesSentBy(user.getEmail());
		req.setAttribute("messages", list);
		req.setAttribute("page", "sent");
		req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(req, resp);
		
	}
	
}





