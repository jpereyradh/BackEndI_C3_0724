package presencial;

import java.util.ArrayList;
import java.util.List;

public class GrupoPersona {
    private List<Persona> listaPersonas;

    public GrupoPersona() {
        listaPersonas= new ArrayList<>();
    }
    public void agregarPersona(Persona persona){
        if(persona.esMayorQue()&& persona.checkAZ()&& persona.cantidadDeLetras()&& persona.checkEdad()){
            listaPersonas.add(persona);
        }else{
            System.out.println("Persona no admitida: "+persona.getNombre());
        }

    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
