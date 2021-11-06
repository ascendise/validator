package ch.ascendise.Validator;

public class NotBlankValidator implements Validator{

	private Object value;
	private String fieldName;
	
	public NotBlankValidator(Object value, String fieldName)
	{
		this.value = value;
		this.fieldName = fieldName;
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
		return fieldName + ": Value is blank";
	}

}
