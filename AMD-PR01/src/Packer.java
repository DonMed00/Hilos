import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Packer extends Worker {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static int totalProd = 0;

    public Packer(String name, String type, Basket dollBasket, Basket dressedBasket) {
        super(name, type, dollBasket, dressedBasket);
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                coger();

            } catch (InterruptedException e) {
                return;
            }
        }

    }

    /**
     * Use coger() of dressedBasket, while displaying a message.
     * @throws InterruptedException
     */
    private void coger() throws InterruptedException {
        int min = 1000;
        int max = 2000;
        Random random = new Random();
        int myRandomNumber = random.nextInt(max - min) + min;
        Doll doll;
        doll = getDressedBasket().coger();
        System.out.printf("%s - %s de tipo %s ha empaquetado la muñeca %d\n", LocalDateTime.now().format(dateTimeFormatter), getName(), getType(), doll.getnSerie());
        totalProd++;
        Thread.currentThread().sleep(myRandomNumber);


    }
}
