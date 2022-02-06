package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.NotNull;

/**
 * This is a validator for validating fields that should not be null
 * @see ch.ascendise.Validator.Annotations.NotNull
 */
public class NotNullValidator extends AbstractValidator
{
	/**
	 * Creates a new instance of the NotNullValidator
	 * @param object Value that gets validated.
	 * @param fieldName Name of the field.
	 * @param notNull Annotation the field was annotated with
	 */
	protected NotNullValidator(Object object, String fieldName, NotNull notNull)
	{
		super(object, fieldName, notNull);
	}

	@Override
	public boolean isValid() {
		return (super.getObject() != null);
	}

	@Override
	public String getErrorMessage() {
		if(isValid())
		{
			return "";
		}
		return super.getFieldName() + ": Value is null";
	}

}
