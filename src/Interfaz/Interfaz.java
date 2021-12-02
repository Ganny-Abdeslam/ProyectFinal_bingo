package Interfaz;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.JTextField;

public class Interfaz extends JFrame implements ActionListener{
    
    private JButton button_close;
    private JButton button_compra;
    private JTextField texto;
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
        //button_compra = crearButton("Comprar Boleto", 50, 550, 150, 30);

        texto = texto();
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
        button.setFont(new Font("Arial", 0, 12));
        add(button);
        button.addActionListener(this); //Evento del boton
        return button;
    }

   
    public JTextField texto(){
        JTextField cuadroTexto = new JTextField();
        cuadroTexto.setBounds(50, 550, 150, 30);
        add(cuadroTexto);
        return cuadroTexto;

    }
        
    //
    //VENTOS
    //
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == button_close){
            System.exit(0); //Cerrar el programa
        } else if(event.getSource() == button_compra){
            System.out.println("Desde el boton de compra");; //Cerrar el programa
        }
    }
}