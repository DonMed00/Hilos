import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DollMaker implements Runnable {
    private String name;
    private Basket dollbasket;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public DollMaker(String name, Basket dollbasket) {
        this.name = name;
        this.dollbasket = dollbasket;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            try {
                Doll doll = new Doll();
                poner(doll);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void poner(Doll doll) throws InterruptedException {
        int min = 4000;
        int max = 8000;
        Random random = new Random();
        int myRandomNumber = random.nextInt(max - min) + min;
        dollbasket.poner(doll);
        System.out.printf("%s - %s de tipo DollMaker ha colocado la muñeca %d en la primera cesta\n", LocalDateTime.now().format(dateTimeFormatter), getName(), doll.getnSerie());

        Thread.currentThread().sleep(myRandomNumber);
    }

    public String getName() {
        return name;
    }
}
