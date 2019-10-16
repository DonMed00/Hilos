import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tailor extends Worker {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Tailor(String name, String type, Basket dollBasket, Basket dressedBasket) {
        super(name, type, dollBasket, dressedBasket);
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                poner(coger());
                Thread.currentThread().sleep(1000, 3000);
            } catch (InterruptedException e) {
                return;
            }
        }

    }


    /**
     * @return getDollBasket().coger()
     * @throws InterruptedException
     */
    private Doll coger() throws InterruptedException {
        return getDollBasket().coger();


    }

    /**
     * @param doll
     * Use poner() of dressedBasket
     */
    private void poner(Doll doll){
        String message = String.format("%s - %s de tipo %s ha colocado la muñeca %d vestida en la segunda cesta\n", LocalDateTime.now().format(dateTimeFormatter), getName(), getType(), doll.getnSerie());
        getDressedBasket().poner(doll, message);

    }
}
