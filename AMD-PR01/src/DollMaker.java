import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DollMaker extends Worker {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public DollMaker(String name, String type, Basket dollBasket, Basket dressedBasket) {
        super(name, type, dollBasket, dressedBasket);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                poner();
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * Use poner() of dollBasket and sleep.
     * @throws InterruptedException
     */
    private void poner() throws InterruptedException {
        Doll doll = new Doll();
        String message = String.format("%s - %s de tipo %s ha colocado la muñeca %d en la primera cesta\n", LocalDateTime.now().format(dateTimeFormatter), getName(), getType(), doll.getnSerie());
        getDollBasket().poner(doll, message);
        Thread.currentThread().sleep(generateRandon(4000, 8000));
    }

}
