import Interfaz.Interfaz;
import Bingo.Bingo;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

public class App {

    //EL TAMAÑO DE LA INTERFAZ
    public static final int ANCHO = 700;
    public static final int ALTO = 650;

    public static Interfaz interfaz = new Interfaz(ANCHO, ALTO); //Definir un objeto tipo Interfaz (swing)
    public static void main(String[] args) throws Exception {
        //Generación de labels
        ArrayList<ArrayList<Integer>> bingoGanador = Bingo.crearBoleto();

        for(int i=0; i < bingoGanador.size(); i++){
            for(int j=0; j < bingoGanador.get(i).size(); j++){
                interfaz.generarLabel(""+bingoGanador.get(i).get(j), 80+i*20, 20+j*20);
                TimeUnit.SECONDS.sleep(1);
            }
        }
        //interfaz.generarLabel("Otro bingo", 80, 40);

        // for(int i=0; i < 70; i++){
        //     System.out.println(bingo.get(i));
        // }
    }
}