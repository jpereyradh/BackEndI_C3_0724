package presencial;

public class Vacunatorio implements VacunatorioService{
    @Override
    public String vacunar(Persona persona) {
        System.out.println(".........Verificando los datos.............");
        System.out.println("Paciente vacunado con exito");
        System.out.println("Datos del paciente: "+persona.getNombre()+" cedula: "+persona.getCedula()+" vacuna: "+persona.getNombreVacuna());
        return "finalizado con exito";
    }
}
