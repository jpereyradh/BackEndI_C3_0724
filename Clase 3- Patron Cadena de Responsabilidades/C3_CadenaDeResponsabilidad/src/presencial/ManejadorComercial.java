package presencial;

public class ManejadorComercial extends Manejador {
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("comercial@colmena.com")||mail.getTema().equalsIgnoreCase("comercial")){
            return "El departamento tecnico lo atendera en unos minutos.";
        }else{
            System.out.println("Desde Comercial no se pudo procesar su solicitud, lo atendera el siguiente departamento");
        }

        return getSiguienteManejador().compruebaMail(mail);
    }

}
