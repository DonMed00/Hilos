package Solution1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Stick {
    private final int stickNumber;
    private boolean taken;
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Stick(int stickNumber) {
        this.stickNumber = stickNumber;
        this.taken =false;
    }

    void take(String name) throws InterruptedException {
        lock.lock();
        while (taken){
            condition.await();
        }
        taken =true;
        lock.unlock();
        System.out.printf("%s - %s .I have the stick %d\n", LocalDateTime.now().format(dateTimeFormatter),name, stickNumber);

    }

    void drop(String name, Boolean flag) throws InterruptedException {
        lock.lock();
        if(flag){
            System.out.printf("%s - %s . I drop the stick %d. I have eaten already, I'm going to think \n", LocalDateTime.now().format(dateTimeFormatter),name, stickNumber);
        }else{
            System.out.printf("%s - %s . I'm eating. Delicious!! \n",LocalDateTime.now().format(dateTimeFormatter),name);
            Thread.sleep(1500);
            System.out.printf("%s - %s . I drop the stick %d\n",LocalDateTime.now().format(dateTimeFormatter),name, stickNumber);
        }
        taken =false;
        condition.signal();

        lock.unlock();


    }
}
