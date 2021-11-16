package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.AbstractValidator;

/**
 * Is used for annotating annotations used for setting constraints
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorType {
	Class<? extends AbstractValidator> value();
}
