package ch.ascendise.Validator;

public class NotEmptyValidator extends AbstractValidator
{
	public NotEmptyValidator(Object object, String fieldName)
	{
		super(object, fieldName);
	}

	@Override
	public boolean isValid() 
	{
		String s = (String)object;
		return !s.isEmpty();
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
