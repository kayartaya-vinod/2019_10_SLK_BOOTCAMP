package com.slksoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;

@Repository("jdbcDao")
@Setter
public class JdbcUserDao implements UserDao {

	// dependencies of this class
	private String driver;
	private String url;
	private String username;
	private String password;

	private Connection connection;

	// ask spring to inject an object of type DataSource, if found in the container.
	// required=false means that spring should not throw an exception when
	// dependency
	// is not satisfied.
	@Autowired(required = false)
	private DataSource dataSource; // db connection pool

	private Connection createConnection() throws Exception {

		if (dataSource != null) {
			return dataSource.getConnection(); // one connection from the pool
		}

		if (connection != null && connection.isClosed() == false) {
			return connection;
		}

		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public int count() {
		String sql = "select count(*) from users";
		try (Connection conn = createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			return rs.getInt(1);
		} catch (Exception ex) {
			// exception funneling
			throw new RuntimeException(ex); // decorator pattern
		}
	}

}
