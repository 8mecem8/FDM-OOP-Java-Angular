package threadingExercises;

public class ThreadManagerChild extends ThreadManager 
{
    @Override
    public void createThreads(int numThreads) 
    {
        for (int i = 1; i <= numThreads; i++) 
        {
            Runnable myRunnable = () -> System.out.println(Thread.currentThread().getName() + " is running");
            Thread thread = new Thread(myRunnable, "thread" + i);
            super.threads.add(thread);
        }
    }
}