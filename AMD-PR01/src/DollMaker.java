
public class DollMaker extends Worker {

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
     *
     * @throws InterruptedException
     */
    private void poner() throws InterruptedException {
        Doll doll = new Doll();
        getDollBasket().poner(doll, getName(), getType(),"primera");
        Thread.currentThread().sleep(generateRandon(4000, 8000));
    }

}
