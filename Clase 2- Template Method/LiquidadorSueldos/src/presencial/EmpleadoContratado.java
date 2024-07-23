package presencial;

public class EmpleadoContratado extends Empleado{
    private int cantidadDehoras;
    private double tarifaPorHora;

    public EmpleadoContratado(String nombre, String apellido, int cuentaBancaria, int cantidadDehoras, double tarifaPorHora) {
        super(nombre, apellido, cuentaBancaria);
        this.cantidadDehoras = cantidadDehoras;
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getCantidadDehoras() {
        return cantidadDehoras;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }
}
