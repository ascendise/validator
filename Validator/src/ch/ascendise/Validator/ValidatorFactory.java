package ch.ascendise.Validator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.ascendise.Validator.Annotations.*;

public class ValidatorFactory {
	
	private Map<Class<?>, Validator> validators = new HashMap<Class<?>, Validator>();
	private Field field;
	
	public ValidatorFactory(Object object, Field field)
	{
		this.field = field;
		Object value = getFieldValue(object);
		validators.put(NotNull.class, new NotNullValidator(value));
		validators.put(NotEmpty.class, new NotEmptyValidator(value));
		validators.put(NotBlank.class, new NotBlankValidator(value));
	}

	private Object getFieldValue(Object object)
	{
		Object value = null;
		try {
			field.setAccessible(true);
			value = field.get(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public List<Validator> getValidators()
	{
		var validators = new ArrayList<Validator>();
		var annotations = field.getAnnotations();
		for(var annotation : annotations)
		{
			var validator = this.validators.get(annotation.annotationType());
			if(validator != null)
			{
				validators.add(validator);
			}
		}
		return validators;
	}

}
