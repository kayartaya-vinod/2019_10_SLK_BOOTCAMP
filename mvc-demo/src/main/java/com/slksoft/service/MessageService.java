package com.slksoft.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.slksoft.dao.MessagesDao;
import com.slksoft.entity.Message;

public class MessageService {

	SqlSessionFactory factory;

	public MessageService() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Message> getMessagesForUser(String email) {
		try(SqlSession session = factory.openSession()) {
			MessagesDao dao = session.getMapper(MessagesDao.class);
			return dao.findByRecipientEmail(email);
		}
	}

	public List<Message> getMessagesSentBy(String email) {
		try(SqlSession session = factory.openSession()) {
			MessagesDao dao = session.getMapper(MessagesDao.class);
			return dao.findBySenderEmail(email);
		}
	}
	
	public void sendMessage(Message message) {
		try(SqlSession session = factory.openSession(true)) {
			MessagesDao dao = session.getMapper(MessagesDao.class);
			dao.addNewMessage(message);
		}
	}

	public Message getMessage(Integer id) {
		try(SqlSession session = factory.openSession()) {
			MessagesDao dao = session.getMapper(MessagesDao.class);
			return dao.findById(id);
		}
	}
}
