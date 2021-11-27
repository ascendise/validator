package ch.ascendise.Validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.ascendise.Validator.Annotations.Regex;

class RegexValidatorTest 
{
	
	private final String pattern = "^[0-9][0-9][0-9] dwarfs are digging a hole. ...... Diggidy diggidy hole";
	
	@Test
	void validRegex()
	{
		class Test
		{
			@Regex(pattern)
			private String value = "150 dwarfs are digging a hole. BamBam Diggidy diggidy hole";
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "Valid regex failed");
	}
	
	@Test
	void invalidRegex()
	{
		class Test
		{
			@Regex(pattern)
			private String value = "epwmfpowekfopewkf";
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "Invalid regex passed");
	}
	

}
