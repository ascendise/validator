package ch.ascendise.Validator;

import ch.ascendise.Validator.Annotations.Range;

/**
 * This is a validator for validating numerical fields with a Range-Constraint
 * @see Range 
 */
public final class RangeValidator extends AbstractValidator{
	
	private double min;
	private double max;

	/**
	 * Creates a new instance of the RangeValidator
	 * @param object Value that gets validated.
	 * @param fieldName Name of the field.
	 * @param range Annotation the field was annotated with.
	 */
	protected RangeValidator(Object object, String fieldName, Range range) {
		super(object, fieldName, range);
		this.min = range.min();
		this.max = range.max();
	}

	@Override
	public boolean isValid() 
	{
		Number number = (Number)super.getObject();
		if(number == null)
		{
			return false;
		}
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
		var message = "%s: Field value is outside defined constraints! value = %s; min = %f; max = %f";
		return String.format(message, super.getFieldName(), super.getObject(), min, max);
	}

}
