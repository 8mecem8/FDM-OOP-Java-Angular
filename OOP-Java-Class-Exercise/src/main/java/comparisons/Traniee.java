package comparisons;

public class Traniee implements Comparable <Traniee>
{
	private String Name;
	private Integer Age;
	
	
	public Traniee(String name, Integer age) 
	{
		super();
		Name = name;
		Age = age;
	}
	
	public String getName() {return Name;	}
	public void setName(String name) {Name = name;}
	public Integer getAge() {return Age;}
	public void setAge(Integer age) {	Age = age;}

	
	@Override
	public int compareTo(Traniee o) {
		
		return Name.compareTo(o.getName());
	}

	@Override
	public String toString() {return "Traniee [Name=" + Name + ", Age=" + Age + "]";}
	
	

}
 