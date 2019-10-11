package com.slksoft.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.Contact;
import com.slksoft.service.ContactsService;

@WebServlet("/contact-details")
public class ContactDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String input = req.getParameter("id");
		Integer id = new Integer(input);

		ContactsService service = new ContactsService();
		service.init();
		Contact contact = service.getContactById(id);

		req.setAttribute("contact", contact);

		req.getRequestDispatcher("/WEB-INF/pages/contact-details.jsp").forward(req, resp);
	}
}
