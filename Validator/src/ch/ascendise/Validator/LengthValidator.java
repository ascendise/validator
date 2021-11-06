package ch.ascendise.Validator;

public class LengthValidator implements Validator
{
	
	private Object object;
	private String fieldName;
	private int min;
	private int max;
	
	public LengthValidator(Object object, String fieldName, int min, int max)
	{
		this.object = object;
		this.fieldName = fieldName;
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean isValid() 
	{
		String s = (String)object;
		int length = s.length();
		return length >= min && length <= max;
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		var message = "%s: Value does not fit into constraints; min = %d, max = %d";
		return String.format(message, fieldName, min, max);
	}

}
