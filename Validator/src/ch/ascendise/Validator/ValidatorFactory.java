package ch.ascendise.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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
			Class<?>[] parameterTypes = getParameterTypes(annotation);
			Object[] parameterValues = getParameterValues(annotation);
			var validatorType = getValidatorType(annotation);
			var constructor = validatorType.getConstructor(parameterTypes);
			return constructor.newInstance(parameterValues);
		}
		catch(ReflectiveOperationException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	private Class<?>[] getParameterTypes(Annotation annotation)
	{
		Method[] methods = annotation.annotationType().getDeclaredMethods();
		Class<?>[] parameterTypes = new Class<?>[methods.length + 1];
		parameterTypes[0] = Object.class;
		for(int i = 0; i < methods.length; i++)
		{
			var method = methods[i];
			method.setAccessible(true);
			parameterTypes[i+1] = method.getReturnType();
		}
		return parameterTypes;
	}
	
	private Object[] getParameterValues(Annotation annotation) throws ReflectiveOperationException
	{
		Method[] methods = annotation.annotationType().getDeclaredMethods();
		Object[] parameterValues = new Object[methods.length + 1];
		parameterValues[0] = field.get(object);
		for(int i = 0; i < methods.length; i++)
		{
			var method = methods[i];
			method.setAccessible(true);
			parameterValues[i+1] = method.invoke(annotation, (Object[])null);
		}
		return parameterValues;
	}
	
	private Class<? extends Validator> getValidatorType(Annotation annotation)
	{
		var fieldAnnotation = annotation.annotationType();
		var validatorType = fieldAnnotation.getAnnotation(ValidatorType.class);
		return validatorType.value();
	}

}
