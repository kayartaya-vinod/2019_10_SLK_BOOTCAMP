package com.slksoft.entity;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Message {
	private Integer id;
	private String from;
	private String to;
	private String cc;
	private String subject;
	private String body;
	private Date sentAt;
}
