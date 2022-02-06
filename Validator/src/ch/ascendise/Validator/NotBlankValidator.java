package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.NotBlank;

public final class NotBlankValidator extends AbstractValidator
{
	
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
