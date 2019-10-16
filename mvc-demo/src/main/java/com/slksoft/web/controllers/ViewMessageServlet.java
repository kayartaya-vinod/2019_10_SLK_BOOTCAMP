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

@WebServlet("/view-message")
public class ViewMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			// not logged in
			resp.sendRedirect("./login");
			return;
		}
		
		Integer id = new Integer(req.getParameter("m"));
		MessageService service = new MessageService();
		Message msg = service.getMessage(id);
		req.setAttribute("msg", msg);
		req.setAttribute("page", "view-message");
		req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(req, resp);
	}

}
