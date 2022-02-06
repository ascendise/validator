package ch.ascendise.Validator;

/**
 * The Validator is responsible for making sure that a value
 * fits into the specified constraints
 * <br>
 * It returns if the value fits the constraints or not and also provides
 * a descriptive error message.
 * <br>
 */
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
