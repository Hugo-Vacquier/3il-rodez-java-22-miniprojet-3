import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VuePendu extends JFrame {
    private JeuPendu jeuPendu = new JeuPendu();
    private JLabel etatMotLabel = new JLabel("Mot à deviner : " + jeuPendu.getEtatMot());
    private JLabel tentativesLabel = new JLabel("Tentatives restantes : " + jeuPendu.getTentativesRestantes());

    public VuePendu() {
        setTitle("Jeu du Pendu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(etatMotLabel);
        add(tentativesLabel);

        // Ajoutez ici les contrôles pour saisir les lettres et les autres composants de l'UI

        setVisible(true);
    }

    // Méthode principale pour tester l'affichage
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VuePendu();
            }
        });
    }
}
