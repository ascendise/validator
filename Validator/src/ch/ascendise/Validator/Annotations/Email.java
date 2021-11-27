package ch.ascendise.Validator.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ch.ascendise.Validator.EmailValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(EmailValidator.class)
public @interface Email 
{
	
}
