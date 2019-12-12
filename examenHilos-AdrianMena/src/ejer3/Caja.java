package ejer3;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Caja {
    int number;
    boolean taken;
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Caja(int number) {
        this.number = number;
        this.taken = false;
    }

    void take() throws InterruptedException {
        lock.lock();
        while (taken) {
            condition.await();
        }
        taken = true;
        lock.unlock();

    }

    void drop() throws InterruptedException {
        lock.lock();
        taken = false;
        condition.signal();

        lock.unlock();


    }

}
