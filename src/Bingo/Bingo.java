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
        ArrayList<ArrayList<String>> aux = new ArrayList<>();

        for(int i = 0; i < 70; i++){
            aux = crearBoleto();
            
            if(!bingo.containsAll(aux)){
                bingo.add(aux);
            }
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
                numeros.add("es");
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
     * Encuentra sí un vector completo de un boleto del bingo coincide con el vector de bolas sacadas (vectorGanador)
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

    /**
     * Funcion que organiza los vectores de una matriz por tamanio de menor a mayor
     * @param bingoVector Matriz con todas la boletas en juego
     * @return arregloDatos vector de enteros con las posiciones de la matriz de boletos ordendos de menor a mayor
     */
    public static int[] organizarTamanios(ArrayList<ArrayList<String>> bingoVector) {
        
        ArrayList<ArrayList<String>> arreglo = new ArrayList<>();
        int[] arregloDatos = new int[bingoVector.size()];

        copiarArrays(bingoVector, arreglo);        

        arregloDatos = InicializarArreglos(arregloDatos);

        metodoBurbuja(bingoVector, arreglo);

        arregloDatos = obtencionDePosicionesAscendente(bingoVector, arreglo, arregloDatos);

        return arregloDatos;
    }

    /**
     * Inicializa un arreglo de enteros con -1
     * @param arregloDatos arreglo de enteros
     * @return arregloDatos arreglo de enteros lleno con -1
     */
    public static int[] InicializarArreglos(int[] arregloDatos){
        
        for(int i=0; i<arregloDatos.length; i++){
            arregloDatos[i] = -1;
        }

        return arregloDatos;
    }

    /**
     * Copia los elementos de la primera matriz en la segundo amtriz por medio de un for-each
     * @param bingoVector Primera matriz llena con elementos a copiar
     * @param arreglo Segunda matriz que obtendrá los elementos de la primera matriz
     */
    public static void copiarArrays(ArrayList<ArrayList<String>> bingoVector, ArrayList<ArrayList<String>> arreglo){
        for(ArrayList<String> text : bingoVector){
            arreglo.add(text);
        }
    }

    /**
     * Realizar el metodo de la burbuja para el ordenimiento ascendente o descendente de un vector
     * En este caso, este metodo organiza las posiciones de una matriz, ordenando sus vectores asociados
     * de forma ascendente segun su tamanio
     * @param bingoVector Matriz original que posee los tablones de bingo en juego
     * @param arreglo Matriz de tablones de bingo en juego en reordenamiento por tamanio
     */
    public static void metodoBurbuja(ArrayList<ArrayList<String>> bingoVector, ArrayList<ArrayList<String>> arreglo){
        
        for (int i = 0; i < bingoVector.size(); i++) {
            for (int j = 0; j < bingoVector.size() - 1; j++) {
                
                if (arreglo.get(j).size() > arreglo.get(j+1).size()) {
                    if(arreglo.get(j).size() != 0){
                        ArrayList<String> aux = new ArrayList<>(arreglo.get(j));
                        arreglo.set(j, arreglo.get(j+1));
                        arreglo.set(j+1, aux);
                    }
                }

            }
        }
    }

    /**
     * Obtiene un vector de enteros con las posiciones de las tableros, previamente organizados de forma ascendente
     * @param bingoVector Matriz orginal con los tableros de bingo en juego
     * @param arreglo Matriz con los tableros organizados por tamanio de forma ascendente
     * @param arregloDatos Vector de enteros lleno con -1
     * @return arregloDatos Vector de enteros con las posciones de los tableros de bingo en juego organizados
     */
    public static int[] obtencionDePosicionesAscendente(ArrayList<ArrayList<String>> bingoVector, ArrayList<ArrayList<String>> arreglo, int[] arregloDatos){
        int condicion = -1;
        boolean banderilla = false;
        for(int x=0; x < arreglo.size(); x++){
            
            condicion = -1;

            if(arreglo.get(x).size() != 0){
                condicion = bingoVector.indexOf(arreglo.get(x));
            }
            
            for(int y=0; y<arregloDatos.length && !banderilla; y++){
            
                if(condicion != arregloDatos[y] && arregloDatos[y] == -1 && condicion != -1){
                    arregloDatos[y] = condicion;
                    banderilla = true;
                }

            }
            banderilla = false;
        }
        return arregloDatos;
    }
}