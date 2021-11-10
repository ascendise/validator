package ch.ascendise.Validator;

import java.lang.annotation.Annotation;

/**
 * AbstractValidator is the abstract base classed used
 * for implementing custom validators. 
 * 
 * This validator handles one field of an object.
 *
 */
public abstract class AbstractValidator implements Validator 
{
	protected Object object;
	protected String fieldName;
	protected Annotation annotation;
	
	/**
	 * Constructor should not be called explicitly
	 * It only gets used by the factory instanciating all validators of the object
	 * to be validated.
	 * 
	 * @param object Value that gets validated
	 * @param fieldName Name of the field that gets validated. Can and should be used for error messages.
	 * @param annotation Annotation that identifies which validator is used and might hold values needed for validation
	 */
	public AbstractValidator(Object object, String fieldName, Annotation annotation)
	{
		this.object = object;
		this.fieldName = fieldName;
		this.annotation = annotation;
	}
}
