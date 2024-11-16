package junit.test.exercises;

public class ExampleClass 
{


	public String combineText(String... text) 
	{
		var bigText = new String();
		
		for(var arg : text) 
		{
			bigText += arg;
		}
		
		return bigText;
	}
}
