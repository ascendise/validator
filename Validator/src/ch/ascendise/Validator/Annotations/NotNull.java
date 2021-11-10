package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.NotNullValidator;

/**
 *Annotated fields value should not be null 
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(NotNullValidator.class)
public @interface NotNull {

}
