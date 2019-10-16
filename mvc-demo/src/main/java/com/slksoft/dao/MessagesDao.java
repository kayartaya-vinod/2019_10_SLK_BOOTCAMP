package com.slksoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.slksoft.entity.Message;

public interface MessagesDao {

	@Select("select * from messages where msg_from=#{email} order by id desc")
	@Results({
		@Result(column = "msg_from", property="from"),
		@Result(column = "msg_to", property="to"),
		@Result(column = "msg_cc", property="cc"),
		@Result(column = "msg_subject", property="subject"),
		@Result(column = "msg_body", property="body"),
		@Result(column = "sent_at", property="sentAt")
	})public List<Message> findBySenderEmail(String email);
	
	@Select("select * from messages where msg_to=#{email} or msg_cc like #{'%'+email+'%'} order by id desc")
	@Results({
		@Result(column = "msg_from", property="from"),
		@Result(column = "msg_to", property="to"),
		@Result(column = "msg_cc", property="cc"),
		@Result(column = "msg_subject", property="subject"),
		@Result(column = "msg_body", property="body"),
		@Result(column = "sent_at", property="sentAt")
	})
	public List<Message> findByRecipientEmail(String email);

	@Insert("insert into messages values (null, #{from}, #{to}, #{cc}, #{subject}, #{body}, sysdate())")
	@Results({
		@Result(column = "msg_from", property="from"),
		@Result(column = "msg_to", property="to"),
		@Result(column = "msg_cc", property="cc"),
		@Result(column = "msg_subject", property="subject"),
		@Result(column = "msg_body", property="body")
	})
	public void addNewMessage(Message message);

	@Select("select * from messages where id=#{id}")
	@Results({
		@Result(column = "msg_from", property="from"),
		@Result(column = "msg_to", property="to"),
		@Result(column = "msg_cc", property="cc"),
		@Result(column = "msg_subject", property="subject"),
		@Result(column = "msg_body", property="body"),
		@Result(column = "sent_at", property="sentAt")
	})
	public Message findById(Integer id);
}
