import java.util.ArrayList;

public class Bandeja {
    private ArrayList<Integer> lista = new ArrayList<>();

    public synchronized void poner(int donut) {
        lista.add(donut);
        notifyAll();
    }

    public synchronized int coger() throws InterruptedException {
        while (lista.isEmpty()) {
            wait();
        }
        return lista.remove(0);
    }
}
