package Solution2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Filosofo implements Runnable {
    private String name;
    private Palillo palillo1;
    private Palillo palillo2;
    private boolean interrumpted =false;
    Camarero camarero;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Filosofo(String name, Palillo palillo1, Palillo palillo2,Camarero camarero) {
        this.name = name;
        this.palillo1 = palillo1;
        this.palillo2 = palillo2;
        this.camarero=camarero;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !interrumpted) {
            try {
                pensar();
                camarero.comprobarPalillos(palillo1,palillo2,name);
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
}
