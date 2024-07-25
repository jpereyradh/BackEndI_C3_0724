package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class VacunatorioTest {
    @Test
    public void casoCorrecto(){
        //DADO
        Persona persona= new Persona("Jorgito","111111",new Date(2024-1900,11,24),"aspirina");
        VacunatorioProxy vacunatorio= new VacunatorioProxy();
        String respEsp= "finalizado con exito";
        //CUANDO
        String respActual= vacunatorio.vacunar(persona);
        //ENTONCES
        Assertions.assertEquals(respActual,respEsp);
    }
}
