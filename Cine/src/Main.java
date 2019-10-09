public class Main {


    public static void main(String[] args) {
        Cine cine = new Cine();
        Thread taquilla1 = new Thread((new Taquilla1(cine)));
        Thread taquilla2 = new Thread((new Taquilla2(cine)));

        taquilla1.start();
        taquilla2.start();

        try {
            taquilla1.join();
            taquilla2.join();

        } catch (InterruptedException e) {
            return;
        }

        System.out.println("Sala 0 vendidas: "+ cine.getVendidas(0));
        System.out.println("Sala 1 vendidas: "+ cine.getVendidas(1));

    }
}
