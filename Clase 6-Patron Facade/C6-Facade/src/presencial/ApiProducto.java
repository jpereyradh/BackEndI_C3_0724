package presencial;

public class ApiProducto {
    public int descuentoPorProducto(Producto producto){
        if(!producto.getTipo().equalsIgnoreCase("latas")){
            System.out.println("no aplica descuento");
            return 0;
        }else {
            return 10;
        }
    }
}
