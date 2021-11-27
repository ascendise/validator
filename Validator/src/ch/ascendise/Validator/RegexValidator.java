package ch.ascendise.Validator;

import java.util.regex.Pattern;

import ch.ascendise.Validator.Annotations.Regex;

public class RegexValidator extends AbstractValidator 
{
	
	private String pattern;

	public RegexValidator(Object object, String fieldName, Regex regex) 
	{
		super(object, fieldName, regex);
		pattern = regex.value();
	}

	@Override
	public boolean isValid() 
	{
		if(super.getObject() == null)
		{
			return false;
		}
		var pattern = Pattern.compile(this.pattern);
		String value = (String)super.getObject();
		var matcher = pattern.matcher(value);
		return matcher.matches();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		var message = "%s: Value does not match specified regex pattern; Value = %s Pattern = %s";
		return String.format(message, super.getFieldName(), super.getObject(), pattern);
	}

}
