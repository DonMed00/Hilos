package ejer1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskConsumer implements Runnable {
    private final CompletionService<Pieza> completionService;

    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    TaskConsumer(CompletionService<Pieza> completionService) {
        this.completionService = completionService;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Future<Pieza> taskResultFuture;
            try {
                taskResultFuture = completionService.take();
                if (taskResultFuture != null) {
                    Pieza pieza = taskResultFuture.get();
                    showResult(pieza);
                }
            } catch (InterruptedException e) {
                System.out.printf("%s -> Task consumer interrupted\n",
                        Thread.currentThread().getName());
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s -> Task consumer finished\n",
                Thread.currentThread().getName());
    }
    private void showResult(Pieza pieza) {
        String when = dateTimeFormatter.format(LocalDateTime.now());
        System.out.printf("%s -> Task consumer get Pieza (%d) at %s\n",
                Thread.currentThread().getName(), pieza.nPieza,when);
    }
}
