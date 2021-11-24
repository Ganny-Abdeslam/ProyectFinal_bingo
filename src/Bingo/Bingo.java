package Bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo{
    
    public static ArrayList<ArrayList<ArrayList<Integer>>> creacionBingo(){
        ArrayList<ArrayList<ArrayList<Integer>>> bingo = new ArrayList<>();
        ArrayList<ArrayList<Integer>> bingoAux = new ArrayList<>();

        for(int i = 0; i < 70; i++){
            bingoAux = crearBoleto();
            if (!bingo.containsAll(bingoAux)){
                bingo.add(bingoAux);
            }else{
                i--;
            }
                
        }

        return bingo;
    }

    public static ArrayList<ArrayList<Integer>> crearBoleto(){
        ArrayList<ArrayList<Integer>> boleto = new ArrayList<>();

        boleto.add(generacionLetras(1, 15, false));    //Generación de B
        boleto.add(generacionLetras(16, 15, false));   //Generación de I
        boleto.add(generacionLetras(31, 15, true));   //Generación de N
        boleto.add(generacionLetras(46, 15, false));   //Generación de G
        boleto.add(generacionLetras(61, 15, false));   //Generación de O
 
        return boleto;
    }

    public static ArrayList<Integer> generacionLetras(int min, int max, boolean condicion){
        ArrayList<Integer> numeros = new ArrayList<>();
        Random aleatorio = new Random();
        int aux = 0;

        for(int i = 0; i < 5; i++){
            aux = generarNumero(min, max, aleatorio);

            //Condición para identificar si es el centro del bingo para rellenarlo con un 0
            //Logrando así no afectar la comparación del ganador (Y a la hora de imprimirlo con la interfaz se plantea un ciclo similar para excluirlo)
            if(condicion && i == 2){
                numeros.add(0);
            } else{
                if(!numeros.contains(aux)){
                    numeros.add(aux);
                } else{
                    i--;
                }
            }
        }
        return numeros;
    }

    public static int generarNumero(int min, int max, Random num){
        return num.nextInt(max)+min;
    }
}