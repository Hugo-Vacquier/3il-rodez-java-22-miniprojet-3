package pendu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JeuPendu jeu = new JeuPendu();
            VuePendu vue = new VuePendu();
            ControleurPendu controleur = new ControleurPendu(jeu, vue);
        });
    }
}