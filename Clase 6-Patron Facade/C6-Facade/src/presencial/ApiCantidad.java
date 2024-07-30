package presencial;

public class ApiCantidad {
    public int descuentoPorCantidad(int cantidad){
        if(cantidad>12){
            return 15;
        }else{
            System.out.println("no aplica descuento");
            return 0;
        }
    }
}
