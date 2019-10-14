import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tailor extends Worker {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Tailor(String name, String type, Basket dollBasket, Basket dressedBasket) {
        super(name, type, dollBasket, dressedBasket);
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

    /**
     * Use coger() of dollBasket and then add that Doll to dressedBasket, while displaying a message
     * @throws InterruptedException
     */
    private void cogerPoner() throws InterruptedException {
        int min = 1000;
        int max = 3000;
        Random random = new Random();
        int myRandomNumber = random.nextInt(max - min) + min;
        Doll doll;
        doll = getDollBasket().coger();
        getDressedBasket().poner(doll);
        System.out.printf("%s - %s de tipo %s ha colocado la muñeca %d vestida en la segunda cesta\n", LocalDateTime.now().format(dateTimeFormatter), getName(),getType(), doll.getnSerie());
        Thread.currentThread().sleep(myRandomNumber);

    }
}
