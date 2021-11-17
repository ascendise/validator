package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.NotBlank;

public class NotBlankValidator extends AbstractValidator
{
	
	public NotBlankValidator(Object object, String fieldName, NotBlank notBlank)
	{
		super(object, fieldName, notBlank);
	}
	
	@Override
	public boolean isValid() 
	{
		String s = (String)object;
		return s != null && !s.isBlank();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		return fieldName + ": Value is blank";
	}

}
