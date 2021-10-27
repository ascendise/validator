package ch.ascendise.Validator;

public class NotBlankValidator implements Validator{

	private String value;
	
	public NotBlankValidator(String value)
	{
		this.value = value;
	}
	
	@Override
	public boolean isValid() 
	{
		return !value.isBlank();
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
