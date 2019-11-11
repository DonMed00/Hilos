package ex3;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class Incrementer implements Runnable {
    private Hilo hilo;

    public Incrementer(Hilo hilo) {
        this.hilo = hilo;
    }

    @Override
    public void run() {
        VarHandle varHandle;
        try {
            varHandle = MethodHandles.lookup().in(Hilo.class)
                    .findVarHandle(Hilo.class, "contador", double.class);

            for (int i = 0; i < 10000; i++) {
                varHandle.getAndAdd(hilo, 1);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {

            e.printStackTrace();
        }
    }

}
