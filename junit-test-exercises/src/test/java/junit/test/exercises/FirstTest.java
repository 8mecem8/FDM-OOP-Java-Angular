package junit.test.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FirstTest 
{

	@Test
	void testTheCombinationOftheWordsAddedaAllTogetherAsPassedStringArgumentstoMethod() 
	{
		//arrange
		ExampleClass item = new ExampleClass();
		String name = "John";
		String othername = "Boris";
		
		String expected = name+othername;
		
		
		//act
		String result = item.combineText(name,othername);
		
		
		//assert
		
		assertEquals(result, expected);
	}

	
	//arrange
	//act
	//assert
}
