public class Consumidor implements Runnable {
    private final Bandeja bandeja;
    private String nombre;

    public Consumidor(String nombre,Bandeja bandeja) {

        this.nombre=nombre;
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
        System.out.printf("Consumidor %s come donut #%d\n",nombre,donut);
        Thread.sleep(2000);
    }
}
