package com.slksoft.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.training.dao.CustomerDaoJdbcImpl;
import com.slksoft.training.entity.Customer;

@WebServlet("/view-customer-details")
public class ViewCustomerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("id");
		Integer id = new Integer(input);
		Customer c1 = new CustomerDaoJdbcImpl().getById(id);
		request.setAttribute("customer", c1);
		request.getRequestDispatcher("/show-customer-details.jsp").forward(request, response);
	}

}
