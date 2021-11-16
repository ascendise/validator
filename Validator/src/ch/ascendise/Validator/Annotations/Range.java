package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.RangeValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(RangeValidator.class)
public @interface Range {
	double min() default 0;
	double max() default Double.MAX_VALUE;
}
