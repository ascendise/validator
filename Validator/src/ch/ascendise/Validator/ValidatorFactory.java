package ch.ascendise.Validator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import ch.ascendise.Validator.Annotations.*;

public class ValidatorFactory {
	
	public static List<Validator> getValidators(Object object, Field field)
	{
		Object value = getFieldValue(object, field);
		var validators = new ArrayList<Validator>();
		var annotations = field.getAnnotations();
		for(var annotation : annotations)
		{
			if(annotation instanceof NotNull)
			{
				validators.add(new NotNullValidator(value));
			}
		}
		return validators;
	}
	
	private static Object getFieldValue(Object object, Field field)
	{
		Object value = null;
		try {
			field.setAccessible(true);
			value = field.get(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
