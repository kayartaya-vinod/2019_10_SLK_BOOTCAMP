package com.slksoft.training.dao;

import java.util.List;

import com.slksoft.training.entity.Customer;

public interface CustomerDao {

	public void addNewCustomer(Customer customer);

	public Customer getById(Integer id);

	public void updateCustomer(Customer customer);

	public void deleteById(Integer id);

	public List<Customer> getAllCustomers();

	public List<Customer> getByCity(String city);

}
