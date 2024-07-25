package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaMailTest {

    @Test
    public void mailASpam(){
        //DADO
        Mail mail= new Mail("jorgito@digitalhouse.com","consultas@gmail.com","baja del servicio");
        CompruebaMail compruebaMail= new CompruebaMail();
        String respEsp= "mail movido a spam";
        //CUANDO
        String respActual= compruebaMail.procesaMail(mail);
        //ENTONCES
        Assertions.assertEquals(respActual,respEsp);
    }
}
