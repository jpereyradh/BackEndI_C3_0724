import Dao.BD;
import Model.Medicamento;
import Service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        Medicamento medicamento= new Medicamento(1,"ibuprofeno",11111,"bayer",10.0,100);
        BD.crearTabla();
        MedicamentoService medicamentoService= new MedicamentoService();
        medicamentoService.guardarUnMedicamento(medicamento);
    }
}
