package ex3;


public class Main {
    public static void main(String[] args) {
        double contador=0;
        Hilo hilo1 = new Hilo(contador);
        Thread t1 = new Thread(new Incrementer(hilo1));
        Thread t2 = new Thread(new Incrementer(hilo1));
        Thread t3 = new Thread(new Incrementer(hilo1));


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

        System.out.println(hilo1.contador);

    }
}
