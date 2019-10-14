public class Doll {
    private static int numSerie=0;
    private int nSerie=0;

    public Doll() {
        numSerie++;
        this.nSerie =numSerie;
    }

    public int getnSerie() {
        return nSerie;
    }
}