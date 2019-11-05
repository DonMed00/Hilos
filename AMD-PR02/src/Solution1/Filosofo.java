package Solution1;

import java.util.ArrayList;

public class Filosofo implements Runnable{
    private String name;
    private int numFilosofo;
    static int filosofo;
    Mesa mesa;
    ArrayList<Palillo> palillos;

    public Filosofo(String name,Mesa mesa) {
        this.name = name;
        aumentarNumFilosofo();
        this.mesa = mesa;
        this.palillos = new ArrayList<>();
    }

    @Override
    public void run() {
        //while (!Thread.currentThread().isInterrupted()) {
            try {
                cogerPalillo1();
                //cogerPalillo2();
               // comer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       // }
    }

    void cogerPalillo1() throws InterruptedException {

        Palillo palillo = mesa.cogerPalillo(numFilosofo);
        if(palillo.getNumPalillo()!=6){
            palillos.add(palillo);
            System.out.printf("%s . Cojo el palillo %d\n",name,palillos.get(0).getNumPalillo());
        }

        Thread.sleep(2000);
    }

    /*void cogerPalillo2() throws InterruptedException {

        Palillo palillo = mesa.cogerPalillo2(numFilosofo);
        if(palillo.getNumPalillo()!=6){
            palillos.add(palillo);
            System.out.printf("%s . Cojo el palillo %d\n",name,palillos.get(1).getNumPalillo());
        }

        Thread.sleep(2000);
    }*/

    void comer() throws InterruptedException {
        if(palillos.size()==2){
            System.out.printf("%s . Estoy comiendo\n",name);
            Thread.sleep(2000);
            soltarPalillos();
            //Thread.sleep(9000000);
        }
    }

    private void soltarPalillos() throws InterruptedException {
        mesa.soltarPalillos(palillos);
        System.out.printf("%s . Suelto los palillos %d y %d\n",name,palillos.get(0).getNumPalillo(),palillos.get(1).getNumPalillo());
        palillos.remove(0);
        palillos.remove(1);
        Thread.sleep(2000);
    }


    private void aumentarNumFilosofo() {
        filosofo++;
        this.numFilosofo = filosofo;
    }

    public String getName() {
        return name;
    }

    public int getNumFilosofo() {
        return numFilosofo;
    }


}
