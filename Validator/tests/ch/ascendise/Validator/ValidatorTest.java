package ch.ascendise.Validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	public static TestObject validTestObject = new TestObject();
	public static TestObject invalidTestObject = new TestObject();
	
	@BeforeAll
	static void setup()
	{
		initializeValidObject();
		initializeInvalidObject();
	}
	
	static void initializeValidObject()
	{
		validTestObject.setNotNull("");
		validTestObject.setMaxLength("1234567890123456789");
		validTestObject.setMinLength("1234");
		validTestObject.setRange("12345678");
		validTestObject.setNotBlank("a");
		validTestObject.setNotEmpty(" ");
	}

	static void initializeInvalidObject()
	{
		invalidTestObject.setNotNull(null);
		invalidTestObject.setMaxLength("123456789012345678901");
		invalidTestObject.setMinLength("1");
		invalidTestObject.setRange("12");
		invalidTestObject.setNotBlank(" ");
		invalidTestObject.setNotEmpty("");
	}
	
	@Test
	void validObject_isValid()
	{
		var validator = new ValidatorImpl(validTestObject);
		boolean isValid = validator.isValid();
		validator.getErrorMessage();
		assertTrue(isValid, "Valid object got identified as invalid");
	}
	
	@Test
	void invalidObject_isValid()
	{
		var validator = new ValidatorImpl(invalidTestObject);
		boolean isValid = validator.isValid();
		assertFalse(isValid, "Invalid object got identified as invalid");
	}
	
	@Test
	void invalidObject_getErrors()
	{
		var validator = new ValidatorImpl(invalidTestObject);
		String errorMessage = validator.getErrorMessage();
		System.out.println(errorMessage);
		assertFalse(errorMessage.isBlank(), "Error list does not contain all errors");
	}
	
	@Test
	void invalidObject_FieldNameInErrorMessage()
	{
		var validator = new ValidatorImpl(invalidTestObject);
		String errorMessage = validator.getErrorMessage();
		var fieldNames = getFieldNames(invalidTestObject.getClass());
		var containsAllFieldNames = true;
		for(var fieldName : fieldNames)
		{
			if(!errorMessage.contains(fieldName))
			{
				containsAllFieldNames = false;
				break;
			}
		}
		assertTrue(containsAllFieldNames, "Error Message does not contain all field names");
	}
	
	String[] getFieldNames(Class<?> type)
	{
		var fields = type.getFields();
		var fieldNames = new String[fields.length];
		for(int i = 0; i < fields.length; i++)
		{
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

}
