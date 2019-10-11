package com.slksoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.slksoft.entity.Contact;

public interface ContactsDao {
	@Insert("insert into contacts (firstname, lastname, gender, email, phone, city, state, country, picture) values (#{firstname}, #{lastname}, #{gender}, #{email}, #{phone}, #{city}, #{state}, #{country}, #{picture})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void addNew(Contact contact);

	@Select("select * from contacts where id=#{id}")
	public Contact findById(Integer id);

	@Update("update contacts set firstname=#{firstname}, lastname=#{lastname}, gender=#{gender}, email=#{email}, phone=#{phone}, city=#{city}, state=#{state}, country=#{country}, picture=#{picture} where id=#{id}")
	public void update(Contact contact);

	@Delete("delete from contacts where id=#{id}")
	public void deleteById(Integer id);

	@Select("select * from contacts")
	public List<Contact> findAll();

	@Select("select * from contacts where city=#{city}")
	public List<Contact> findByCity(String city);
}
