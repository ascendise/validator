package ch.ascendise.Validator;

import static org.junit.jupiter.api.Assertions.*;

import ch.ascendise.Validator.Annotations.*;

import org.junit.jupiter.api.Test;

class NotEmptyValidatorTest {

	@Test
	void validFieldValue()
	{
		class Test
		{
			@NotEmpty
			private String notEmpty = "IHaveContent";
		}
		var validator = new ValidatorImpl<Test>(new Test());
		var isValid  = validator.isValid();
		assertTrue(isValid, "Correct field value got detected as invalid");
	}
	
	@Test
	void validFieldValue_whitespaceOnly()
	{
		class Test
		{
			@NotEmpty
			private String whitespace = "       ";
		}
		var validator = new ValidatorImpl<Test>(new Test());
		var isValid = validator.isValid();
		assertTrue(isValid, "Correct field value got detected as invalid");
	}
	
	@Test
	void invalidFieldValue_noCharacters()
	{
		class Test
		{
			@NotEmpty
			private String empty = "";
		}
		var validator = new ValidatorImpl<Test>(new Test());
		var isValid = validator.isValid();
		assertFalse(isValid, "Incorrect field value not detected");
	}
}
