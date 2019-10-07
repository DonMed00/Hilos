public class Tabla extends Thread {
    private int number;

    public Tabla(int number) {
        this.number = number;
    }

    @Override
    public void start(){
        int i;
        int result;
        for(i=1;i<=10;i++){
            result = this.number*i;
            System.out.println(result);
        }
    }
}
