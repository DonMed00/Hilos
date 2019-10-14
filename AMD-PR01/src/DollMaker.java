import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DollMaker extends Worker {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public DollMaker(String name, String type, Basket dollBasket, Basket dressedBasket) {
        super(name, type, dollBasket, dressedBasket);
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

    /**
     * @param doll
     * Use poner() of dollBasket, while displaying a message.
     * @throws InterruptedException
     */
    private void poner(Doll doll) throws InterruptedException {
        int min = 4000;
        int max = 8000;
        Random random = new Random();
        int myRandomNumber = random.nextInt(max - min) + min;
        getDollBasket().poner(doll);
        System.out.printf("%s - %s de tipo %s ha colocado la muñeca %d en la primera cesta\n", LocalDateTime.now().format(dateTimeFormatter), getName(), getType(), doll.getnSerie());

        Thread.currentThread().sleep(myRandomNumber);
    }

}
