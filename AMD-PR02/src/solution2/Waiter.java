package solution2;

import java.util.concurrent.Semaphore;

@SuppressWarnings("JavaDoc")
class Waiter {
    private final Semaphore semaphore = new Semaphore(1);

    /**
     * @param stick1
     * @param stick2
     * @param name
     * @throws InterruptedException
     * Acquire semaphore while take the sticks and after releases them
     */
    void checkSticks(Stick stick1, Stick stick2, String name) throws InterruptedException {
        semaphore.acquire();
            stick1.take(name);
            stick2.take(name);

            stick1.drop(name,false);
            stick2.drop(name,true);
        semaphore.release();



    }
}
