package Solution2;

public class Main {
    public static void main(String[] args) {
        Palillo palillo1 = new Palillo(0);
        Palillo palillo2 = new Palillo(1);
        Palillo palillo3 = new Palillo(2);
        Palillo palillo4 = new Palillo(3);
        Palillo palillo5 = new Palillo(4);
        Thread thread1 = new Thread(new Filosofo("Platon",palillo1,palillo2));
        Thread thread2 = new Thread(new Filosofo("Socrates",palillo2,palillo3));
        Thread thread3 = new Thread(new Filosofo("Descartes",palillo3,palillo4));
        Thread thread4 = new Thread(new Filosofo("Agustin",palillo4,palillo5));
        Thread thread5 = new Thread(new Filosofo("Tomás",palillo1,palillo5));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
