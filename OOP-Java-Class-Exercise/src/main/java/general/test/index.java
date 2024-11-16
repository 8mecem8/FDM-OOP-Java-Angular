package general.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Logger;

public class index 
{
	static Logger log = Log.getInstance().getLogger();
	
	static class StaticNestedClass 
	{
        static void display() 
        {
            System.out.println("Inside static nested class.");
        }
    }
	

	public static void main(String[] args) 
	{
		
		
		
		Integer a = Integer.valueOf(5);
		Double b = Double.valueOf(3.14);
		Character c = Character.valueOf('A');  
		Boolean d = Boolean.valueOf(true);
		String e = new String("zurna");
		Character f = 'f';
		String g = String.valueOf(a);
		
		
		var anyArray = new Object[] {34, "hgff"};
		Object[] shortAnyarray = {"asd",233};
		var anyArrayList = new ArrayList<>(Arrays.asList(23.344, "burma",'s'));
		var shortanyArrayList = Arrays.asList(76.532, "holulu",'L');
		
		//System.out.println(shortanyArrayList instanceof List);
		//System.out.println(shortanyArrayList+"\n"+anyArrayList+"\n"+Arrays.toString(shortAnyarray));
		//System.out.println(anyArrayList.toString());
		//System.out.println(a+ " " + b + " " + c + " " + d + " "+ e+ " "+f+ " "+ g + "is this a string : " +(g instanceof String));
		
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		//System.out.println(str1.equals(str2));  // true, because the content of the object`s are the same
		//System.out.println(str1 == str2); // false, because they are different objects in memory
		
		//System.out.println(new Object().equals(new Object()));
		//System.out.println(new String().equals(new String())); // String object overrides the equals method to compare content/value
		//System.out.println(new String() == new String()); // false, because they are different objects in memory
		//System.out.println(new Object() == new Object()); // false, because they are different objects in memory
		//System.out.println(new String().getClass());
		
		
		
		StringBuffer exampleWordForStringBuffer = new StringBuffer("Hello");
		exampleWordForStringBuffer.append(", World!");
		//System.out.println(exampleWordForStringBuffer);
		
		
		//StaticNestedClass startNestedClass = new StaticNestedClass();
		//index.StaticNestedClass startNestedClass = new index.StaticNestedClass(); //instantiate static the inner class without having an  instance of the outer class
		//startNestedClass.display();
		//index.StaticNestedClass.display(); //can be accessible because of being static method at inner class
		
		
		/*====================================================================================================*/
		// Vector example
		Vector<String> vector = new Vector<>();
		vector.add("vectorApple");
		vector.add("vectorBanana");
		vector.add("vectorCherry");

		// ArrayList example
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("arrayListApple");
		arrayList.add("arrayListBanana");
		arrayList.add("arrayListCherry");
		arrayList.add(null);

		//Example 2: Iterating over the collection

		// Vector example
		Enumeration<String> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) 
		{
		    String fruit = enumeration.nextElement();
		    System.out.println(fruit);
		}

		// ArrayList example
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) 
		{
		    String fruit = iterator.next();
		    System.out.println(fruit);
		}
		/*====================================================================================================*/
		
		log.info(
				arrayList.stream().filter(Objects::nonNull)
				.collect(Collectors.toList()));
		
		Stream.iterate(0, arg -> arg+2).limit(10).forEach(System.out::println);
		Stream.iterate(arrayList, arg -> arg).limit(1).forEach(System.out::println);
		
		
		Map<String, String> mp = Stream.of(new String[][] {{ "1", "Zurna" },{ "2", "Kurna" },{ "3", "Burma" } })
              .collect( Collectors.collectingAndThen(Collectors.toMap(p -> p[0], p -> p[1]),Collections::<String, String> unmodifiableMap));
		
		log.info(mp);
	}

}
