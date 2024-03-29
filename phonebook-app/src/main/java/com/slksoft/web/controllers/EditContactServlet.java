package com.slksoft.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.Contact;
import com.slksoft.service.ContactsService;

@WebServlet("/edit-contact")
public class EditContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String input = req.getParameter("id");
		Integer id = new Integer(input);

		ContactsService service = new ContactsService();
		service.init();
		Contact contact = service.getContactById(id);

		req.setAttribute("contact", contact);
		req.setAttribute("title", "Edit contact details");

		req.getRequestDispatcher("/WEB-INF/pages/contact-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contact c = new Contact();
		c.setFirstname(req.getParameter("firstname"));
		c.setLastname(req.getParameter("lastname"));
		c.setGender(req.getParameter("gender"));
		c.setEmail(req.getParameter("email"));
		c.setPhone(req.getParameter("phone"));
		c.setCity(req.getParameter("city"));
		c.setState(req.getParameter("state"));
		c.setCountry(req.getParameter("country"));
		c.setPicture(req.getParameter("picture"));
		c.setId(Integer.parseInt(req.getParameter("id")));

		ContactsService service = new ContactsService();
		service.init();
		service.updateContact(c);
		resp.sendRedirect("./contact-details?id=" + c.getId());
	}
}
