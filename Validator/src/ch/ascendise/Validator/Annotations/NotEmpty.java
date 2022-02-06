package ch.ascendise.Validator.Annotations;
import java.lang.annotation.*;

import ch.ascendise.Validator.NotEmptyValidator;

/**
 * Annotated fields string value should not be empty.
 * <br>
 * The length of the string value has to be more than 0
 * for the field to be considered valid
 * <br>
 * The field should not be null
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(NotEmptyValidator.class)
public @interface NotEmpty {

}
