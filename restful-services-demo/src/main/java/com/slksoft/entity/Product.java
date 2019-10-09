package com.slksoft.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	private Integer id;
	private String name;
	private String category;
	private String brand;
	@XmlElement(name = "unit-price")
	private Double unitPrice;
	private String description;
	@XmlElement(name = "quantity-per-unit")
	private String quantityPerUnit;
	private String picture;
	private Integer discount;
}
