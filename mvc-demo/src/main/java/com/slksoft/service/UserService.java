package com.slksoft.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.slksoft.dao.UsersDao;
import com.slksoft.entity.User;

public class UserService {
	SqlSessionFactory factory;

	public void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public void registerNewUser(User user) {
		// should do validation of user fields (TBD)
		try(SqlSession session = factory.openSession(true)) {
			UsersDao dao = session.getMapper(UsersDao.class);
			dao.addNewUser(user);
		}
	}

	public User getUserByEmail(String email) {
		try(SqlSession session = factory.openSession()) {
			UsersDao dao = session.getMapper(UsersDao.class);
			return dao.findByEmail(email);
		}
	}

	public User getUserByEmailAndPassword(String email, String password) {
		try(SqlSession session = factory.openSession()) {
			UsersDao dao = session.getMapper(UsersDao.class);
			return dao.findByEmailAndPassword(email, password);
		}
	}
}
