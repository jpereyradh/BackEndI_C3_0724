package presencial;

public class Computadora {
    private int discoDuro;
    private int memoriaRam;
    private static int contador;

    public Computadora(int discoDuro, int memoriaRam) {
        this.discoDuro = discoDuro;
        this.memoriaRam = memoriaRam;
        contador++;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public static int getContador() {
        return contador;
    }
}
