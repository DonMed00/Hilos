package ejer2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Teacher implements Runnable {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final Random random = new Random();
    private final String name;

    public Teacher(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            repartirExamen();
            System.out.println("Starting the test of topic 1");
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted while giving the exams\n",name);
            return;
        }
    }

    private void repartirExamen() throws InterruptedException {
        System.out.printf("%s -> %s - Exams delivered\n",dateTimeFormatter.format(LocalDateTime.now()),name);
        TimeUnit.SECONDS.sleep(random.nextInt(3) + 1);
    }
}
