public class Productor implements Runnable {
    private final Bandeja bandeja;
    private int indice = 0;

    public Productor(Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    @Override
    public void run() {
        while (true) {
            int donut = 0;
            try {
                donut = producir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            poner(donut);
        }
    }

    private void poner(int donut) {

        bandeja.poner(donut);
    }

    private int producir() throws InterruptedException {
        indice++;
        Thread.sleep(5000);
        return indice;
    }
}
