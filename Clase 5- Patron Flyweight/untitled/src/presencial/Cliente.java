package presencial;

public class Cliente {
    public static void main(String[] args) {
        ComputadoraFactory pcFactory= new ComputadoraFactory();
        Computadora pc1= pcFactory.getComputadora(2,128);
        Computadora pc2= pcFactory.getComputadora(2,128);
        Computadora pc3= pcFactory.getComputadora(2,128);
        Computadora pc4= pcFactory.getComputadora(16,500);
        Computadora pc5= pcFactory.getComputadora(16,500);
        Computadora pc6= pcFactory.getComputadora(16,500);
        Computadora pc7= pcFactory.getComputadora(2,128);
        Computadora pc8= pcFactory.getComputadora(21,128);
        System.out.println("compuadoras creadas y no instanciadas: "+Computadora.getContador());

    }
}
