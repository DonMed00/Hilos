package ejer3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Caja caja = null;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 4; j++) {
                caja = new Caja(j);
                if (!caja.taken) {

                    j=3;
                }
            }
            Thread client = new Thread(new Client(i, caja));
            client.start();


            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}