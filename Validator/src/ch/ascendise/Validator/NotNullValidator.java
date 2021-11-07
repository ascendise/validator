package ch.ascendise.Validator;

public class NotNullValidator extends AbstractValidator
{
	
	public NotNullValidator(Object object, String fieldName)
	{
		super(object, fieldName);
	}

	@Override
	public boolean isValid() {
		return (object != null);
	}

	@Override
	public String getErrorMessage() {
		if(isValid())
		{
			return "";
		}
		return fieldName + ": Value is null";
	}

}
