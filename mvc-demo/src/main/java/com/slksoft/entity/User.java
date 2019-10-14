package com.slksoft.entity;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String password;
	private Date createdAt;
}
