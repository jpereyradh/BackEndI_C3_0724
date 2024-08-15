import Dao.BD;
import Model.Paciente;
import Service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PacienteTestService {
    @Test
    public void buscarPaciente(){
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService();
        Integer idABuscar= 1;
        Paciente paciente= pacienteService.buscarPorId(idABuscar);
        Assertions.assertTrue(paciente!=null);
    }
}
