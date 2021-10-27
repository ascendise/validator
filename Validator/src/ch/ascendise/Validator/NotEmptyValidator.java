package ch.ascendise.Validator;

public class NotEmptyValidator implements Validator{
	
	private Object value;
	
	public NotEmptyValidator(Object value)
	{
		this.value = value;
	}

	@Override
	public boolean isValid() 
	{
		String s = (String)value;
		return !s.isEmpty();
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
