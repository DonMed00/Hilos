package ejer2;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OpenedBarrierAction implements Runnable {
    private final SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    static int counter;


    @Override
    public void run() {
        int topic = 2;
        if (counter == 1) {
            topic = 3;
            System.out.printf("%s -> Starting the test of topic %d\n",
                    simpleDateFormat.format(new Date()), topic);
        } else if (counter == 0) {
            System.out.printf("%s -> Starting the test of topic %d\n",
                    simpleDateFormat.format(new Date()), topic);
        }
        counter++;
    }
}
