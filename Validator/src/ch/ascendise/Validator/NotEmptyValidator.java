package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.NotEmpty;

public class NotEmptyValidator extends AbstractValidator
{
	public NotEmptyValidator(Object object, String fieldName, NotEmpty notEmpty)
	{
		super(object, fieldName, notEmpty);
	}

	@Override
	public boolean isValid() 
	{
		String s = (String)object;
		return s != null && !s.isEmpty();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		return fieldName + ": Value is empty";
	}
	
	
}
