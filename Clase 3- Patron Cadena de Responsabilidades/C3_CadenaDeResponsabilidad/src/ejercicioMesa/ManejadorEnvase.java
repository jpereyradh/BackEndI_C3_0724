package ejercicioMesa;

public class ManejadorEnvase  extends Manejador{
    @Override
    public void compruebaCalidad(Producto producto) {
        if (producto.getEnvasado().equalsIgnoreCase("casi sano")||producto.getEnvasado().equalsIgnoreCase("sano")) {
            if (getSiguienteManejador() != null) {
                getSiguienteManejador().compruebaCalidad(producto);
            }
        } else {
            System.out.println("producto rechazado envase");
        }
    }
}
