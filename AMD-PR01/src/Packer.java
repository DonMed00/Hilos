import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        System.out.printf("%s - %s de tipo %s ha empaquetado la muñeca %d\n", LocalDateTime.now().format(dateTimeFormatter), getName(), getType(), getDressedBasket().coger().getnSerie());
        totalProd++;
        Thread.currentThread().sleep(generateRandon(1000,2000));


    }
}
