public class Main {
    public static void main(String[] args) {
        Thread timeThread = new Thread(new Time());
        int i;
        System.out.println("Hora actual:");

        timeThread.start();
    }
}
