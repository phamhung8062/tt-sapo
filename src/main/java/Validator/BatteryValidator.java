package Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import annotation.Battery;

public class BatteryValidator implements ConstraintValidator<Battery, String> {
	 private static final String LODA_PREFIX = "mAh";
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) return false;

        return value.endsWith(LODA_PREFIX);
	}
	

}
