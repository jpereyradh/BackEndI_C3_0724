package presencial;

public class CompruebaMail {
    private Manejador inicial;

    public CompruebaMail() {
        //ya tenemos listos los eslabones
        inicial= new ManejadorGerencial();
        Manejador tecnico= new ManejadorTecnico();
        Manejador comercial= new ManejadorComercial();
        Manejador spam= new ManejadorSpam();
        //necesitariamos unir estos eslabones
        inicial.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(spam);
    }
    public String procesaMail(Mail mail){
        return inicial.compruebaMail(mail);
    }
}
