package ejercicioMesa;

public abstract class Manejador {
    private Manejador siguienteManejador;

    public Manejador getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(Manejador siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }
    public abstract void compruebaCalidad(Producto producto);
}
