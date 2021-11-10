package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.AbstractValidator;

/**
 * Is used for annotating annotations used for setting constraints
 * 
 * @param value sets the class used for validating the field value
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorType {
	Class<? extends AbstractValidator> value();
}
