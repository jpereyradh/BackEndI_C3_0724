package presencial;

public class ContadorEmpleadoContratado extends Contador{
    @Override
    public String emitirReciboDeSueldo(Empleado empleado) {
        return "la liquidacion es un documento digital";
    }

    @Override
    public double calcularSueldo(Empleado empleado) {
        double resp=0;
            if(empleado instanceof EmpleadoContratado) {
                EmpleadoContratado empleadoContratado = (EmpleadoContratado) empleado;
                resp = empleadoContratado.getCantidadDehoras() * empleadoContratado.getTarifaPorHora();
            }
        return resp;
    }
}
