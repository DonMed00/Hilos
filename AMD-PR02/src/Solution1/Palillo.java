package Solution1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Palillo {
    private int numPalillo;
    private boolean pillado;
    ReentrantLock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Palillo(int numPalillo) {
        this.numPalillo=numPalillo;
        this.pillado =false;
    }


    void coger(String name) throws InterruptedException {
        lock.lock();
        while (pillado){
            condition.await();
        }
        pillado =true;
        lock.unlock();
        System.out.printf("%s - %s .Tengo el palillo %d\n", LocalDateTime.now().format(dateTimeFormatter),name,numPalillo);

    }

    void soltar(String name,Boolean flag) throws InterruptedException {
        lock.lock();

        //Thread.sleep(2000);
        if(flag){
            System.out.printf("%s - %s .Suelto el palillo %d Ya he comido\n", LocalDateTime.now().format(dateTimeFormatter),name,numPalillo);

        }else{
            System.out.printf("%s - %s . Suelto el palillo %d\n",LocalDateTime.now().format(dateTimeFormatter),name,numPalillo);

        }
        pillado =false;
        condition.signal();

        lock.unlock();


    }









    public int getNumPalillo() {
        return numPalillo;
    }

    public boolean isPillado() {
        return pillado;
    }
}
