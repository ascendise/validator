package ch.ascendise.Validator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorImpl implements Validator{
	
	private Object object;
	private List<Validator> validators;
	
	public ValidatorImpl(Object object)
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

	@Override
	public String getErrorMessage() 
	{
		StringBuilder errorMessage = new StringBuilder();
		for(var validator : validators)
		{
			var message = validator.getErrorMessage() + "\n";
			errorMessage.append(message);
		}
		return errorMessage.toString();
	}

}
