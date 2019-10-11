package com.slksoft.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.Contact;
import com.slksoft.service.ContactsService;

@WebServlet("/contact-list")
public class ContactListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactsService service = new ContactsService();
		service.init();
		List<Contact> list = service.getAllContacts();
		req.setAttribute("contacts", list);

		req.getRequestDispatcher("/WEB-INF/pages/contact-list.jsp").forward(req, resp);
	}
}
