package Solution2;

class Main {
    public static void main(String[] args) {
        Camarero camarero = new Camarero();
        Palillo palillo1 = new Palillo(0);
        Palillo palillo2 = new Palillo(1);
        Palillo palillo3 = new Palillo(2);
        Palillo palillo4 = new Palillo(3);
        Palillo palillo5 = new Palillo(4);
        Thread thread1 = new Thread(new Filosofo("Platon", palillo1, palillo2, camarero));
        Thread thread2 = new Thread(new Filosofo("Socrates", palillo2, palillo3, camarero));
        Thread thread3 = new Thread(new Filosofo("Descartes", palillo3, palillo4, camarero));
        Thread thread4 = new Thread(new Filosofo("Agustin", palillo4, palillo5, camarero));
        Thread thread5 = new Thread(new Filosofo("Tomás", palillo1, palillo5, camarero));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            Thread.sleep(60000);
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
            thread4.interrupt();
            thread5.interrupt();


            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Dueño del bar: Dejar de comer y pensar ya, que es tarde");
    }
}
