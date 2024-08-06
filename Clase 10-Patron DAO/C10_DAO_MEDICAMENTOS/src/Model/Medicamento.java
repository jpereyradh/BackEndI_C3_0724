package Model;

public class Medicamento {
    private Integer id;
    private String nombre;
    private int codigoNumerico;
    private String laboratorio;
    private Double precio;
    private Integer cantidad;

    public Medicamento(Integer id, String nombre, int codigoNumerico, String laboratorio, Double precio, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.codigoNumerico = codigoNumerico;
        this.laboratorio = laboratorio;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(int codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
