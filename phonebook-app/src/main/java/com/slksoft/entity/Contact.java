package com.slksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Contact {
	private Integer id;
	private String firstname;
	private String lastname;
	private String gender = "Male";
	private String email;
	private String phone;
	private String city = "Bangalore";
	private String state = "Karnataka";
	private String country = "India";
	private String picture;
}
