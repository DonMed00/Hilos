public class Consumidor implements Runnable {
    private final Bandeja bandeja;

    public Consumidor(Bandeja bandeja) {
        this.bandeja=bandeja;
    }

    @Override
    public void run() {
        while (true){
            try {
                int donut = cogerDonut();
                comer(donut);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private int cogerDonut() throws InterruptedException {
        return bandeja.coger();
    }

    private void comer(int donut) throws InterruptedException {
        System.out.printf("Consumidor come donut #%d\n",donut);
        Thread.sleep(2000);
    }
}
