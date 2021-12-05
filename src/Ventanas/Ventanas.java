package Ventanas;

import Bingo.Bingo;
import java.util.ArrayList;
import javax.swing.*;

public class Ventanas {
    public static void mostrarCercanosGanar(ArrayList<ArrayList<String>> bingosJuego){
        ArrayList<ArrayList<String>> arreglo = new ArrayList<ArrayList<String>>();
        arreglo = Bingo.organizarTamanios(bingosJuego);
        JOptionPane.showMessageDialog(null, "Los boletos mascercanos a ganar son:\n\n"+arreglo.get(0)+"\n"+arreglo.get(1)+"\n"+arreglo.get(2));
    }
}
