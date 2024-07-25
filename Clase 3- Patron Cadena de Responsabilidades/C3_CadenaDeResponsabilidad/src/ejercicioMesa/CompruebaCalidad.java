package ejercicioMesa;

public class CompruebaCalidad {
    private Manejador inicial;



    public CompruebaCalidad() {
        inicial= new ManejadorLote();
        Manejador aceptado= new ManejadorAceptado();
        Manejador envase= new ManejadorEnvase();
        Manejador lote= new ManejadorLote();
        Manejador  peso= new ManejadorPeso();

        inicial.setSiguienteManejador(peso);
        peso.setSiguienteManejador(envase);
        envase.setSiguienteManejador(aceptado);
    }
    public void disparadorAnalistaCalidad(Producto producto){
        inicial.compruebaCalidad(producto);
    }

}
