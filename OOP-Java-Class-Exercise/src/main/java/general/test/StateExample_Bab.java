package general.test;

public class StateExample_Bab 
{
	 static Context ctsx = StateExample_Asdqwe.ctx;

	public static void main(String[] args) 
	{
		ctsx.setState("Changed State in Bab");
		System.out.println(ctsx.getState());

	}

}
