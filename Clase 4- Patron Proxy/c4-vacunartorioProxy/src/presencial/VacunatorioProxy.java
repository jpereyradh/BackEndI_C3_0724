package presencial;

import java.util.Date;

public class VacunatorioProxy implements VacunatorioService{
    private Vacunatorio vacunatorio;

    public VacunatorioProxy() {
        vacunatorio= new Vacunatorio();
    }

    @Override
    public String vacunar(Persona persona) {
        System.out.println("...........Verificando datos...........");
        Date fecha= new Date();
        System.out.println("la fecha de hoy es: "+fecha);
        if(fecha.after(persona.getFechaVacuna())){
            //la persona deberia poder vacunarse
            return vacunatorio.vacunar(persona);
        }else{
         return "Vuelva cuando coincia su fecha de vacunación";
            //la persona deberia regresar cuando sea su turno
        }
    }
}
