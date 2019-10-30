public class Main {

    public static void main(String[] args) {
        Thread a1 = new Thread(new Alumno());
        Thread a2 = new Thread(new Alumno());
        Thread a3 = new Thread(new Alumno());
        Thread a4 = new Thread(new Alumno());

        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }

}
