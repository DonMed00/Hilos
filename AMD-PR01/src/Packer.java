import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Packer implements Runnable {
    private String name;
    private Basket dressedBasket;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static int totalProd=0;

    public Packer(String name, Basket dressedBasket) {
        this.name = name;
        this.dressedBasket = dressedBasket;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                coger();

            } catch (InterruptedException e) {
                return;
            }
        }

    }

    private void coger() throws InterruptedException {
        int min = 1000;
        int max = 2000;
        Random random = new Random();
        int myRandomNumber = random.nextInt(max - min) + min;
        Doll doll;
        doll = dressedBasket.coger();
        System.out.printf("%s - %s de tipo Packer ha empaquetado la muñeca %d\n", LocalDateTime.now().format(dateTimeFormatter), getName(), doll.getnSerie());
        totalProd++;
        Thread.currentThread().sleep(myRandomNumber);


    }

    public String getName() {
        return name;
    }
    public int getTotalProd(){
        return totalProd;
    }
}
