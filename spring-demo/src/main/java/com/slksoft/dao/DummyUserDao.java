package com.slksoft.dao;

import org.springframework.stereotype.Component;

@Component("dummyDao")
public class DummyUserDao implements UserDao {

	@Override
	public int count() {
		return 1000000;
	}

}
