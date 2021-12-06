import Interfaz.Interfaz;

//import java.util.ArrayList;

//import Bingo.Bingo;

/**
* BINGO 
* Juego de Bingo virtual con interfaz grafica
* Programa realiza la implementacion de un bingo virtual
* Permite:
* Comprar tableros de bingo asignados con su numero de cedula
* Regalar tableros a los asistentos
* Mostar el total recudado por la compra de tableros
* Mostrar los 3 tableros mas cercanos a ganar
* Mostrar tableros especificos
* Obtener y mostrar 3 ganadores
*
* @author  Gasser Abdeslam Abdelgelil Serna --- Santiago Marin Dussan --- Frank Sebastian Perdomo
* @version 1.0
* @since   2021
*/

public class App {

    //EL TAMAÑO DE LA INTERFAZ
    public static final int ANCHO = 700;
    public static final int ALTO = 650;
    
    /**
     * Funcion principal que crear el objeto tipo interfaz y llama al inicializador de la interfaz
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Interfaz interfaz = new Interfaz(); //Definir un objeto tipo Interfaz (swing)
        interfaz.Inicializar(ANCHO, ALTO);
    }

}