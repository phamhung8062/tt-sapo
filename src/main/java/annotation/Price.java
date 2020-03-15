package annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import Validator.PriceValidator;

@Documented
@Constraint(validatedBy = PriceValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Price {
	
	String message() default "Vui lòng nhập giá > 0";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
