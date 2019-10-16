package com.slksoft.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@MapperScan({ "com.slksoft.dao" })
@PropertySource({ "classpath:jdbc-info.properties" })
@Configuration
@ComponentScan(basePackages = { "com.slksoft.service", "com.slksoft.web" })
public class AppConfig implements WebMvcConfigurer{

	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	
	// this is to inform DispatcherServlet to let go of requests that it can handle to
	// the tomcat's default handler. For example, for CSS, JS, Images etc.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setDriverClassName(driver);
		bds.setPassword(password);
		return bds;
	}

	// Using this bean, mybatis-spring engine creates instances for all
	// mapper interfaces found in @MapperScan packages and loads them 
	// as beans in spring container
	@Bean
	public SqlSessionFactory factory(DataSource ds) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(ds);
		return bean.getObject();
	}
	
	// override the default behavior of InternalResourceViewResolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = 
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}














