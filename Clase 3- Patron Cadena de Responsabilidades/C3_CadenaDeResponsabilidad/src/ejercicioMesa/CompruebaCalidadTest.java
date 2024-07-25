package ejercicioMesa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompruebaCalidadTest {

    @Test
    public void analizarProducto(){
        //DADO
        Producto producto= new Producto("Mermelada",1010,1300,"sano");
        CompruebaCalidad compruebaCalidad= new CompruebaCalidad();
        //CUANDO
        String respE= "aceptado";
compruebaCalidad.disparadorAnalistaCalidad(producto);
        //ENTONCES
        assertEquals(respE,producto.getStatus());



    }
}
