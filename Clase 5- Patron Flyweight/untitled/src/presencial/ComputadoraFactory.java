package presencial;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    //existe la computadora? la retornamos, no existe? la creamos
    private Map<Integer,Computadora> computadoraMap;

    public ComputadoraFactory() {
        computadoraMap= new HashMap<>();
    }
    public Computadora getComputadora(int memoriaRam, int discoDuro){
        //el primer paso seria definir la clave
        Integer  key=memoriaRam+discoDuro;
        //buscar o verficicar en la coleccion si existe esa clave
        if(!computadoraMap.containsKey(key)){
            //no existe, la creo
            computadoraMap.put(key,new Computadora(memoriaRam,discoDuro));
            System.out.println("computadora creada con existo");
        }
        return computadoraMap.get(key);
    }
}
