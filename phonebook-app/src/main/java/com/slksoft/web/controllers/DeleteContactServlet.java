package com.slksoft.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.service.ContactsService;

@WebServlet("/delete-contact")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String input = req.getParameter("id");
		Integer id = new Integer(input);

		ContactsService service = new ContactsService();
		service.init();
		service.deleteContactById(id);

		resp.sendRedirect("./contact-list");

	}
}
