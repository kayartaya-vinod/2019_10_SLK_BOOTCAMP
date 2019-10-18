package com.slksoft.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.slksoft.entity.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "name", "product.empty.name", "Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "unitPrice", "product.empty.unitPrice", "Unit price is mandatory");
		
		
		Product p = (Product) target;
		if(p.getUnitPrice()!=null && p.getUnitPrice()<=0) {
			errors.rejectValue("unitPrice", "product.min.unitPrice", "Unit price must be > 0");
		}
	}

}
