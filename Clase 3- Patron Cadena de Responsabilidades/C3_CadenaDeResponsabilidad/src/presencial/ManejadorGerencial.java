package presencial;

public class ManejadorGerencial extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("gerencial@colmena.com")||mail.getTema().equalsIgnoreCase("gerencial")){
            return "El departamento tecnico lo atendera en unos minutos.";
        }else{
            System.out.println("Desde Gerencial no se pudo procesar su solicitud, lo atendera el siguiente departamento");
        }

        return getSiguienteManejador().compruebaMail(mail);
    }
}
