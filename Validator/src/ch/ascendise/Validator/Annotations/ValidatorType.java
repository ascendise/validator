package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.AbstractValidator;

/**
 * Is used to specify which validator is used when annotating
 * a field with a Validator-Annotation
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorType {
	Class<? extends AbstractValidator> value();
}
