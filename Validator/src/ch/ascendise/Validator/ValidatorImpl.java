package ch.ascendise.Validator;

public class ValidatorImpl<T> implements Validator{
	
	private T object;
	
	public ValidatorImpl(T object)
	{
		this.object = object;
	}
	
	@Override
	public boolean isValid() {
		throw new RuntimeException("Me no worky");
	}

	@Override
	public String getErrorMessage() {
		throw new RuntimeException("Me no worky");
	}

}
