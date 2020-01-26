package es.iessaladillo.pedrojoya.shops;

import java.util.concurrent.ThreadLocalRandom;

public class TimeUtils {

    private TimeUtils() { }

    public static void randomDelay() {
        int delay = 500 + ThreadLocalRandom.current().nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
