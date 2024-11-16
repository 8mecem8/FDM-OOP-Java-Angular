package general.test;


class CustomNameException extends Exception{public CustomNameException(String message) {super(message);	}}
class AnotherCustomNameException extends Exception{public AnotherCustomNameException() {super();}}


public class TryandCatch 
{

	public static void main(String[] args) 
	{
		
		Integer testA = null;
		String testString = "";
		
		try 
		{
//			int result =(int) testA * 2;
//			
			int zu = anymethod();
			
			if(testString.length() <= 0)
			{
				throw new CustomNameException("String has no value");
			}
			
			
		} 
		catch (CustomNameException e) 
		{
			System.out.println(e);
		}
		catch (AnotherCustomNameException e) 
		{
			System.out.println(e);
		}
//		catch (NullPointerException e) 
//		{
//			System.out.println("There is an interesting exception oowwww " + e);
//		}
//		catch(Exception e) 
//		{
//			e.printStackTrace(""); 
//		}

	}
	
	
	public static Integer anymethod() throws AnotherCustomNameException
	{
		var bArray = new Integer[3];
		return bArray[1];
		
	}

}
