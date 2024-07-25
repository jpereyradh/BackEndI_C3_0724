package presencial;

public class ManejadorSpam extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        System.out.println("no pudimos procesar su solicitud");
        return "mail movido a spam";
    }
}
