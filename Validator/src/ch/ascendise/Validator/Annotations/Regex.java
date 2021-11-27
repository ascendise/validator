package ch.ascendise.Validator.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ch.ascendise.Validator.RegexValidator;

/**
 * Annotated field string value should fit into
 * specified regex pattern to pass.
 * 
 * value should not be null
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(RegexValidator.class)
public @interface Regex {

	/**
	 * 
	 * @return regex pattern
	 */
	String value() default "";
}
