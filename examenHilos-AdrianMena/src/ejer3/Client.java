package ejer3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
     final int numClient;

    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    private  Caja caja;

    public Client(int numClient,Caja caja) {
        this.numClient = numClient;
        this.caja = caja;
    }

    @Override
    public void run() {
        try {
            arriveToSupermarket();
            arriveToQueue();
            buy();
        } catch (InterruptedException e) {
            System.out.printf("%s ->Client %d -> Interrupted at: %s\n",
                    Thread.currentThread().getName(), numClient,
                    dateTimeFormatter.format(LocalDateTime.now()));
        }

    }

    private void arriveToSupermarket() {
        System.out.printf("%s -> Client %d arrive to the supermarket\n", dateTimeFormatter.format(LocalDateTime.now()), numClient);

    }

    private void arriveToQueue() throws InterruptedException {
        int random = (int) ((Math.random() * 3) + 1);
        TimeUnit.SECONDS.sleep(random);
        caja.take();
        System.out.printf("%s -> Client %d: I am in the queue %s\n", dateTimeFormatter.format(LocalDateTime.now()), numClient,caja.number);
    }

    private void buy() throws InterruptedException {
        int random = (int) ((Math.random() * 4) + 1);
        TimeUnit.SECONDS.sleep(random);
        System.out.printf("%s -> Client %d: I have already purchased. I'm going home\n", dateTimeFormatter.format(LocalDateTime.now()), numClient);
        caja.drop();
    }
}
