package Solution2;

import java.util.concurrent.Semaphore;

class Camarero {
    private final Semaphore semaphore = new Semaphore(1);

    void comprobarPalillos(Palillo palillo1, Palillo palillo2, String name) throws InterruptedException {
        semaphore.acquire();
       // if (!palillo1.isPillado() && !palillo2.isPillado()) {
            palillo1.coger(name);
            palillo2.coger(name);

            palillo1.soltar(name,false);
            palillo2.soltar(name,true);
       // }
        semaphore.release();



    }
}
