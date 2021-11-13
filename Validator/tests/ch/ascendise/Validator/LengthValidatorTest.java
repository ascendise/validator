package ch.ascendise.Validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.ascendise.Validator.Annotations.Length;

class LengthValidatorTest {

	@Test
	void minLength_valid()
	{
		class Test
		{
			@Length(min = 3)
			public String minLength = "123";
		}
		var validator = new POJOValidator(new Test());
		var isValid = validator.isValid();
		assertTrue(isValid, "Valid field failed");
	}

	@Test
	void minLength_invalid()
	{
		class Test
		{
			@Length(min = 3)
			public String minLength = "12";
		}
		var validator = new POJOValidator(new Test());
		var isValid = validator.isValid();
		assertFalse(isValid, "Field with not enough characters passed");
	}

	@Test
	void maxLength_valid()
	{
		class Test
		{
			@Length(max = 5)
			public String maxLength = "12345";
		}
		var validator = new POJOValidator(new Test());
		var isValid = validator.isValid();
		assertTrue(isValid, "Valid field failed");
	}

	@Test
	void maxLength_invalid()
	{
		class Test
		{
			@Length(max = 5)
			public String maxLength = "123456";
		}
		var validator = new POJOValidator(new Test());
		var isValid = validator.isValid();
		assertFalse(isValid, "Field with too many characters passed");
	}

	@Test
	void range_valid()
	{
		class Test
		{
			@Length(min = 2, max = 4)
			public String range = "123";
		}
		var validator = new POJOValidator(new Test());
		var isValid = validator.isValid();
		assertTrue(isValid, "Valid field failed");
	}

	@Test
	void range_invalid_notEnoughCharacters()
	{
		class Test
		{
			@Length(min = 2, max = 4)
			public String range = "1";
		}
		var validator = new POJOValidator(new Test());
		var isValid = validator.isValid();
		assertFalse(isValid, "Field with not enough characters passed");
	}

	@Test
	void range_invalid_tooManyCharacters()
	{
		class Test
		{
			@Length(min = 2, max = 4)
			public String range = "12345";
		}
		var validator = new POJOValidator(new Test());
		var isValid = validator.isValid();
		assertFalse(isValid, "Field with too many characters passed");
	}

}
