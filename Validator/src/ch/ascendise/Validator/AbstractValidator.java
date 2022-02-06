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
	private Object object;
	private String fieldName;
	private Annotation annotation;
	
	/**
	 * Constructor should not be called explicitly
	 * It only gets used by the factory instanciating all validators of the object
	 * to be validated.
	 * 
	 * @param object Value that gets validated
	 * @param fieldName Name of the field that gets validated. Can and should be used for error messages.
	 * @param annotation Annotation that identifies which validator is used and might hold values needed for validation
	 */
	protected AbstractValidator(Object object, String fieldName, Annotation annotation)
	{
		this.object = object;
		this.fieldName = fieldName;
		this.annotation = annotation;
	}
	
	/**
	 * Value of the object that is validated
	 * @return value to be validated
	 */
	public Object getObject()
	{
		return object;
	}
	
	/**
	 * Name of the field that is validated
	 * @return Name of field to be validated
	 */
	public String getFieldName()
	{
		return fieldName;
	}
	
	/**
	 * Annotation that specifies how the field is validated
	 * and includes all the values for constraints.
	 * e.g. Length-Annotation with values for min and max length
	 * @return Validation annotation
	 */
	public Annotation getAnnotation()
	{
		return annotation;
	}
}
