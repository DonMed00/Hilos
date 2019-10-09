public class Cine {
    private int ocupadas[] = new int[]{0, 0, 0, 0};

    public synchronized void comprarEntradas(int sala, int numEntradas) {
        ocupadas[sala] += numEntradas;
    }


    public int getVendidas(int sala) {
        return ocupadas[sala];
    }
}
