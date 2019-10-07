import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time implements Runnable {


    @Override
    public void run() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        int i;
        for (i = 0; i <= 10; i++) {
            date = new Date();
            System.out.println(dateFormat.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Me han interrumpido");
            }
        }
    }
}
