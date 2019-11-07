package solution3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("JavaDoc")
class Philosopher implements Runnable {
    private final String name;
    private final Stick stick1;
    private final Stick stick2;
    private boolean interrupted =false;
    private final Waiter waiter;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Philosopher(String name, Stick stick1, Stick stick2, Waiter waiter) {
        this.name = name;
        this.stick1 = stick1;
        this.stick2 = stick2;
        this.waiter = waiter;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !interrupted) {
            try {
                think();
                eat();
            } catch (InterruptedException e) {
                interrupted = true;
                System.out.printf("%s . I am interrupted\n",name);

            }
        }
    }
    /**
     * Call methods checkSticks() of waiter. This is, basically, eat.
     * @throws InterruptedException
     */
    private void eat() throws InterruptedException {
        waiter.checkSticks(stick1, stick2,name);
    }

    /**
     * Show a message informing that he is thinking and the thread sleep 5 seconds
     * @throws InterruptedException
     */
    private void think() throws InterruptedException {
        System.out.printf("%s - %s . I am thinking\n",LocalDateTime.now().format(dateTimeFormatter),name);
        Thread.sleep(5000);
    }
}
