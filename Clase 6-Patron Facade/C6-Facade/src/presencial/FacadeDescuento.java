package presencial;

public class FacadeDescuento implements iFacadeDescuento {
    //que deberiamos hacer para tener una conexion entre las diferentes apis?
    //establecer una relacion de asociacion entre las apis
    private ApiTarjeta apiTarjeta;
    private ApiProducto apiProducto;
    private ApiCantidad apiCantidad;

    public FacadeDescuento() {
        apiTarjeta= new ApiTarjeta();
        apiProducto= new ApiProducto();
        apiCantidad= new ApiCantidad();
    }

    @Override
    public int descuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        int desAcumulado= 0;
        //deberiaamos ir sumnado y a la vez acumulando
        desAcumulado= desAcumulado+apiCantidad.descuentoPorCantidad(cantidad);
        desAcumulado=desAcumulado+apiProducto.descuentoPorProducto(producto);
        desAcumulado=desAcumulado+ apiTarjeta.descuentoPorTarjeta(tarjeta);
        return desAcumulado;
    }
}
