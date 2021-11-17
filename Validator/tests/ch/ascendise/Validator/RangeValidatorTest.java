package ch.ascendise.Validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.ascendise.Validator.Annotations.Range;

class RangeValidatorTest {

	@Test
	void validFieldValue_MinValue()
	{
		class Test
		{
			@Range(min = 2.5)
			private double value = 2.6;
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "Value over min value considered invalid");
	}
	
	@Test
	void validFieldValue_MaxValue()
	{
		class Test
		{
			@Range(max = 2.5)
			private double value = 2.4;
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "Value under max value considered invalid");
	}
	
	@Test
	void validFieldValue_Range()
	{
		class Test
		{
			@Range(min = 2, max = 2.5)
			private double value = 2.2;
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "Value in range considered invalid");
	}
	
	@Test
	void invalidFieldValue_MinValue()
	{
		class Test
		{
			@Range(min = 2.5)
			private double value = 2.4;
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "Value under min value considered valid");
	}
	
	@Test
	void invalidFieldValue_MaxValue()
	{
		class Test
		{
			@Range(max = 2.5)
			private double value = 2.6;
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "Value over max value considered valid");
	}
	
	@Test
	void invalidFieldValue_Range()
	{
		class Test
		{
			@Range(min = 2, max = 2.5)
			private double value = 1.9;
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "Value out of range considered valid");
	}
	
	@Test
	void validIntegerValue()
	{
		class Test
		{
			@Range(min = 2.5, max = 4.5)
			private int value = 3;
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "Integer value in range considered invalid");
	}
	
	@Test
	void invalidIntegerValue()
	{
		class Test
		{
			@Range(min = 2.5, max = 4.5)
			private int value = 5;
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "Integer value out of range considered valid");
	}
}
