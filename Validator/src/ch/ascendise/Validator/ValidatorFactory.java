package ch.ascendise.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import ch.ascendise.Validator.Annotations.*;

public class ValidatorFactory {
	
	private Object object;
	private Field field;
	
	public ValidatorFactory(Object object, Field field)
	{
		this.object = object;
		this.field = field;
		field.setAccessible(true);
	}
	
	public List<Validator> getValidators()
	{
		var validators = new ArrayList<Validator>();
		var annotations = field.getDeclaredAnnotations();
		for(var annotation : annotations)
		{
			var validator = getValidator(annotation);
			if(validator != null)
			{
				validators.add(validator);
			}
		}
		return validators;
	}
	
	private Validator getValidator(Annotation annotation)
	{
		try
		{
			var validatorType = getValidatorType(annotation);
			var constructor = validatorType.getConstructors()[0];
			return (Validator) constructor.newInstance(field.get(object), field.getName(), annotation);
		}
		catch(ReflectiveOperationException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	private Class<? extends Validator> getValidatorType(Annotation annotation)
	{
		var fieldAnnotation = annotation.annotationType();
		var validatorType = fieldAnnotation.getAnnotation(ValidatorType.class);
		return validatorType.value();
	}

}
