package Solution1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Philosopher implements Runnable {
    private final String name;
    private final Stick stick1;
    private final Stick stick2;
    private boolean interrupted =false;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Philosopher(String name, Stick stick1, Stick stick2) {
        this.name = name;
        this.stick1 = stick1;
        this.stick2 = stick2;
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

    private void think() throws InterruptedException {
        System.out.printf("%s - %s . I am thinking\n",LocalDateTime.now().format(dateTimeFormatter),name);
        Thread.sleep(5000);
    }

    private void eat() throws InterruptedException {
        takeStick();
        releaseStick();
        Thread.sleep(4000);

    }


    private void takeStick() throws InterruptedException {

        stick1.take(name);
        Thread.sleep(3000);
        stick2.take(name);
         Thread.sleep(2000);
    }

    private void releaseStick() throws InterruptedException {
        Thread.sleep(3000);
        stick1.drop(name, false);
        stick2.drop(name, true);
        Thread.sleep(2000);

    }
}
