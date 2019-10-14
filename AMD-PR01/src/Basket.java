import java.util.ArrayList;

public class Basket {
    private  ArrayList<Doll> lista = new ArrayList<>();

    public synchronized void poner(Doll doll) {
        lista.add(doll);
        notifyAll();
    }

    public synchronized Doll coger() throws InterruptedException {
        Doll doll;
        while (lista.isEmpty()) {
            wait();
        }
        doll = lista.get(0);
        lista.remove(0);
        //notifyAll();
        return doll;

    }

}
