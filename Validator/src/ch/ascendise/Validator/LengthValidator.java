package ch.ascendise.Validator;

public class LengthValidator implements Validator
{
	
	private Object object;
	private int min;
	private int max;
	
	public LengthValidator(Object object, int min, int max)
	{
		this.object = object;
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
		var message = "Field value does not fit into constraints; min = %d, max = %d";
		return String.format(message, min, max);
	}

}
