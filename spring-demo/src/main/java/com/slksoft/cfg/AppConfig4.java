package com.slksoft.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
// @ComponentScan scans for all classes that are annotated 
// with @Component, @Repository, @Service, @Controller, @RestController, @Configuration
// and loads objects of each of these classes found in the specified package (or sub packages)
@ComponentScan(basePackages = { "com.slksoft.dao" })
public class AppConfig4 {

	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	@Value("${jdbc.driver}")
	String driver;

	@Bean
	public DataSource mysqlDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driver);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		return bds;
	}

}
