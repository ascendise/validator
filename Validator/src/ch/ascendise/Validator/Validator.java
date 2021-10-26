package ch.ascendise.Validator;

public class Validator<T> {
	
	private T object;
	
	public Validator(T object)
	{
		this.object = object;
	}

	public boolean IsValid() {
		throw new RuntimeException("Me no worky");
	}

	public String[] getErrors() {
		throw new RuntimeException("Me no worky");
	}

}
