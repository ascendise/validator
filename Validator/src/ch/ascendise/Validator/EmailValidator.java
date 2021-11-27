package ch.ascendise.Validator;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

public class EmailValidator extends AbstractValidator
{

	public EmailValidator(Object object, String fieldName, Annotation annotation)
	{
		super(object, fieldName, annotation);
	}

	@Override
	public boolean isValid() 
	{
		String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		var pattern = Pattern.compile(emailRegex);
		var email = (String)super.getObject();
		var matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		var message = "%s: Email is not valid: %s";
		return String.format(message, super.getFieldName(), super.getObject());
	}

}
