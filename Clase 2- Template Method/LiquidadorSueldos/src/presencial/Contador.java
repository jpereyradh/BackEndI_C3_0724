package presencial;

public abstract class Contador {

    public String liquidarSueldo(Empleado empleado){
        String resp= "no se pudo liquidar el sueldo";
        double sueldo= calcularSueldo(empleado);
        if(sueldo>0){
            String recibo= emitirReciboDeSueldo(empleado);
            resp= recibo+ "sueldo a liquidar: "+sueldo;
        }
        return resp;
    }

    public String depositarSueldo(Empleado empleado){
        return "orden de pago al colaborador: "+empleado.getNombre()+ "cuenta: "+empleado.getCuentaBancaria();
            }
   public abstract String emitirReciboDeSueldo(Empleado empleado);
   public abstract double calcularSueldo(Empleado empleado);
}
