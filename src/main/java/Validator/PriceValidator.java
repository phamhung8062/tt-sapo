package Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import annotation.Price;

public class PriceValidator implements ConstraintValidator<Price, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value < 0 || value==null) return false;
		return true;
	}
	
	

}
