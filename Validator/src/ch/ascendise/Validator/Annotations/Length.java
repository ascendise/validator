package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.LengthValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(LengthValidator.class)
public @interface Length {
	
	int max() default Integer.MAX_VALUE;
	int min() default 0;

}
