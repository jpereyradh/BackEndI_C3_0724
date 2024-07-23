package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrupoTest {

    @Test
    public void agregar2Personas(){
        //DADO
        Persona persona1= new Persona("juan",18);
        Persona persona2= new Persona("pedro",17);
        Persona persona3= new Persona("ana",22);
        Persona persona4= new Persona("luz",14);
        Persona persona5= new Persona("julian",32);
        GrupoPersona grupoPersona= new GrupoPersona();
        //CUANDO
        grupoPersona.agregarPersona(persona1);
        grupoPersona.agregarPersona(persona2);
        grupoPersona.agregarPersona(persona3);
        grupoPersona.agregarPersona(persona4);
        grupoPersona.agregarPersona(persona5);

        //ENTONCES
        Assertions.assertTrue(grupoPersona.getListaPersonas().size()==2);

    }
}
