package ch.ascendise.Validator.Annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
	
	int max() default Integer.MAX_VALUE;
	int min() default 0;

}
