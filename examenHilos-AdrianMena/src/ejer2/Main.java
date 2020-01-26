package ejer2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_STUDENTS = 10;
    public static void main(String[] args) {
        new Thread(new Teacher("Teacher")).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER_OF_STUDENTS,
                new OpenedBarrierAction());
        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            new Thread(new Student("Student #" + i, cyclicBarrier), "Student #" + i).start();
        }
    }
}
