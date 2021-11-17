package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.Range;

public class RangeValidator extends AbstractValidator{
	
	private double min;
	private double max;

	public RangeValidator(Object object, String fieldName, Range range) {
		super(object, fieldName, range);
		this.min = range.min();
		this.max = range.max();
	}

	@Override
	public boolean isValid() 
	{
		Number number = (Number)object;
		double value = number.doubleValue();
		return value >= min && value <= max;
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		var message = "%s: Field value is outside defined constraints! value = %f; min = %f; max = %f";
		return String.format(message, fieldName, object, min, max);
	}

}
