package com.slksoft.programs;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.slksoft.cfg.AppConfig4;
import com.slksoft.dao.UserDao;

public class Main1 {

	static Logger log = Logger.getLogger("Main1");

	public static void main(String[] args) {
		// A spring container is represented by a variable of type (interface)
		// org.springframework.context.ApplicationContext. Some of the most used
		// implementations are: FileSystemXmlApplicationContext,
		// ClassPathXmlApplicationContext, AnnotationConfigApplicationContext.

		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

		log.info("----------------- Spring container ready!");

		// instead of we creating a new object of some class that implements UserDao,
		// we ask spring to give an object of the same.
		UserDao dao = ctx.getBean("jdbcDao", UserDao.class);

		int c = dao.count();
		log.info(String.format("There are %d users", c));

		ctx.close();
	}

}
