package Solution1;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private int comensales;
    ArrayList<Palillo> palillos;
    Lock lock = new ReentrantLock(true);
    //Condition hayPalillo = lock.newCondition();
    static int contador = 0;


    public Mesa(int comensales) {
        this.comensales = comensales;
        palillos = new ArrayList<>();
        for (int i = 0; i < comensales; i++) {
            palillos.add(new Palillo());
        }

    }

    Palillo cogerPalillo(int num) throws InterruptedException {
        lock.lock();
        Palillo palillo = new Palillo(6);
        contador++;

        for (int i = 0; i < palillos.size(); i++) {
            if (contador>4) {
                if (palillos.get(i).getNumPalillo() == num) {
                    palillo = palillos.get(i);
                    palillos.remove(i);
                }

            } else {
                if (palillos.get(i).getNumPalillo() == num - 1) {
                    palillo = palillos.get(i);
                    palillos.remove(i);
                }
            }
        }

        lock.unlock();


        return palillo;
    }


    /*Palillo cogerPalillo2(int num) throws InterruptedException {
        lock.lock();
        Palillo palillo = new Palillo(6);
        if (palillos.size() < 1) {
            hayPalillo.await();
        }
            for (int i = 0; i < palillos.size(); i++) {
                if (palillos.get(i).getNumPalillo() == num) {
                    palillo = palillos.get(i);
                    palillos.remove(i);
                }
            }

        lock.unlock();


        return palillo;
    }*/

    void soltarPalillos(ArrayList<Palillo> palillos) {
        lock.lock();
        palillos.add(palillos.get(0));
        palillos.add(palillos.get(1));
        //hayPalillo.signal();
        lock.unlock();
    }


}

