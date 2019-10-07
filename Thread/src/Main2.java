public class Main2 {
    public static void main(String[] args) {
        Thread multiplyThread = new Thread(new Tabla2(2));
        Thread multiplyThread2 = new Thread(new Tabla2(3));
        System.out.println("Antes");
        multiplyThread.start();
        multiplyThread2.start();
        System.out.println("Después");




    }
}
