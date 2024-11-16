package threadingExercises;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    protected List<Thread> threads = new ArrayList<>();

    public void createThreads(int numThreads) {
        for (int i = 1; i <= numThreads; i++) {
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable, "thread" + i);
            threads.add(thread);
        }
    }

    public void runThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
