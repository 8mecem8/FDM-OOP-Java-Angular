package general.test;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Collections_exercises 
{
	public static HashSet<Object> eliminateDuplicates(String... names) 
	{
        var uniqueNames = new HashSet<>();
        
        for (String name : names) 
        {
            uniqueNames.add(name);
        }
        
        return uniqueNames;
    }
	
	public static Map<String, Color> getPredefinedColors() 
	{
	        Map<String, Color> colorMap = new HashMap<>();
	        colorMap.put("Red", Color.RED);
	        colorMap.put("Blue", Color.BLUE);
	        colorMap.put("Green", Color.GREEN);
	        colorMap.put("Yellow", Color.YELLOW);
	        colorMap.put("Black", Color.BLACK);
	        colorMap.put("White", Color.WHITE);
	        colorMap.put("Gray", Color.GRAY);
	        colorMap.put("Cyan", Color.CYAN);
	        colorMap.put("Magenta", Color.MAGENTA);
	        colorMap.put("Orange", Color.ORANGE);
	        colorMap.put("Pink", Color.PINK);
	        colorMap.put("Light Gray", Color.LIGHT_GRAY);
	        colorMap.put("Dark Gray", Color.DARK_GRAY);
	        return colorMap;
    }
	 
	public static Map<Character, Integer> countLetterOccurrences(String string) 
	{
	        Map<Character, Integer> letterCount = new HashMap<>();
	        
	        for (var arg : string.toCharArray()) 
	        {
	            if (Character.isLetter(arg)) 
	            {
	                letterCount.put(arg, letterCount.getOrDefault(arg, 0) + 1);
	            }
	        }
	        
	        return letterCount;
	}

	
	public static int countDuplicateWords(String sentence) 
	{
	        String[] words = sentence.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
	        Map<String, Integer> wordCount = new HashMap<>();
	        for (String word : words) {
	            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
	        }
	        int duplicates = 0;
	        for (int count : wordCount.values()) {
	            if (count > 1) {
	                duplicates++;
	            }
	        }
	        return duplicates;
	 }
	 

	public static void main(String[] args) 
	{
		Set<Object> names = eliminateDuplicates("John", "Jane", "John", "Alice", "Bob", "Alice");
        System.out.println(names); 
        
        Map<String, Color> colors = getPredefinedColors();
        System.out.println(colors);
        
        String text = "HELLO THERE";
        Map<Character, Integer> occurrences = countLetterOccurrences(text);
        System.out.println(occurrences);
        
        String sentence = "The the THE dog is brown BrOwN.";
        int duplicateCount = countDuplicateWords(sentence);
        System.out.println(duplicateCount); // Output: 2

	}

}
