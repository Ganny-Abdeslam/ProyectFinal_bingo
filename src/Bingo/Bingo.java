package Bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo{

    /**
     * Generación de las 70 boletas en un array 3D
     * @return bingo Un array3D con 70 boletas de bingo 
     */
    public static ArrayList<ArrayList<ArrayList<String>>> creacionBingo(){
        ArrayList<ArrayList<ArrayList<String>>> bingo = new ArrayList<>();

        for(int i = 0; i < 70; i++){
            bingo.add(crearBoleto());
        }

        return bingo;
    }

    /**
     * Generación de un boleto con sus respectivos intervalos para cada letra
     * @return boleto Una matriz con 5 filas y columnas 
     */
    public static ArrayList<ArrayList<String>> crearBoleto(){
        ArrayList<ArrayList<String>> boleto = new ArrayList<>();

        boleto.add(generacionLetras(1, 15, false));     //Generación de B
        boleto.add(generacionLetras(16, 15, false));    //Generación de I
        boleto.add(generacionLetras(31, 15, true));     //Generación de N
        boleto.add(generacionLetras(46, 15, false));    //Generación de G
        boleto.add(generacionLetras(61, 15, false));    //Generación de O

        return boleto;
    }

    /**
     * Generación de cada letra con sus números internos generados de forma aleatoria
     * @param max El tamaño minimo para la generación del random
     * @param min El tamaño máximo para la generación del random
     * @param condicion Sí es el centro de la matriz se remplaza por un ".es"
     * @return numeros vector de 5 posciones con sus números generados de forma aleatoria
     */
    public static ArrayList<String> generacionLetras(int max, int min, boolean condicion){
        ArrayList<String> numeros = new ArrayList<>();
        int aux = 0;

        for(int i = 0; i < 5; i++){
            aux = generarNumero(max, min);
            if(condicion && i==2){
                numeros.add(".es");
            } else{
                if(!numeros.contains(aux+"")){
                    numeros.add(aux+"");
                } else{
                    i--;
                }
            }
        }
        return numeros;
    }

    /**
     * Genera un número aleatorio con su respectivo intervalo, que va de 0--min+max para así especificar que
     * solo tome del min-max es decir {(0-15)+31 de tal forma que solo tomaría el rango de 31-46 excluyendo el 46}
     * @param max El tamaño minimo para la generación del random
     * @param min El tamaño minimo para la generación del random
     * @return un número aleatorio
     */
    public static int generarNumero(int max, int min){
        Random aleatorio = new Random();
        return aleatorio.nextInt(min)+max;
    }

    /**
     * Encuentra sí un vector completo de un boleto del bingo concide con el vector de bolas sacadas (vectorGanador)
     * @param bingo Vector de un boleto del bingo
     * @param vectorGanador Vector de bolas sacadas
     * @return condicion Un valor sí el 
     */
    public static boolean encontrarGanador( ArrayList<String> bingo, ArrayList<String> vectorGanador){
        boolean condicion = false;
        int aux = 0;

        for(int i = 0; i < bingo.size(); i++){
            aux = vectorGanador.indexOf(bingo.get(i)); 
            if(aux != -1){
                bingo.remove(i);
                i--;
            }
        }

        if(bingo.size() == 0){
            condicion = true;
            System.out.println("Alguien gano");
        }
        
        return condicion;
    }

    /**
     * Se almacena el bingo en un vector2D para un manejo más sencillo de los datos
     * @param bingo El bingo con todos los boletos comprados
     * @return vector2D todos los boletos reorganizados de una forma 2D más sencilla
     */
    public static ArrayList<ArrayList<String>> convertirAVector(ArrayList<ArrayList<ArrayList<String>>> bingo){
        ArrayList<ArrayList<String>> vector2D = new ArrayList<>();
        for(int i = 0; i < bingo.size(); i++){
            vector2D.add(generarVector(bingo.get(i)));
        }
        return vector2D;
    }

    /**
     * Reorganiza la matriz de cada boleto que tiene el bingo volviendolo un vector
     * @param vector2D El bingo en un vector2D para reorganizarlo
     * @return vector Un vector de 25 números que son los de cada boleto
     */
    public static ArrayList<String> generarVector(ArrayList<ArrayList<String>> vector2D){
        ArrayList<String> vector = new ArrayList<>();
        for(int i = 0; i < vector2D.size(); i++){
            for(int j = 0; j < vector2D.get(i).size(); j++){
                vector.add(vector2D.get(i).get(j));
            }
        }
        return vector;
    }
}