package presencial;

public class ContadorEmpleadoEfectivo extends Contador{
    @Override
    public String emitirReciboDeSueldo(Empleado empleado) {
        return "La liquidacion es un documento impreso";
    }

    @Override
    public double calcularSueldo(Empleado empleado) {
        double resp=0;
        if(empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo empleadoEfectivo= (EmpleadoEfectivo) empleado;
            resp= ((empleadoEfectivo.getSueldoBasico()+ empleadoEfectivo.getPremio())- empleadoEfectivo.getDescuento());
        }
        return resp;
    }
}
