package Bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo{
    
    public static ArrayList<ArrayList<Integer>> crearBoleto(){
        ArrayList<ArrayList<Integer>> boleto = new ArrayList<>();

        ArrayList<Integer> B = generacionLetras(1, 15);

        boleto.add(B);

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