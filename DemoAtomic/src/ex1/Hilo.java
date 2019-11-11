package ex1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Hilo implements Runnable{

    private AtomicLong contador;

    public Hilo(AtomicLong contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            contador.incrementAndGet();
        }

    }


}
