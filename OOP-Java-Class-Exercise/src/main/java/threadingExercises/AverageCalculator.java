package threadingExercises;

public class AverageCalculator 
{
    private int total = 0;
    private int count = 0;

    public synchronized void addToTotal(int number) {total += number;count++;}
    public synchronized double calculateAverage() {return count == 0 ? 0 : (double) total / count;}

	public int getTotal() {return total;}
	public int getCount() {return count;}
    
    
    
}
