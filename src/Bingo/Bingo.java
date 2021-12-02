package Bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo{

    public static ArrayList<ArrayList<ArrayList<String>>> creacionBingo(){
        ArrayList<ArrayList<ArrayList<String>>> bingo = new ArrayList<>();

        for(int i = 0; i < 70; i++){
            bingo.add(crearBoleto());
        }

        return bingo;
    }

    public static ArrayList<ArrayList<String>> crearBoleto(){
        ArrayList<ArrayList<String>> boleto = new ArrayList<>();

        boleto.add(generacionLetras(1, 15, false));     //Generación de B
        boleto.add(generacionLetras(16, 15, false));    //Generación de I
        boleto.add(generacionLetras(31, 15, true));     //Generación de N
        boleto.add(generacionLetras(46, 15, false));    //Generación de G
        boleto.add(generacionLetras(61, 15, false));    //Generación de O

        return boleto;
    }

    public static ArrayList<String> generacionLetras(int min, int max, boolean condicion){
        ArrayList<String> numeros = new ArrayList<>();
        int aux = 0;

        for(int i = 0; i < 5; i++){
            aux = generarNumero(min, max);
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

    public static int generarNumero(int min, int max){
        Random aleatorio = new Random();
        return aleatorio.nextInt(max)+min;
    }

    //En veremos
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

    public static ArrayList<ArrayList<String>> convertirAVector(ArrayList<ArrayList<ArrayList<String>>> bingo){
        ArrayList<ArrayList<String>> vector2D = new ArrayList<>();
        for(int i = 0; i < bingo.size(); i++){
            vector2D.add(generarVector(bingo.get(i)));
        }
        return vector2D;
    }

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