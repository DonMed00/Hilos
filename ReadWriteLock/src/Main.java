import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Product product = new Product(100.00);
        Thread clientThreads[]= new Thread[8];
        for (int i = 0; i < 8; i++) {
            clientThreads[i] = new Thread(new Client(product), "Client " + i);
        }
        Thread shopThread = new Thread(new Shop(product), "Shop");
        shopThread.start();
        // Wait to start some clients.
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i < 4; i++){
            clientThreads[i].start();
        }
        // Wait to start the rest of the clients.
        TimeUnit.SECONDS.sleep(2);
        for (int i = 4; i < 8; i++){
            clientThreads[i].start();
        }
        // Try and check a client thread blocks the shop thread but not other clients threads.
        // Try and check the shop thread blocks client threads.
    }

}