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
import com.slksoft.training.entity.Gender;

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

	}

	@Override
	public Customer getById(Integer id) {
		String sql = "select * from customers where id=?";

		try (
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery();){
				if (rs.next()) {
					return customerFromResultSet(rs);
				}
			}
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}

		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public List<Customer> getAllCustomers() {

		String sql = "select * from customers";
		List<Customer> list = new ArrayList<>();

		try (Connection conn = createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			// loop through the rs
			while (rs.next()) {
				// convert rs into customer
				Customer c = customerFromResultSet(rs);
				list.add(c);
			}
		} catch (Exception ex) {
			// exception ducking... not to be done like this !!
		}

		return list;
	}

	private Customer customerFromResultSet(ResultSet rs) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getString("phone"));
		c.setAddress(rs.getString("address"));
		c.setCity(rs.getString("city"));
		c.setState(rs.getString("state"));
		c.setCountry(rs.getString("country"));
		c.setGender(
				rs.getString("gender").equalsIgnoreCase("Male") ? 
						Gender.Male : Gender.Female);
		return c;
	}

	@Override
	public List<Customer> getByCity(String city) {
		return null;
	}

}
