public class Main {
    public static void main(String[] args) {
        Bandeja bandeja = new Bandeja();

        new Thread(new Productor(bandeja)).start();
        new Thread(new Consumidor("Juan",bandeja)).start();
        new Thread(new Consumidor("Pepe",bandeja)).start();
    }
}
