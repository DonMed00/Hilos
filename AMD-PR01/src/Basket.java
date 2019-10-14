import java.util.ArrayList;

public class Basket {
    private  ArrayList<Doll> lista = new ArrayList<>();


    /**
     * @param doll
     * Add a doll to the list of the basket and notify
     */
    public synchronized void poner(Doll doll) {
        lista.add(doll);
        notify();

    }


    /**
     * While the list is empty, wait.
     * When list isn´t empty, remove the doll of the list and copy in Doll.
     * @return a Doll
     * @throws InterruptedException
     */
    public synchronized Doll coger() throws InterruptedException {
        Doll doll;
        while (lista.isEmpty()) {
            wait();
        }
        doll = lista.get(0);
        lista.remove(0);
        return doll;

    }

}