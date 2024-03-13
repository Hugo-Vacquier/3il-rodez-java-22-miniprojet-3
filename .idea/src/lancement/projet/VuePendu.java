package lancement.projet;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VuePendu extends JFrame {
    private JeuPendu jeuPendu = new JeuPendu();
    private JLabel etatMotLabel = new JLabel("Mot à deviner : " + jeuPendu.getEtatMot());
    private JLabel tentativesLabel = new JLabel("Tentatives restantes : " + jeuPendu.getTentativesRestantes());
    private JButton soumettreBouton = new JButton("Proposer");
    private JTextField lettreTextField = new JTextField(); // La largeur sera définie par le DocumentFilter
    private JLabel definitionLabel = new JLabel(); // Initialement vide, à définir après la création de l'objet VuePendu

    public VuePendu() {
        setTitle("Jeu du Pendu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // DocumentFilter pour restreindre la saisie à une seule lettre
        ((AbstractDocument) lettreTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                text = text.toUpperCase();
                super.replace(fb, 0, fb.getDocument().getLength(), text.matches("[A-Z]") ? text : "", attrs);
            }
        });
        lettreTextField.setColumns(1); // Définir la largeur à une colonne pour une lettre

        soumettreBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Votre code existant ici...
            }
        });

        // Ajoutez les composants à l'interface utilisateur
        add(etatMotLabel);
        add(lettreTextField);
        add(soumettreBouton);
        add(tentativesLabel);
        add(Box.createVerticalStrut(10)); // Ajoute un espace vertical
        add(definitionLabel); // Ajouter le label pour la définition

        pack(); // Dimensionne le cadre.
        setLocationRelativeTo(null); // Centre la fenêtre à l'écran.
        setVisible(true);
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
