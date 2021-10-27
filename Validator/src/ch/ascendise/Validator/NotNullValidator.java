package ch.ascendise.Validator;

public class NotNullValidator implements Validator{
	
	private Object object;
	
	public NotNullValidator(Object object)
	{
		this.object = object;
	}

	@Override
	public boolean isValid() {
		return (object != null);
	}

	@Override
	public String getErrorMessage() {
		return "Field is null";
	}

}
