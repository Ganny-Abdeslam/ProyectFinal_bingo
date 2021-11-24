package Bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo{
    
    public static ArrayList<ArrayList<ArrayList<Integer>>> creacionBingo(){
        ArrayList<ArrayList<ArrayList<Integer>>> bingo = new ArrayList<>();

        for(int i = 0; i < 70; i++){
            bingo.add(crearBoleto());
        }

        return bingo;
    }

    public static ArrayList<ArrayList<Integer>> crearBoleto(){
        ArrayList<ArrayList<Integer>> boleto = new ArrayList<>();

        boleto.add(generacionLetras(1, 15));    //Generación de B
        boleto.add(generacionLetras(16, 15));   //Generación de I
        boleto.add(generacionLetras(31, 15));   //Generación de O
        boleto.add(generacionLetras(46, 15));   //Generación de N
        boleto.add(generacionLetras(61, 15));   //Generación de G

        return boleto;
    }

    public static ArrayList<Integer> generacionLetras(int min, int max){
        ArrayList<Integer> numeros = new ArrayList<>();
        Random aleatorio = new Random();
        int aux = 0;

        for(int i = 0; i < 5; i++){
            aux = generarNumero(min, max, aleatorio); 
            if(!numeros.contains(aux)){
                numeros.add(aux);
            } else{
                i--;
            }
        }
        return numeros;
    }

    public static int generarNumero(int min, int max, Random num){
        return num.nextInt(max)+min;
    }
}