package ejer2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable{
    private final String name;
    private final CyclicBarrier cyclicBarrier;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final Random random = new Random();


    public Student(String name, CyclicBarrier cyclicBarrier) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(cyclicBarrier);
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            doTest(1);
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted while doing the test 1\n", name);
            return;
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.printf("%s has been interrupted while waiting for students in the class\n", name);

        }
        try {
            doTest(2);
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted while doing the test 2\n", name);
            return;
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.printf("%s has been interrupted while waiting for students in the class\n", name);

        }
        try {
            doLastTest();
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted while doing the test 3\n", name);
            return;
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.printf("%s has been interrupted while waiting for students in the class\n", name);

        }
    }

    private void doLastTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(random.nextInt(5) + 1);
        System.out.printf("%s -> %s - Last test finished. See you\n",dateTimeFormatter.format(LocalDateTime.now()),name);
    }

    private void doTest(int number) throws InterruptedException {
        TimeUnit.SECONDS.sleep(random.nextInt(5) + 1);
        System.out.printf("%s -> %s - Test %d Finished\n",dateTimeFormatter.format(LocalDateTime.now()),name,number);
    }
}
