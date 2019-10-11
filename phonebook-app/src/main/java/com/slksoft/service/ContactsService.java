package com.slksoft.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.slksoft.dao.ContactsDao;
import com.slksoft.entity.Contact;

public class ContactsService {
	SqlSessionFactory factory;

	@PostConstruct
	public void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Contact> getAllContacts() {
		try(SqlSession session = factory.openSession()){
			ContactsDao dao = session.getMapper(ContactsDao.class);
			return dao.findAll();
		}
	}

	public Contact getContactById(Integer id) {
		try(SqlSession session = factory.openSession()){
			ContactsDao dao = session.getMapper(ContactsDao.class);
			return dao.findById(id);
		}
	}

	public void deleteContactById(Integer id) {
		try(SqlSession session = factory.openSession(true)){
			ContactsDao dao = session.getMapper(ContactsDao.class);
			dao.deleteById(id);
		}
	}

	public void updateContact(Contact contact) {
		try(SqlSession session = factory.openSession(true)){
			ContactsDao dao = session.getMapper(ContactsDao.class);
			dao.update(contact);
		}
	}

	public Contact addNewContact(Contact contact) {
		try(SqlSession session = factory.openSession(true)){
			ContactsDao dao = session.getMapper(ContactsDao.class);
			dao.addNew(contact);
			return contact;
		}
	}
}
