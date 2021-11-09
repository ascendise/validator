package ch.ascendise.Validator;

import java.lang.annotation.Annotation;

public abstract class AbstractValidator implements Validator 
{
	protected Object object;
	protected String fieldName;
	protected Annotation annotation;
	
	public AbstractValidator(Object object, String fieldName, Annotation annotation)
	{
		this.object = object;
		this.fieldName = fieldName;
		this.annotation = annotation;
	}
}
