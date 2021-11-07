package ch.ascendise.Validator;

public abstract class AbstractValidator implements Validator 
{
	protected Object object;
	protected String fieldName;
	
	public AbstractValidator(Object object, String fieldName)
	{
		this.object = object;
		this.fieldName = fieldName;
	}
}
