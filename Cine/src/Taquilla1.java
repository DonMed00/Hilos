public class Taquilla1 implements Runnable {

    private Cine cine;


    public Taquilla1(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        retardo();
        cine.comprarEntradas(0, 3);
        retardo();
        cine.comprarEntradas(1, 2);
        retardo();

    }

    private void retardo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
    }
}
