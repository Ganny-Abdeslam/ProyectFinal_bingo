package Carton;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

public class Carton extends JFrame{

    public ArrayList<JLabel> labelsCarton = new ArrayList<>();

	/**
	 * Inicializa el contenido del frame.
	 */
	public void initialize() {
        setLayout(null);
        //Genera los parametros iniciales de la interfaz (x.inicio, y.inicio, ancho, alto)
        setBounds(0, 0, 300, 300);
        //Hace que siempre inicie en el centro de la pantalla
        setLocationRelativeTo(null);
        setResizable(false); //No se puede modificar el tamaño de la interfaz
        setVisible(true); //Pinta la interfaz en pantalla

        generarBingo();

        for(int i=0; i < 5; i++){
            for(int j=0; j < 5; j++){
                labelsCarton.add(generarLabel("1", j*30+70, i*30+50, true));
            }
        }

        labelsCarton.add(generarLabel("", 70, 200, false));
        labelsCarton.get(labelsCarton.size()-1).setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelsCarton.get(labelsCarton.size()-1).setBounds(90, 200, 120, 30);
				
	}

    public JLabel generarLabel(String mensja, int x, int y, boolean condicion){
        JLabel label = new JLabel(mensja);
        label.setBounds(x, y, 30, 30);
        if(condicion){
            label.setOpaque(true);
            label.setFont(new Font("Tahoma", Font.PLAIN, 20));
            label.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        }else{
            label.setFont(new Font("Tahoma", Font.PLAIN, 30));
        }
        add(label);
        return label;
    }

    public void generarBingo(){
        generarLabel("B", 100, 15, false);
        generarLabel("I", 120, 15, false);
        generarLabel("N", 130, 15, false);
        generarLabel("G", 150, 15, false);
        generarLabel("O", 170, 15, false);
    }
}
