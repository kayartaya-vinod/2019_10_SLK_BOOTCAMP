package com.slksoft.cfg;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.slksoft.dao.DummyUserDao;
import com.slksoft.dao.JdbcUserDao;

// For a simple application like this one, it works with out @Configuration
// as well. But for more advanced applications that involve transaction 
// management or AOP or Security etc @Configuration is mandatory.
// A class annotated with @Congiruation is qualified for auto detection by
// component scanner.
@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig1 {

	Logger log = Logger.getLogger("com.slksoft.cfg.AppConfig1");

	// AppConfig1 dependencies; injected by spring using @Value
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	@Value("${jdbc.driver}")
	String driver;

	public AppConfig1() {
		log.info("AppConfig1 instantiated!");
	}

	// This class defines beans. A bean is a POJO with a name.
	// We do this by returning a bean from a function annotated with @Bean.
	// By default the name of the function is considered as the name of the bean.
	// You may give a different name like @Bean(name={"dao", "jdbcDao", "jdbc"})
	@Bean
	// @Lazy
	// @Scope("prototype")
	public JdbcUserDao jdbcDao() {
		log.info("AppConfig1.jdbcDao() called!");
		JdbcUserDao dao = new JdbcUserDao();
		// setter injection
		dao.setDriver(driver);
		dao.setUrl(url);
		dao.setUsername(username);
		dao.setPassword(password);
		return dao;
	}

	@Bean
	// @Lazy
	public DummyUserDao dummyDao() {
		log.info("AppConfig1.dummyDao() called!");
		return new DummyUserDao();
	}

}
