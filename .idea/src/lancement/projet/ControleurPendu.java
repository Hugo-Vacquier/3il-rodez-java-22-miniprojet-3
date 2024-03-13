package lancement.projet;

import javax.swing.*;

public class ControleurPendu {


    private final JeuPendu jeu;
    private final VuePendu vue;

    public ControleurPendu(JeuPendu jeu, VuePendu vue) {
        this.jeu = jeu;
        this.vue = vue;
        initView();
    }

    private void initView() {
        vue.getProposerBouton().addActionListener(e -> soumettreLettre());
    }

    private void soumettreLettre() {
        String lettre = vue.getLettreTextField().getText().toUpperCase();
        if (lettre.length() == 1 && lettre.matches("[A-Z]")) {
            boolean correct = jeu.proposerLettre(lettre.charAt(0));
            vue.getEtatMotLabel().setText("Mot à deviner : " + jeu.getEtatMot());
            vue.getTentativesLabel().setText("Tentatives restantes : " + jeu.getTentativesRestantes());
            vue.getDefinitionLabel().setText("Indice : " + jeu.getDefinitionMotActuel());
            vue.getLettreTextField().setText("");

            if (jeu.estGagne()) {
                JOptionPane.showMessageDialog(vue, "Félicitations, vous avez gagné!");
                vue.getRejouerBouton().setVisible(true); // Afficher le bouton Rejouer
                vue.getProposerBouton().setEnabled(false); // Désactiver le bouton Proposer
            } else if (jeu.estPerdu()) {
                JOptionPane.showMessageDialog(vue, "Dommage, vous avez perdu! Le mot était : " + jeu.getMotActuel());
                vue.getRejouerBouton().setVisible(true); // Afficher le bouton Rejouer
                vue.getProposerBouton().setEnabled(false); // Désactiver le bouton Proposer
            }
        } else {
            JOptionPane.showMessageDialog(vue, "Veuillez entrer une lettre valide de l'alphabet.", "Entrée invalide", JOptionPane.ERROR_MESSAGE);
        }
    }



}