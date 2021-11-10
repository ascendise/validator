package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.LengthValidator;

/**
 * Annotated fields string value length 
 * has to fit into constraints.
 * Length should not be less than min
 * Length should not be more than max
 * 
 * @param min minimum length for string
 * @param max maximum length for string
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(LengthValidator.class)
public @interface Length {
	
	int max() default Integer.MAX_VALUE;
	int min() default 0;

}
