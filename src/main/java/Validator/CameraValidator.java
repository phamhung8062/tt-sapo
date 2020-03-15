package Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import annotation.Camera;

public class CameraValidator implements ConstraintValidator<Camera, String> {
	 private static final String LODA_PREFIX = "MP";
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) return false;

        return value.endsWith(LODA_PREFIX);
	}
	

}
