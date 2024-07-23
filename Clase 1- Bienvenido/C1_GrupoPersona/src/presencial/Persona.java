package presencial;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public boolean esMayorQue(){
        //deberia devolver si la persona es mayor o no
        return edad>=18; //--> true, sino retorno false
    }
    public boolean checkEdad(){
        boolean resp= false;
        if(edad>0&&edad<=120){
            resp= true;
        }
        return resp; //siempre va a ser false
        }

        //return edad>0&&edad<=120;
    public boolean cantidadDeLetras(){
        return nombre.length()>=4;
    }
    public boolean checkAZ(){
        boolean resp= false;
        char[] array= nombre.toCharArray(); //---> jorgito  j o r g i t o
        for (char letra : array) {
            //por cada letra deberiamos preguntar
            if(!Character.isLetter(letra)){
                return resp;
            }
                    }
        resp= true;
        return resp;
    }

    public String getNombre() {
        return nombre;
    }
}
