package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.Length;

public class LengthValidator extends AbstractValidator
{
	private int min;
	private int max;
	private String value;
	
	public LengthValidator(Object object, String fieldName, Length length)
	{
		super(object, fieldName, length);
		this.min = length.min();
		this.max = length.max();
		this.value = (String)object;
		if(value == null)
		{
			value = "";
		}
	}

	@Override
	public boolean isValid() 
	{
		int length = value.length();
		return length >= min && length <= max;
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		var message = "%s: Length of the value does not fit into constraints;Length = %d min = %d, max = %d";
		return String.format(message, super.getFieldName(), value.length(), min, max);
	}

}
