package general.test;

//public class test {
//
//	public static void main(String[] args) 
//	{
//		try 
//        {
//            System.out.println("Inside try block");
//            System.exit(0); // JVM exits here
//        } 
//        catch (Exception e) {
//            System.out.println("Inside catch block");
//        } 
//        finally 
//        {
//            System.out.println("Inside finally block"); // This will not be executed
//        }
//
//	}
//
//}



/**
 * Builder Design Pattern in Java
 */
public class BuilderDesignPatternTest {
	  private String cpu;  private int ram;  private String storage;

	  // Constructor with many arguments (less ideal)
	  public BuilderDesignPatternTest(String cpu, int ram, String storage) {this.cpu = cpu; this.ram = ram;  this.storage = storage; }

	  // Builder class
	  public static class Builder 
	  {
		 private String cpu;
		 private int ram;
		 private String storage;
	
		 public Builder setCpu(String cpu) { this.cpu = cpu;  return this; } // Must return current object/class with this keyword to be able to use method chaining 
		 public Builder setRam(int ram) { this.ram = ram;  return this; }
		 public Builder setStorage(String storage) { this.storage = storage; return this; }
		    
		 public BuilderDesignPatternTest build() {return new BuilderDesignPatternTest(cpu, ram, storage);}
	
	  }
		  
	  @Override
	  public String toString() {return "test [cpu=" + cpu + ", ram=" + ram + ", storage=" + storage  + "]";}

	
	  public static void main(String[] args) 
	  {
	    BuilderDesignPatternTest gamingPC = new BuilderDesignPatternTest.Builder()
	        .setCpu("i7-12700K")
	        .setRam(32)
	        .setStorage("1TB SSD")
	        .build();
	    
	    System.out.println(gamingPC);
	  }
	}
