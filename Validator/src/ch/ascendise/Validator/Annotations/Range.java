package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.RangeValidator;

/**
 * Annotated numeric field value should be in the specified range.
 * <br>
 * null fields are not allowed
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(RangeValidator.class)
public @interface Range {
	
	/**
	 * 
	 * @return minimum value for numeric field
	 */
	double min() default 0;
	
	/**
	 * 
	 * @return maximum value for numeric field
	 */
	double max() default Double.MAX_VALUE;
}
