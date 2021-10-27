package ch.ascendise.Validator;

public class NotEmptyValidator implements Validator{
	
	private String value;
	
	public NotEmptyValidator(String value)
	{
		this.value = value;
	}

	@Override
	public boolean isValid() 
	{
		return !value.isEmpty();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		return "Field is empty";
	}
	
	
}
