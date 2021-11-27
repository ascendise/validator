package ch.ascendise.Validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.ascendise.Validator.Annotations.Email;

public class EmailValidatorTest 
{

	@Test
	void validEmail()
	{
		class Test
		{
			@Email
			private String email = "user@domain.com";
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "valid email failed");
	}
	
	@Test
	void validEmail_ip()
	{
		class Test
		{
			@Email
			private String email = "user@[10.9.8.7]";
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "valid email failed");
	}
	
	@Test
	void validEmail_localhost()
	{
		class Test
		{
			@Email
			private String email = "user@localhost.home";
		}
		var validator = new POJOValidator(new Test());
		assertTrue(validator.isValid(), "valid email failed");
	}
	
	@Test
	void invalidEmail_noDomain()
	{
		class Test
		{
			@Email
			private String email = "user@.ru";
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "email without domain passed");
	}
	
	@Test
	void invalidEmail_noUsername()
	{
		class Test
		{
			@Email
			private String email = "@domain.ch";
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "email without domain passed");
	}
	
	@Test
	void invalidEmail_doubleAt()
	{
		class Test
		{
			@Email
			private String email = "user@domain@domain2.th";
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "email without domain passed");
	}
	
	@Test
	void invalidEmail_noEnding()
	{
		class Test
		{
			@Email
			private String email = "user@domain";
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "email without domain passed");
	}
	
	@Test
	void invalidEmail_nullValue()
	{
		class Test
		{
			@Email
			private String email = null;
		}
		var validator = new POJOValidator(new Test());
		assertFalse(validator.isValid(), "null value as email passed");
	}
	
	
	

}
