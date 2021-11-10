package ch.ascendise.Validator;

public interface Validator {
	
	/**
	 * @return true, if value meets specified constraints
	 */
	public boolean isValid();
	
	/**
	 * @return an error message describing the field that violates the constraints
	 * OR an empty string if the field is valid
	 */
	public String getErrorMessage();

}
