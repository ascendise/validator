package ch.ascendise.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
			Method[] methods = annotation.annotationType().getDeclaredMethods();
			Class<?>[] parameterTypes = new Class<?>[methods.length + 1];
			Object[] parameterValues = new Object[methods.length + 1];
			parameterTypes[0] = Object.class;
			parameterValues[0] = field.get(object);
			for(int i = 1; i < methods.length + 1; i++)
			{
				methods[i - 1].setAccessible(true);
				Class<?> valueType = methods[i - 1].getReturnType();
				parameterTypes[i] = valueType;
				Object value = methods[i - 1].invoke(annotation, (Object[])null);
				parameterValues[i] = value;
			}
			var constructor = validatorType.getConstructor(parameterTypes);
			return constructor.newInstance(parameterValues);
		}
		catch(IllegalArgumentException | IllegalAccessException | NoSuchMethodException | 
				SecurityException | InstantiationException | InvocationTargetException ex)
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
