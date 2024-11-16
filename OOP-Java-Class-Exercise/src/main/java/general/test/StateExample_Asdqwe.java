package general.test;




//Context class
class Context 
{
	private static Context instance;
	private String state="TTT";

	public static synchronized Context getInstance(){if (instance == null) {instance = new Context();} return instance;}

	public void setState(String state) {this.state = state;}
	public String getState() {return this.state;}
}



public class StateExample_Asdqwe 
{
	public static Context ctx = Context.getInstance();
		
	
	public static void main(String[] args)
    {
		StateExample_Ab deneme = new StateExample_Ab(ctx);
		
		System.out.println(ctx.getState());
		deneme.setControlState("deneme changed the state");
		//ctx.setState("State Has changed");
		System.out.println(ctx.getState());
    }

}
