package ejercicioMesa;

public class ManejadorPeso extends Manejador {
    @Override
    public void compruebaCalidad(Producto producto) {
        if (producto.getPeso() >= 1200 && producto.getPeso() <= 1300) {
            if (getSiguienteManejador() != null) {
                getSiguienteManejador().compruebaCalidad(producto);
            }
        } else {
            System.out.println("producto rechazado peso");
        }
    }
}
