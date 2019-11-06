package Solution2;

public class Filosofo implements Runnable {
    private String name;
    private int numFilosofo;
    static int filosofo;
    Palillo palillo1;
    Palillo palillo2;

    public Filosofo(String name, Palillo palillo1, Palillo palillo2) {
        this.name = name;
        this.palillo1 = palillo1;
        this.palillo2 = palillo2;
        aumentarNumFilosofo();
    }

    @Override
    public void run() {
        //while (!Thread.currentThread().isInterrupted()) {
            try {
                comer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
   // }

    private void comer() throws InterruptedException {
        cogerTenedor();
        soltarTenedor();
    }


    void cogerTenedor() throws InterruptedException {
        if(!palillo1.isPillado() && !palillo2.isPillado()){
            Thread.sleep(2000);
            palillo1.coger(name);
            palillo2.coger(name);
            Thread.sleep(2000);
        }
    }
    void soltarTenedor() throws InterruptedException {
        Thread.sleep(2000);
        palillo1.soltar(name);
        palillo2.soltar(name);
        //System.out.printf("%s .Ya he comido\n Suelto los palillos %d y %d\n",name,palillo1.getNumPalillo(),palillo2.getNumPalillo());
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
