package ch.ascendise.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * The object to be validated gets passed to this validator
 * The validator than gets all the validators for the object
 * specified by the annotations a field is annotated with.
 * 
 * The operations of this validator then iterate over all the validators
 * it has found and return a summary.
 *
 * The validator does not check any constraints directly, but is only responsible
 * for getting the results of the other validators.
 */
public final class POJOValidator implements Validator{
	
	private Object object;
	private List<Validator> validators;
	
	/**
	 * Gets all the validators for the object based on the annotated fields
	 * to be later used for other operations
	 * 
	 * @param object to be validated
	 */
	public POJOValidator(Object object)
	{
		this.object = object;
		validators = getValidators();
	}
	
	private List<Validator> getValidators()
	{
		var validators = new ArrayList<Validator>();
		var cls = object.getClass();
		var fields = cls.getDeclaredFields();
		for(var field : fields)
		{
			var factory = new ValidatorFactory(object, field);
			var fieldValidators = factory.getValidators();
			validators.addAll(fieldValidators);
		}
		return validators;
	}
	
	/**
	 * @return false if at least one field does not fit constraints.
	 */
	@Override
	public boolean isValid() 
	{
		for(var validator : validators)
		{
			if(!validator.isValid())
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * @return a summary of all invalid fields and a description of why they are invalid
	 */
	@Override
	public String getErrorMessage() 
	{
		StringBuilder errorMessage = new StringBuilder();
		for(var validator : validators)
		{
			var message = validator.getErrorMessage();
			if(!message.isBlank())
			{
				errorMessage.append(message + "\n");
			}
		}
		return errorMessage.toString();
	}

}
