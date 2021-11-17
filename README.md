# Validator

This validator is a lightweight and simple tool for validating Java Objects.

[Javadoc](https://ascendise.github.io/Validator)

## Create your own annotation for validating objects

For creating your validation annotation, there is not much needed.

Here is an example with the built-in Length-Annotation:

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorType(LengthValidator.class)
public @interface Length {
	
	int max() default Integer.MAX_VALUE;
	int min() default 0;

}
```
If you have ever worked with custom annotations before, most of it might seem familiar to you.
We want to annotate fields, so the annotation has `ElementType.FIELD` set as Target

We set the `RetentionPolicy` to `RUNTIME` so the API can see what annotations a field is using at runtime.

To validate our value, we need to be able to set a minimum and maximum length.

Now something is special about this annotation. It is annotated with `@ValidatorType`. This is not a native Java annotation!

With `@ValidatorType` we specify what class holds the logic to validate the annotated field.

### Here is how our validator-class could look like:
```java
public class LengthValidator extends AbstractValidator
{
	private int min;
	private int max;
	private String value;
	
	public LengthValidator(Object object, String fieldName, Length length)
	{
		super(object, fieldName, length);
		this.min = length.min();
		this.max = length.max();
		this.value = (String)object;
		if(value == null)
		{
			value = "";
		}
	}

	@Override
	public boolean isValid() 
	{
		int length = value.length();
		return length >= min && length <= max;
	}

	@Override
	public String getErrorMessage() 
	{
		if(isValid())
		{
			return "";
		}
		var message = "%s: Length of the value does not fit into constraints;Length = %d min = %d, max = %d";
		return String.format(message, fieldName, value.length(), min, max);
	}
}
```
There are two major things we have to look out for when implementing a custom validator.

First of all, it has to inherit the `AbstractValidator`. It defines how our validator should look and behave.

The second thing is the constructor. The constructor needs to exactly match the super constructor, down to the order.
This is because of how the `POJOValidator` works internally. It will create lots of small validators for all the annotated fields
with **Reflection** and then just iterate through all of them to check if the whole object is valid or to get all the different error messages.

Now how we implement the methods `isValid()` and `getErrorMessages()` is up to us. 
For `isValid()`, we want to return true, if the length of the string value fits into the specified constraints.

In `getErrorMessage()`, we return an explanation of why the value is not valid. This message should be as detailed as possible to help whoever
reads the message of finding the error and correcting it. 

And thats it.

Now we can annotate our fields with this annotation and let the `POJOValidator` do its magic!

```java
Person steve = new Person();
POJOValidator validator = new POJOValidator(steve);
if(!validator.isValid())
{
  System.out.println("Steve is not valid");
  System.out.println(validator.getErrorMessage());
}
```
