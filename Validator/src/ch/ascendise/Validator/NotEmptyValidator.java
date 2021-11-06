package ch.ascendise.Validator;

public class NotEmptyValidator implements Validator{
	
	private Object value;
	private String fieldName;
	
	public NotEmptyValidator(Object value, String fieldName)
	{
		this.value = value;
		this.fieldName = fieldName;
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
		return fieldName + ": Value is empty";
	}
	
	
}
