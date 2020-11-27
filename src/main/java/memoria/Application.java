package memoria;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int COUNT = 0;
    private static volatile int VOLATILE_COUNT = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Runnable folyamat = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    increment();
                    VOLATILE_COUNT++;
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
        System.out.println("Eredmeny: " + COUNT);
        System.out.println("Volatile eredmeny: " + VOLATILE_COUNT);
    }

    private synchronized static void increment(){
        COUNT++;
    }
}
