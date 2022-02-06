package ch.ascendise.Validator;

import java.util.regex.Pattern;

import ch.ascendise.Validator.Annotations.Email;

/**
 * This is a validator for validating email fields.
 * 
 */
public final class EmailValidator extends AbstractValidator
{

	/**
	 * Creates a new instance of the EmailValidator.
	 * @param object Value that gets validated.
	 * @param fieldName Name of the field.
	 * @param annotation Annotation the field was annotated with
	 */
	protected EmailValidator(Object object, String fieldName, Email annotation)
	{
		super(object, fieldName, annotation);
	}

	@Override
	public boolean isValid() 
	{
		if(super.getObject() == null)
		{
			return false;
		}
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
