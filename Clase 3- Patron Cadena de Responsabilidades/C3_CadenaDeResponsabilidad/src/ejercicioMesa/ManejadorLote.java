package ejercicioMesa;

public class ManejadorLote extends Manejador {
    @Override
    public void compruebaCalidad(Producto producto) {
        if(producto.getLote()>=1000&&producto.getLote()<=2000) {
            if (getSiguienteManejador() != null) {
                getSiguienteManejador().compruebaCalidad(producto);
            }
        }
        else{
            System.out.println("producto rechazado lote");
        }
    }
}
