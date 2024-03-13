package pendu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VuePendu extends JFrame {
    public JeuPendu jeuPendu = new JeuPendu();
    public JLabel etatMotLabel = new JLabel("Mot à deviner : " + jeuPendu.getEtatMot());
    public JLabel tentativesLabel = new JLabel("Tentatives restantes : " + jeuPendu.getTentativesRestantes());
    private JButton soumettreBouton = new JButton("Proposer"); // Déplacé pour être un champ de classe
    private JTextField lettreTextField = new JTextField(1); // Déplacé pour être un champ de classe
    private JLabel definitionLabel;

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

    public JButton getProposerBouton() {
        return soumettreBouton;
    }

    public JTextField getLettreTextField() {
        return lettreTextField;
    }

    public JLabel getEtatMotLabel() {
        return etatMotLabel;
    }

    public JLabel getTentativesLabel() {
        return tentativesLabel;
    }

    public JLabel getDefinitionLabel() {
        // Vous devrez ajouter ce label à votre vue pour afficher la définition
        return definitionLabel;
    }

}