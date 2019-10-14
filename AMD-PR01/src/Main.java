
public class Main {
    public static void main(String[] args) {
        final int JORNADA = 60000;
        Basket dollBasket = new Basket();
        Basket dressedBasket = new Basket();
        Thread thread1 = new Thread(new DollMaker("Trabajador 1", dollBasket));
        Thread thread2 = new Thread(new DollMaker("Trabajador 2", dollBasket));
        Thread thread3 = new Thread(new Tailor("Trabajador 3", dollBasket, dressedBasket));
        Thread thread4 = new Thread(new Packer("Trabajador 4", dressedBasket));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            Thread.sleep(JORNADA);
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
            thread4.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Señor@s a la casa, mañana será otro día");
        System.out.printf("Hemos producido un Total de %d Baldomeras", Packer.totalProd);

    }
}
