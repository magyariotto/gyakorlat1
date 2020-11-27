package monitor;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int COUNTER = 0;
    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Runnable folyamat = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    synchronized (MONITOR){
                        COUNTER++;
                    }
                }
            }
        };

        for(int i = 0; i < 10; i++){
            threads.add(new Thread(folyamat));
        }

        for(Thread thread : threads){
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println(COUNTER);
    }
}
