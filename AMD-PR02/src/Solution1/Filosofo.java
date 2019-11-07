package Solution1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Filosofo implements Runnable {
    private String name;
    private Palillo palillo1;
    private Palillo palillo2;
    private boolean interrumpted =false;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Filosofo(String name, Palillo palillo1, Palillo palillo2) {
        this.name = name;
        this.palillo1 = palillo1;
        this.palillo2 = palillo2;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !interrumpted) {
            try {
                pensar();
                comer();
            } catch (InterruptedException e) {
                interrumpted = true;
                System.out.printf("%s . Me he interrumpido\n",name);

            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.printf("%s - %s . Estoy pensando\n",LocalDateTime.now().format(dateTimeFormatter),name);
        Thread.sleep(5000);
    }

    private void comer() throws InterruptedException {
        cogerTenedor();
        soltarTenedor();
        Thread.sleep(4000);

    }


    void cogerTenedor() throws InterruptedException {

        palillo1.coger(name);
        Thread.sleep(3000);
        palillo2.coger(name);
         Thread.sleep(2000);
    }

    void soltarTenedor() throws InterruptedException {
        Thread.sleep(3000);
        palillo1.soltar(name, false);
        palillo2.soltar(name, true);
        Thread.sleep(2000);

    }
}
