import java.util.Random;

public class Worker implements Runnable {
    private String name;
    private String type;
    private Basket dollBasket;
    private Basket dressedBasket;

    public Worker(String name, String type, Basket dollBasket, Basket dressedBasket) {
        this.name = name;
        this.type = type;
        this.dollBasket = dollBasket;
        this.dressedBasket = dressedBasket;
    }

    @Override
    public void run() {

    }

    public int generateRandon(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public Basket getDollBasket() {
        return dollBasket;
    }

    public Basket getDressedBasket() {
        return dressedBasket;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
