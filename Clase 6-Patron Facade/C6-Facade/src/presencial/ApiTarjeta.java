package presencial;

public class ApiTarjeta {
    public int descuentoPorTarjeta(Tarjeta tarjeta){
        if(tarjeta.getBanco().equalsIgnoreCase("star bank")){
            return 20;
        }else {
            System.out.println("no aplica descuento");
            return 0;
        }
    }
}
