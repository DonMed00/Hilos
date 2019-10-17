
public class Tailor extends Worker {

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
        getDressedBasket().poner(doll,getName(),getType(),"segunda");

    }
}
