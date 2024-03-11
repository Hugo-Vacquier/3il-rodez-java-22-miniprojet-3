import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VuePendu extends JFrame {
    private JeuPendu jeuPendu = new JeuPendu();
    private JLabel etatMotLabel = new JLabel("Mot à deviner : " + jeuPendu.getEtatMot());
    private JLabel tentativesLabel = new JLabel("Tentatives restantes : " + jeuPendu.getTentativesRestantes());

    public VuePendu() {
        setTitle("Jeu du Pendu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(etatMotLabel);
        add(tentativesLabel);

        JTextField lettreTextField = new JTextField(1); // Largeur de 1 colonne.
        JButton soumettreBouton = new JButton("Proposer");

        soumettreBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Votre code existant ici...
            }
        });

        add(lettreTextField);
        add(Box.createVerticalStrut(10)); // Ajoute un espace vertical
        add(soumettreBouton);

        pack(); // Dimensionne le cadre.
        setLocationRelativeTo(null); // Centre la fenêtre à l'écran.
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VuePendu();
            }
        });
    }
}
