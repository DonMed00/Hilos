import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Basket {
    private ArrayList<Doll> lista = new ArrayList<>();

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * @param doll Add a doll to the list of the basket, showing a message and notify
     */
    public synchronized void poner(Doll doll, String name, String type,String cesta) {
        String message = String.format("%s - %s de tipo %s ha colocado la muñeca %d en la %s cesta\n", LocalDateTime.now().format(dateTimeFormatter), name, type, doll.getnSerie(),cesta);
        lista.add(doll);
        System.out.printf(message);
        notifyAll();

    }


    /**
     * While the list is empty, wait.
     * When list isn´t empty, remove the doll of the list and copy in Doll.
     *
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
