package com.slksoft.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.slksoft.training.entity.Customer;

public class CustomerDaoJdbcImpl implements CustomerDao {
	
	private Connection createConnection() throws ClassNotFoundException, SQLException {
		// to read .properties file, use ResourceBundle
		ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");
		String driver = rb.getString("jdbc.driver_class_name");
		String url = rb.getString("jdbc.url");
		String user = rb.getString("jdbc.username");
		String password = rb.getString("jdbc.password");
		
		// 1. load driver class
		Class.forName(driver);
		// 2. use DriverManager to get a connection via the Driver
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public void addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getById(Integer id) {
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> getAllCustomers()  {

		String sql = "select * from customers";
		List<Customer> list = new ArrayList<Customer>();
		
		try(
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		){
			// loop through the rs
			while(rs.next()) {
				// convert rs into customer
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				// do the same for other columns
				list.add(c);
			}
		}
		catch(Exception ex) {
			// exception ducking... not to be done like this !!
		}
		
		return list;
	}

	@Override
	public List<Customer> getByCity(String city) {
		return null;
	}

}
