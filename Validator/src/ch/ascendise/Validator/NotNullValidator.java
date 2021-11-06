package ch.ascendise.Validator;

public class NotNullValidator implements Validator{
	
	private Object object;
	private String fieldName;
	
	public NotNullValidator(Object object, String fieldName)
	{
		this.object = object;
		this.fieldName = fieldName;
	}

	@Override
	public boolean isValid() {
		return (object != null);
	}

	@Override
	public String getErrorMessage() {
		if(isValid())
		{
			return "";
		}
		return fieldName + ": Value is null";
	}

}
