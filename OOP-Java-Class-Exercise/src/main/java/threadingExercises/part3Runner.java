package threadingExercises;

public class part3Runner 
{

	public static void main(String[] args) throws InterruptedException 
	{
        AverageCalculator averageCalculator = new AverageCalculator();
        String fileName = "c:\\temp\\TestRecords.txt";

        FileReaderThread fileReaderThread = new FileReaderThread(fileName, averageCalculator);
        fileReaderThread.start();
        fileReaderThread.join();

        System.out.println("Total: " + averageCalculator.getTotal());
        System.out.println("Count: " + averageCalculator.getCount());
        System.out.println("Average: " + averageCalculator.calculateAverage());
    }
}
