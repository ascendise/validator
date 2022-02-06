package ch.ascendise.Validator;

import java.util.regex.Pattern;

import ch.ascendise.Validator.Annotations.Regex;

/**
 * This is a validator for validating string fields with a pattern constraint.
 * @see Regex
 */
public final class RegexValidator extends AbstractValidator 
{
	
	private String pattern;

	/**
	 * Creates a new instance of the RegexValidator
	 * @param object Value that gets validated.
	 * @param fieldName Name of the field.
	 * @param regex Annotation the field was annotated with.
	 */
	protected RegexValidator(Object object, String fieldName, Regex regex) 
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
