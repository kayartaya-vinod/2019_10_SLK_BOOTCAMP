package com.slksoft.cfg;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.slksoft.dao.DummyUserDao;
import com.slksoft.dao.JdbcUserDao;


// For a simple application like this one, it works with out @Configuration
// as well. But for more advanced applications that involve transaction 
// management or AOP or Security etc @Configuration is mandatory.
// A class annotated with @Congiruation is qualified for auto detection by
// component scanner.
@Configuration
public class AppConfig1 {
	
	Logger log = Logger.getLogger("com.slksoft.cfg.AppConfig1");
	
	public AppConfig1() {
		log.info("AppConfig1 instantiated!");
	}

	// This class defines beans. A bean is a POJO with a name.
	// We do this by returning a bean from a function annotated with @Bean.
	// By default the name of the function is consedered as the name of the bean.
	// You may give a different name like @Bean(name={"dao", "jdbcDao", "jdbc"})
	@Bean
	//@Lazy
	@Scope("prototype")
	public JdbcUserDao jdbcDao() {
		log.info("AppConfig1.jdbcDao() called!");
		return new JdbcUserDao();
	}
	
	@Bean
	@Lazy
	public DummyUserDao dummyDao() {
		log.info("AppConfig1.dummyDao() called!");
		return new DummyUserDao();
	}
	
}







