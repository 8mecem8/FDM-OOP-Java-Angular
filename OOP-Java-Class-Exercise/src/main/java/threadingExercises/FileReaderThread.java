package threadingExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderThread extends Thread 
{
    private String fileName;
    private AverageCalculator averageCalculator;

    public FileReaderThread(String fileName, AverageCalculator averageCalculator) {this.fileName = fileName;this.averageCalculator = averageCalculator;}

    @Override
    public void run() 
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) //We open and close reader quickly , good trick
        {
            String line;
            
            while ((line = br.readLine()) != null) // we initialize the variable of line and check if it reads any data at the same time again very efficient !!
            {
                String[] numbers = line.split(",");
                
                for (String number : numbers) 
                {
                    averageCalculator.addToTotal(Integer.parseInt(number));
                }
            }
        } 
        catch (IOException e) {e.printStackTrace();}
    }
}
