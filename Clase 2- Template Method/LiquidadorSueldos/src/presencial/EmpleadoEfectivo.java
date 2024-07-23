package presencial;

public class EmpleadoEfectivo extends Empleado{
    private double sueldoBasico, premio, descuento;


    public EmpleadoEfectivo(String nombre, String apellido, int cuentaBancaria, double descuento, double premio, double sueldoBasico) {
        super(nombre, apellido, cuentaBancaria);
        this.descuento = descuento;
        this.premio = premio;
        this.sueldoBasico = sueldoBasico;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public double getPremio() {
        return premio;
    }

    public double getDescuento() {
        return descuento;
    }
}
