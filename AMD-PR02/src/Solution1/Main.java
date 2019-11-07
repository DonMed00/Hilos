package Solution1;

class Main {
    public static void main(String[] args) {
        Stick stick1 = new Stick(0);
        Stick stick2 = new Stick(1);
        Stick stick3 = new Stick(2);
        Stick stick4 = new Stick(3);
        Stick stick5 = new Stick(4);
        Thread thread1 = new Thread(new Philosopher("Platon", stick1, stick2));
        Thread thread2 = new Thread(new Philosopher("Socrates", stick2, stick3));
        Thread thread3 = new Thread(new Philosopher("Descartes", stick3, stick4));
        Thread thread4 = new Thread(new Philosopher("Agustin", stick4, stick5));
        Thread thread5 = new Thread(new Philosopher("Tomás", stick1, stick5));

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

        System.out.println("Restaurant owner: Stop eating and thinking now. It's late!!");
    }
}
