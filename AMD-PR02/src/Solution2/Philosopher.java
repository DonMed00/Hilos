package Solution2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                waiter.checkSticks(stick1, stick2,name);
            } catch (InterruptedException e) {
                interrupted = true;
                System.out.printf("%s . I am interrupted\n",name);

            }
        }
    }

    private void think() throws InterruptedException {
        System.out.printf("%s - %s . I am thinking\n",LocalDateTime.now().format(dateTimeFormatter),name);
        Thread.sleep(5000);
    }
}
