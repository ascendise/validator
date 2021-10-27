package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
	
	int min();
	int max();

}
