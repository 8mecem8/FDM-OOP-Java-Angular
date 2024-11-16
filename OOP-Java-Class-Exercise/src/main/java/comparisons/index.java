package comparisons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import log4j2.exercise.SalaryTaxCalculator;

public class index 
{
	 private static final Logger logger = LogManager.getLogger(SalaryTaxCalculator.class);

	public static void main(String[] args) 
	{
		Traniee person1 = new Traniee("Samet", 34);
		Traniee person2 = new Traniee("Ucar Veli", 23);
		Traniee person3 = new Traniee("Charlie", 78);
		Traniee person4 = new Traniee("Ahmet", 45);
		Traniee person5 = new Traniee("Jose", 16);
		
		logger.info(person4.compareTo(person5));
		
		
		List<Traniee> pool = Arrays.asList(person1,person2,person3,person4,person5);
		
		logger.info(pool);
		
		Collections.sort(pool);
		
		logger.info(pool);
		
		
		Set<Traniee> treeSet = new TreeSet<>(pool);
		
		treeSet.stream().map(arg -> arg).forEach(logger::info);
	}

}
