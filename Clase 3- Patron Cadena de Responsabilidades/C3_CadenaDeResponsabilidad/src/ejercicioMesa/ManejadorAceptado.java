package ejercicioMesa;

public class ManejadorAceptado  extends Manejador{

    @Override
    public void compruebaCalidad(Producto producto) {
        System.out.println("producto aceptado");
    producto.setStatus("aceptado");
    }

}
