package com.slksoft.dao;

public class DummyUserDao implements UserDao {

	@Override
	public int count() {
		return 1000000;
	}

}
