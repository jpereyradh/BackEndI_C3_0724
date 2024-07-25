package presencial;

public class ManejadorTecnico extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("tecnico@colmena.com")||mail.getTema().equalsIgnoreCase("tecnico")){
            return "El departamento tecnico lo atendera en unos minutos.";
        }else{
            System.out.println("Desde Tecnico no se pudo procesar su solicitud, lo atendera el siguiente departamento");
                }

        return getSiguienteManejador().compruebaMail(mail);
    }
}
