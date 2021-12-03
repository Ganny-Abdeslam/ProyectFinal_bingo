package Interfaz;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import Bingo.Bingo;

public class Interfaz extends JFrame implements ActionListener{
    
    private JButton button_close;
    private JButton button_compra;
    private JButton button_generar_numero;
    private JTextField texto;

    private ArrayList<String> bolas = new ArrayList<>();
    private ArrayList<String> bolasComparacion = new ArrayList<>();
    public ArrayList<ArrayList<ArrayList<String>>> bingo = new ArrayList<>();
    public ArrayList<ArrayList<String>> bingoAux = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> arraysLabel = new ArrayList<>();

    private boolean juego_iniciado = false;

    private int countI = 0;
    private int countJ = 0;
    private int boletoGanador = 0;
    private int countGanadores = 0;
    
    /**
     * Constructor
     * @param ancho el ancho de la ventana
     * @param alto la altura de la ventana
     */
    public Interfaz(int ancho, int alto){
        setLayout(null);
        //Genera los parametros iniciales de la interfaz (x.inicio, y.inicio, ancho, alto)
        setBounds(0, 0, ancho, alto);
        //Hace que siempre inicie en el centro de la pantalla
        setLocationRelativeTo(null);
        setResizable(false); //No se puede modificar el tamaño de la interfaz
        setVisible(true); //Pinta la interfaz en pantalla

        //Boton de cerrado
        button_close = crearButton("Cerrar", 550, 550, 100, 30);

        //Boton de compra
        button_compra = crearButton("Comprar Boleto", 50, 550, 150, 30);

        //Boton para sacar una bola
        button_generar_numero = crearButton("Sacar Bola", 280, 550, 150, 30);

        generarLabel("Ingrese su cedula: ", 50, 450);
        texto = texto();

        //Añadir un Array de Labels
        addLabelArray();

        //Generar vector d Bolas
        generarBolas();

        //Generacion de Bolas que sacan
        bolasComparacion.add(".es");

        //Generación de los 70 Bingos
        bingo = Bingo.creacionBingo();

        //Bingo Auxiliar para identificar ganadores
        bingoAux = Bingo.convertirAVector(bingo);
    }

    /**
     * Genera un label
     * @param mensja lo que se deasea visualizar en pantalla
     * @param x la coordenada en x en la interfaz
     * @param y la coordenada en y en la interfaz
     */
    public void generarLabel(String mensja, int x, int y){
        JLabel label = new JLabel(mensja);
        label.setBounds(x, y, 300, 30);
        add(label);
    }

    /**
     * Generación de un campo de entrada tipo texto
     * @return cuadroTexto
     */
    public JTextField texto(){
        JTextField cuadroTexto = new JTextField();
        cuadroTexto.setBounds(50, 480, 150, 30);
        add(cuadroTexto);
        cuadroTexto.setText("");
        return cuadroTexto;
    }

    /**
     * Añade la matriz de arrays dentro de la interfaz, en donde se visualizarán las bolas futuramente
     */
    public void addLabelArray(){
        for(int i=0; i<9; i++){
            arraysLabel.add(addLabelArrayVector("",80+i*20));
            for(int j=0; j<9; j++){
                add(arraysLabel.get(i).get(j));
            }
        }
    }

    /**
     * Añdair 9 filas de Labels para la implementación de las bolas sacadas dentro de la interfaz
     * @param mensaje El mensaje que tendra ese Label
     * @param x la posición en la que se crea
     * @return arraysLabelVector
     */
    public ArrayList<JLabel> addLabelArrayVector(String mensaje, int x){
        ArrayList<JLabel> arraysLabelVector = new ArrayList<>();

        for(int j=0; j<9; j++){
            JLabel label = new JLabel(mensaje);
            label.setBounds(x, 20+j*20, 300, 30);
            arraysLabelVector.add(label);
        }

        return arraysLabelVector;
    }

    /**
     * Se modifica la matriz de bolas sacadas que se imprime en la interfaz, que originalmente es totalmente vacia
     * @param msj El mensaje que se modifica dentro de la matriz, en este caso un número de la bola sacada
     * @param i la posición en i de la misma
     * @param j la posición en j de la misma
     */
    public void modificarLabelArray(String msj, int i, int j){
        arraysLabel.get(i).get(j).setText(msj);
    }

    /**
     * Obtiene el array de las bolas
     * @return bolas array de bolas
     */
    public ArrayList<String> getArrayBolas(){
        return bolas;
    }

    /**
     * Generación de un boton
     * @param mensaje mensaje del boton
     * @param x coordenada en x en la interfaz
     * @param y coordenada en y en la interfaz
     * @param ancho ancho del boton
     * @param largo el largor del boton
     * @return un boton con las caracteristicas mandadas para pintarlo en la interfaz
     */
    public JButton crearButton(String mensaje, int x, int y, int ancho, int largo){
        JButton button = new JButton(mensaje);
        button.setBounds(x, y, ancho, largo);
        add(button);
        button.addActionListener(this); //Evento del boton
        return button;
    }

    /**
     * Genera las 75 bolas dentro de un vector para luego utilizarlo
     */
    public void generarBolas(){
        for(int i = 0; i<75; i++){
            bolas.add(i+1+"");
        }
    }

    /**
     * Busca entre las boletas compradas sí ya hay un ganador
     * @return condicion
     */
    public boolean isGanador(){
        boolean condicion = false;
        boolean condicionInterna = false;

        for(int i = 0; i<bingoAux.size(); i++){
            condicionInterna = Bingo.encontrarGanador(bingoAux.get(i), bolasComparacion);
            if(condicionInterna){
                condicion = true;
                countGanadores++;
                boletoGanador = i;
                bingoAux.remove(i);
                i--;
            }
        }

        return condicion;
    }

    /**
     * Generación de un número aleatorio para extraerlo del vector de bolas para luego añadirlo al 
     * vector de bolasComparacion y por último removiendo ese número del vectro de bolas.
     */
    public void extraerNumeros(){
        Random aleatorio = new Random();
        int aux = 0;
        aux = aleatorio.nextInt(bolas.size()-1);

        modificarLabelArray(bolas.get(aux), countJ, countI);
        bolasComparacion.add(bolas.get(aux));
        bolas.remove(aux);
    }

    /**
     * Comprueba sí ya se encontro un ganador
     */
    public void encontrarGanadores(){
        boolean ganador = false;

        ganador = isGanador();
        
        if(ganador){
            System.out.println("El boleto ganador es: "+bingo.get(boletoGanador));
            System.out.println("El total ganadores es: "+countGanadores);
        }
    }

    //
    //VENTOS
    //

    /**
     * Funcion propia del sistema para genearción de eventos
     */
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == button_close){
            
            System.exit(0); //Cerrar el programa

        } else if(event.getSource() == button_compra && !juego_iniciado){

            //Se comprueba sí el usuario ingreso su número de cedula para poder comprar un boleto
            if(!texto.getText().equals("")){
                System.out.println("Desde el boton de compra"); //Permite al usuario Comprar boletos
            }

        } else if(event.getSource() == button_generar_numero){

            //Activa la condición de Juego iniciado para no poder comprar más boletos
            juego_iniciado = true;

            extraerNumeros();
            encontrarGanadores();

            //Organiza la forma en la que se visualiza las bolas sacadas en la interfaz
            if(countJ >= arraysLabel.get(countI).size()-1){
                countI++;
                countJ = 0;
            }else{
                countJ++;
            }
        }
    }
}