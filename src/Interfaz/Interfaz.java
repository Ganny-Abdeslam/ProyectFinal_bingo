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

    private ArrayList<String> bolas = new ArrayList<>();
    private ArrayList<String> bolasComparacion = new ArrayList<>();
    public ArrayList<ArrayList<ArrayList<String>>> bingo = new ArrayList<>();
    public ArrayList<ArrayList<String>> bingoAux = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> arraysLabel = new ArrayList<>();

    private int countI = 0;
    private int countJ = 0;
    
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

    //
    //GENERACIÓN LABELS ARRAY 2D & 3D
    //
    public void addLabelArray(){
        for(int i=0; i<9; i++){
            arraysLabel.add(addLabelArrayVector("",80+i*20));
            for(int j=0; j<9; j++){
                add(arraysLabel.get(i).get(j));
            }
        }
    }

    public ArrayList<JLabel> addLabelArrayVector(String mensja, int x){
        ArrayList<JLabel> arraysLabelVector = new ArrayList<>();

        for(int j=0; j<9; j++){
            JLabel label = new JLabel(mensja);
            label.setBounds(x, 20+j*20, 300, 30);
            arraysLabelVector.add(label);
        }

        return arraysLabelVector;
    }

    public void modificarLabelArray(String msj, int i, int j){
        arraysLabel.get(i).get(j).setText(msj);
    }

    public ArrayList<String> getArrayBolas(){
        return bolas;
    }

    //
    //
    //

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

    //
    //
    //
    
    public void generarBolas(){
        for(int i = 0; i<75; i++){
            bolas.add(i+1+"");
        }
    }

    //
    //VENTOS
    //
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == button_close){
            System.exit(0); //Cerrar el programa
        } else if(event.getSource() == button_compra){
            System.out.println("Desde el boton de compra"); //Cerrar el programa
        } else if(event.getSource() == button_generar_numero){
            Random aleatorio = new Random();
            int aux = 0;
            aux = aleatorio.nextInt(bolas.size()-1);

            modificarLabelArray(bolas.get(aux), countJ, countI);
            bolasComparacion.add(bolas.get(aux));
            bolas.remove(aux);
            

            isGanador();

            if(countJ >= arraysLabel.get(countI).size()-1){
                countI++;
                countJ = 0;
            }else{
                countJ++;
            }
        }
    }


    public boolean isGanador(){
        boolean condicion = false;

        for(int i = 0; i<bingo.size() && !condicion; i++){
            condicion = Bingo.encontrarGanador(bingoAux.get(i), bolasComparacion);
        }

        return condicion;
    }
}