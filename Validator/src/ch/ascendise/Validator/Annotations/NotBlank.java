package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.NotBlankValidator;

/**
 * Annotated fields string value should not be blank.
 * 
 * Field has to have at least one printable character (excludes whitespace)
 * to be considered valid
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(NotBlankValidator.class)
public @interface NotBlank {

}
