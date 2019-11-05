package Solution1;

public class Palillo {
    private int numPalillo;
    static int palillo=0;

    public Palillo() {
        aumentarNumPalillo();
    }
    public Palillo(int numPalillo) {
        this.numPalillo=numPalillo;
    }

    private void aumentarNumPalillo() {
        this.numPalillo = palillo;
        palillo++;
    }

    public int getNumPalillo() {
        return numPalillo;
    }
}
