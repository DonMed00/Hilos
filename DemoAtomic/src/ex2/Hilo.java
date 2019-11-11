package ex2;

import java.util.concurrent.atomic.LongAdder;

public class Hilo implements Runnable{

    private LongAdder contador;

    public Hilo(LongAdder contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            contador.add(1);
        }

    }


}
