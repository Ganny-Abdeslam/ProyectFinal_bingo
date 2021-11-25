import Interfaz.Interfaz;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Bingo.Bingo;

/**
* <h1>Un bingo con interfaz gráfica</h1>
* BINGO......(El mucho texto)
* <p>
* <b>Note:</b> Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
*
* @author  Gasser Abdeslam Abdelgelil Serna --- Santiago Marin Dussan --- Frank Sebastian Perdomo
* @version 1.0
* @since   2021
*/

//Payaso ama a febe
public class App {

    //EL TAMAÑO DE LA INTERFAZ
    public static final int ANCHO = 700;
    public static final int ALTO = 650;

    public static Interfaz interfaz = new Interfaz(ANCHO, ALTO); //Definir un objeto tipo Interfaz (swing)
    public static void main(String[] args) throws Exception {

        //Generación de labels
        ArrayList<ArrayList<Integer>> bingoGanador = Bingo.crearBoleto();
        for(int i=0; i<bingoGanador.size(); i++){
            for(int j=0; j<bingoGanador.get(i).size(); j++){
                if(i==2 && j==2){
                    interfaz.modificarLabelArray(".es", i, j);    
                }else{
                    interfaz.modificarLabelArray(""+bingoGanador.get(i).get(j), i, j);
                }
                TimeUnit.SECONDS.sleep(2);
            }
        }

        // interfaz.generarLabel("Otro bingo", 80, 40);
        // ArrayList<ArrayList<ArrayList<Integer>>> bingo = Bingo.creacionBingo();
        // for(int i=0; i<70; i++){
        //     System.out.println(bingo.get(i));
        // }

        //interfaz.generarLabel(""+Bingo.generarNumero(1, 75), 80, 20);
    }
}