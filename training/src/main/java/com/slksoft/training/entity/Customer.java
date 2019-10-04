package com.slksoft.training.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Customer {

	// fields
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private Gender gender;
	private String address;
	private String city;
	private String state;
	private String country;

}
