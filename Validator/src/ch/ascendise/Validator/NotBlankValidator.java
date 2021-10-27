package ch.ascendise.Validator;

public class NotBlankValidator implements Validator{

	private Object value;
	
	public NotBlankValidator(Object value)
	{
		this.value = value;
	}
	
	@Override
	public boolean isValid() 
	{
		String s = (String)value;
		return !s.isBlank();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		return "Field is blank";
	}

}
