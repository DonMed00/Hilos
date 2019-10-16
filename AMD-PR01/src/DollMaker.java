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
            Doll doll = new Doll();
            try {
                poner(doll);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * @param doll Use poner() of dollBasket and sleep a rondon time.
     * @throws InterruptedException
     */
    private void poner(Doll doll) throws InterruptedException {
        String message = String.format("%s - %s de tipo %s ha colocado la muñeca %d en la primera cesta\n", LocalDateTime.now().format(dateTimeFormatter), getName(), getType(), doll.getnSerie());
        getDollBasket().poner(doll, message);
        Thread.currentThread().sleep(generateRandon(4000, 8000));
    }

}
