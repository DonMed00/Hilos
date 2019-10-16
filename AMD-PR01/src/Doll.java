public class Doll {
    private static int numSerie;
    private int nSerie;

    public Doll() {
        aumentarSerie();
    }

    public int getnSerie() {
        return nSerie;
    }

    private void aumentarSerie(){
        numSerie++;
        this.nSerie =numSerie;
    }
}