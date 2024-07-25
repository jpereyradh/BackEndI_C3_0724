package presencial;

public class Mail {

    private String origen, destino, tema;

    public Mail(String origen, String destino, String tema) {
        this.origen = origen;
        this.destino = destino;
        this.tema = tema;
    }

    public String getDestino() {
        return destino;
    }

    public String getTema() {
        return tema;
    }
}
