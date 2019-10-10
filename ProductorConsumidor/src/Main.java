public class Main {
    public static void main(String[] args) {
        Bandeja bandeja = new Bandeja();
        Productor productor = new Productor(bandeja);
        Consumidor consumidor = new Consumidor(bandeja);
        new Thread(new Productor(bandeja)).start();
        new Thread(new Consumidor(bandeja)).start();
    }
}
