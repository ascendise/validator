package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.NotNull;

public class NotNullValidator extends AbstractValidator
{
	
	public NotNullValidator(Object object, String fieldName, NotNull notNull)
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
