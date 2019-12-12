package ejer1;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<Pieza> completionService
                = new ExecutorCompletionService<>(executor);
        Thread taskProducer1 = new Thread(new TaskProducer("Task producer 1",
                completionService,15));
        Thread taskProducer2 = new Thread(new TaskProducer("Task producer 2",
                completionService,20));
        Thread taskConsumer = new Thread(new TaskConsumer(completionService));
        taskProducer1.start();
        taskConsumer.start();
        try {
            TimeUnit.SECONDS.sleep(10);
            taskProducer2.start();

            TimeUnit.SECONDS.sleep(40);

            taskProducer1.interrupt();
            taskProducer2.interrupt();
            taskConsumer.interrupt();

            taskConsumer.join();

        } catch (InterruptedException ignored) {
        } finally {
            executor.shutdownNow();
        }
    }
}
