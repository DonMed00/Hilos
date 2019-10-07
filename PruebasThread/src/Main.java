public class Main {
    public static void main(String[] args) {
        Thread workerThread = new Thread(new MiTarea());
        System.out.println("Principal antes");
        workerThread.start();
       Thread anotherThread = new Thread(() -> showMessage());
        System.out.println("Principal después");
    }
    private static void showMessage(){
        System.out.println("Quillo desde un hilo secundario");
    }
}
