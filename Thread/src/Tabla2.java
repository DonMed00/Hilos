public class Tabla2 implements Runnable {
    private int number;

    public Tabla2(int number) {
        this.number = number;
    }
    ;
    @Override
    public void run() {
        int i;
        int result;
        for (i = 1; i <= 10; i++) {
            result = this.number * i;
            System.out.println(result);
        }
    }
}
