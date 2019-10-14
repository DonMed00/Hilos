import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tailor implements Runnable {
    private String name;
    private Basket dollbasket;
    private Basket dressedBasket;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Tailor(String name, Basket dollbasket, Basket dressedBasket) {
        this.name = name;
        this.dollbasket = dollbasket;
        this.dressedBasket = dressedBasket;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                cogerPoner();
            } catch (InterruptedException e) {
                return;
            }
        }

    }

    private void cogerPoner() throws InterruptedException {
        int min = 1000;
        int max = 3000;
        Random random = new Random();
        int myRandomNumber = random.nextInt(max - min) + min;
        Doll doll;
        doll = dollbasket.coger();
        dressedBasket.poner(doll);
        System.out.printf("%s - %s de tipo Tailor ha colocado la muñeca %d vestida en la segunda cesta\n", LocalDateTime.now().format(dateTimeFormatter), getName(), doll.getnSerie());
        Thread.currentThread().sleep(myRandomNumber);

    }

    public String getName() {
        return name;
    }
}
