package presencial;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger= Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        listaEnteros= new ArrayList<>();
        logger.info("instancia creada");
    }

    public void agregarEnterosAlaLista(Integer numero){
        listaEnteros.add(numero);
        logger.info("elemento agregado");
        //La logica indica que debemos loguear cuando?
        if(listaEnteros.size()>5){
            //anotabamos en el registro(logueamos)
            logger.warn("La lista tiene mas de 5: "+listaEnteros.size()+" Elementos");
        }
    }
}
