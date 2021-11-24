import Interfaz.Interfaz;

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
        interfaz.generarLabel("Es un bingo", 80, 20);
        interfaz.generarLabel("Otro bingo", 80, 40);
    }
}