package ex2;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        LongAdder contador = new LongAdder();
        Thread t1 = new Thread(new Hilo(contador));
        Thread t2 = new Thread(new Hilo(contador));
        Thread t3 = new Thread(new Hilo(contador));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(contador);

    }
}
