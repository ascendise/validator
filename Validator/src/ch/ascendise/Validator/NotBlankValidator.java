package ch.ascendise.Validator;

public class NotBlankValidator extends AbstractValidator
{
	
	public NotBlankValidator(Object object, String fieldName)
	{
		super(object, fieldName);
	}
	
	@Override
	public boolean isValid() 
	{
		String s = (String)object;
		return !s.isBlank();
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
