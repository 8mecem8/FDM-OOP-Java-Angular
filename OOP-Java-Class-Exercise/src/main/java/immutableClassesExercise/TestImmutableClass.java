package immutableClassesExercise;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;

import general.test.Log;

public class TestImmutableClass 
{
	
	static Logger log = Log.getInstance().getLogger();

	public static void main(String[] args) 
	{

		 // Create 3 Trainee objects
        Trainee trainee1 = new Trainee("Alice", "Java", 1);
        Trainee trainee2 = new Trainee("Bob", "C++", 2);
        Trainee trainee3 = new Trainee("Charlie", "Python", 3);
		

        // Create an ArrayList of Trainee objects and add the 3 trainee objects to it
        var traineeList = Arrays.asList(trainee1,trainee2,trainee3);
        
        
        // Create a Trainer object
        Trainer trainer = new Trainer("Trainer1");
        
        
        // Add 3 different streams
        trainer.addStream("Java");
        trainer.addStream("C++");
        trainer.addStream("Python");
        
        
        // Create a CompletedClass object
        CompletedClass completedClass = new CompletedClass("Programming101", trainer, traineeList);
        
        
        // Change the value of the week attribute for each of your Trainee objects
        trainee1.setWeek(5);
        trainee2.setWeek(6);
        trainee3.setWeek(7);
        
        // Verify that the week attribute for each of the trainees has not been changed
        for (Trainee trainee : completedClass.getTrainees()) {log.info(trainee.getName() + ": " + trainee.getWeek());}
        
        
        // Add the name of a new stream
        trainer.addStream("JavaScript");
        
        // Verify that this still contains only 3 streams
        for (String stream : completedClass.getTrainer().getAllStreams()) {log.info(stream);}
        

	}

}
