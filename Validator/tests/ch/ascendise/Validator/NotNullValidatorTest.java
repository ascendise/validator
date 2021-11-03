package ch.ascendise.Validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.ascendise.Validator.Annotations.*;

class NotNullValidatorTest {

	@Test
	void validFieldValue()
	{
		class Test
		{
			@NotNull
			private Object notNull = new Object();
		}
		var validator = new ValidatorImpl(new Test());
		var isValid = validator.isValid();
		assertTrue(isValid, "Field got falsely detected as invalid");
	}
	
	@Test
	void invalidFieldValue()
	{
		class Test
		{
			@NotNull
			private Object isNull = null;
		}
		var validator = new ValidatorImpl(new Test());
		var isValid = validator.isValid();
		assertFalse(isValid, "Null field did not get detected as null");
	}
	
	@Test
	void primitiveTypeField()
	{
		class Test
		{
			@NotNull
			private int someField;
		}
		var validator = new ValidatorImpl(new Test());
		var isValid = validator.isValid();
		assertTrue(isValid, "Primitive type field detected with value null");
	}

}
