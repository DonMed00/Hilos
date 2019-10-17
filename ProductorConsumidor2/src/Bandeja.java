import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bandeja {
    private ArrayList<Integer> lista = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition isNotEmpty = lock.newCondition();

    public  void poner(int donut) {
        lock.lock();
        try{
            lista.add(donut);
            isNotEmpty.signal();
        }finally {
            lock.unlock();
        }

    }

    public int coger() throws InterruptedException {
        lock.lock();
        while (lista.isEmpty()) {
            isNotEmpty.await();
        }
        lock.unlock();
        return lista.remove(0);

    }
}
