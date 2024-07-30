package presencial;

public class Tarjeta {
    private String numero;
    private String banco;

    public Tarjeta(String numero, String banco) {
        this.numero = numero;
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public String getBanco() {
        return banco;
    }
}
