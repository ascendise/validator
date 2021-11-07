package ch.ascendise.Validator;

public class LengthValidator extends AbstractValidator
{
	private int min;
	private int max;
	
	public LengthValidator(Object object, String fieldName, int min, int max)
	{
		super(object, fieldName);
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
