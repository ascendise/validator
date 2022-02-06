package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.LengthValidator;

/**
 * Annotated fields string value length has to fit into constraints.
 * <br>
 * Length should not be less than min.
 * <br>
 * Length should not be more than max.
 * <br>
 * Null values are treated as strings with length 0
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(LengthValidator.class)
public @interface Length {
	
	/**
	 * @return maximum length for string
	 */
	int max() default Integer.MAX_VALUE;
	/**
	 * @return minimum length for string
	 */
	int min() default 0;

}
