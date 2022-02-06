package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.NotEmpty;

/**
 * This is a validator for validating that a field is not empty.
 * @see ch.ascendise.Validator.Annotations.NotEmpty
 */
public final class NotEmptyValidator extends AbstractValidator
{
	/**
	 * Creates a new instance of the NotEmptyValidator.
	 * @param object Value that gets validated
	 * @param fieldName Name of the field
	 * @param notEmpty Annotation the field was annotated with
	 */
	protected NotEmptyValidator(Object object, String fieldName, NotEmpty notEmpty)
	{
		super(object, fieldName, notEmpty);
	}

	@Override
	public boolean isValid() 
	{
		String s = (String)super.getObject();
		return s != null && !s.isEmpty();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		return super.getFieldName() + ": Value is empty";
	}
	
	
}
