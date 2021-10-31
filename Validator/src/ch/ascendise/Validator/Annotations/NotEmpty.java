package ch.ascendise.Validator.Annotations;
import java.lang.annotation.*;

import ch.ascendise.Validator.NotEmptyValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(NotEmptyValidator.class)
public @interface NotEmpty {

}
