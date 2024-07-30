package presencial;

public class Cliente {
    public static void main(String[] args) {
        Tarjeta tarjeta= new Tarjeta("22222","star bank");
        Producto producto= new Producto("Tomate","latas");
        int cantidad= 13;
        FacadeDescuento facadeDescuento= new FacadeDescuento();

        System.out.println("desc acu: "+facadeDescuento.descuento(tarjeta,producto,cantidad)+" %");
    }
}
