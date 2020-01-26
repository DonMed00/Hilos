package ejer1;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.TimeUnit;

public class TaskProducer implements Runnable {
    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    private final String name;
    private final CompletionService<Pieza> completionService;
    private int max;
    private final Random random = new Random();


    TaskProducer(String name, CompletionService<Pieza> completionService, int max) {
        this.name = name;
        this.completionService = completionService;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 0; i < max; i++) {
            String when = dateTimeFormatter.format(LocalDateTime.now());
            Task task = new Task(i);
            completionService.submit(task);
            System.out.printf("%s -> %s produce pieza en la Tarea(%d) at %s\n",
                    Thread.currentThread().getName(), name, i, when);
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(3) + 1);
            } catch (InterruptedException e) {
                System.out.printf("%s -> %s interrupted\n",
                        Thread.currentThread().getName(), name);
                return;
            }
        }
        System.out.printf("%s -> %s finished\n",
                Thread.currentThread().getName(), name);
    }
}
