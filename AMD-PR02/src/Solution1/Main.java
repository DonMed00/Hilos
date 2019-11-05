package Solution1;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa(5);
        Thread thread1 = new Thread(new Filosofo("Platon",mesa));
        Thread thread2 = new Thread(new Filosofo("Socrates",mesa));
        Thread thread3 = new Thread(new Filosofo("Descartes",mesa));
        Thread thread4 = new Thread(new Filosofo("Agustin",mesa));
        Thread thread5 = new Thread(new Filosofo("Tomás",mesa));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
