import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Alumno implements Runnable {
    static int nAlumno = 0;
    int numAlumno = 0;
    private final CyclicBarrier barrera = new CyclicBarrier(2);

    public Alumno() {
        nAlumno += 1;
        this.numAlumno = nAlumno;

    }

    @Override
    public void run() {
        while(true) {
            try {
                waitDoor();
                doExam();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                barrera.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void waitDoor() throws InterruptedException {
        System.out.println("Estoy en la puerta de clase y me espero a entrar");
        Thread.sleep(1000);
    }

    private void doExam() throws InterruptedException {
        System.out.println("Comienzo el examen");
        Thread.sleep(2000);
    }
}
