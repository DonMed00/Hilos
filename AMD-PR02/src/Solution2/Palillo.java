package Solution2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Palillo {
    private int numPalillo;
    private boolean pillado;
    ReentrantLock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();


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
        System.out.printf("%s .Tengo el palillo %d\n",name,numPalillo);

    }

    void soltar(String name){
        lock.lock();
        pillado =false;
        condition.signal();
        lock.unlock();
        System.out.printf("%s .Ya he comido. Suelto el palillo %d\n",name,numPalillo);

    }









    public int getNumPalillo() {
        return numPalillo;
    }

    public boolean isPillado() {
        return pillado;
    }
}
