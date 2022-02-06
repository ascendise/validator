package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.NotBlank;

/**
 * This is a validator for validating string fields that should not be blank.
 * @see ch.ascendise.Validator.Annotations.NotBlank
 */
public final class NotBlankValidator extends AbstractValidator
{
	/**
	 * Creates a new instance of the NotBlankValidator.
	 * @param object Value that gets validated
	 * @param fieldName Name of the field.
	 * @param notBlank Annotation the field was annotated with.
	 */
	protected NotBlankValidator(Object object, String fieldName, NotBlank notBlank)
	{
		super(object, fieldName, notBlank);
	}
	
	@Override
	public boolean isValid() 
	{
		String s = (String)super.getObject();
		return s != null && !s.isBlank();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		return super.getFieldName() + ": Value is blank";
	}

}
