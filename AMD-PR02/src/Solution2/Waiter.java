package Solution2;

import java.util.concurrent.Semaphore;

class Waiter {
    private final Semaphore semaphore = new Semaphore(1);

    void checkSticks(Stick stick1, Stick stick2, String name) throws InterruptedException {
        semaphore.acquire();
       // if (!palillo1.isPillado() && !palillo2.isPillado()) {
            stick1.take(name);
            stick2.take(name);

            stick1.drop(name,false);
            stick2.drop(name,true);
       // }
        semaphore.release();



    }
}
