package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

import ch.ascendise.Validator.NotBlankValidator;

/**
 * Annotated fields string value should not be blank.
 * <br>
 * Field has to have at least one printable character (excludes whitespace)
 * to be considered valid
 * <br>
 * Field should not be null
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(NotBlankValidator.class)
public @interface NotBlank {

}
