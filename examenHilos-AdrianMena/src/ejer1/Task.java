package ejer1;

import java.util.Random;
import java.util.concurrent.Callable;


class Task implements Callable<Pieza> {
     int nTask;
    private final Random random = new Random();

    Task(int nTask) {
        this.nTask = nTask;
    }


    @Override
    public Pieza call() throws InterruptedException {
        return new Pieza();
    }

    }
