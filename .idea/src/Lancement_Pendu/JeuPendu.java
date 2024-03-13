package Lancement_Pendu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JeuPendu {
    private List<String> mots = new ArrayList<>();
    private String motActuel;
    private StringBuilder etatMot;
    private List<Character> lettresProposees = new ArrayList<>();
    private int tentativesRestantes;
    private String definitionMotActuel; // Si vous souhaitez inclure les définitions

    public JeuPendu() {
        chargerMots();
        choisirMot();
    }

    private void chargerMots() {
        try {
            File fichier = new File("mots.txt");
            Scanner scanner = new Scanner(fichier);
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                mots.add(ligne.split(" ")[0]); // Assurez-vous que votre fichier est correctement formaté
                // Pour gérer les définitions, vous pouvez stocker les mots et définitions dans une structure plus complexe
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void choisirMot() {
        Random random = new Random();
        int indexMot = random.nextInt(mots.size());
        motActuel = mots.get(indexMot);
        etatMot = new StringBuilder("_".repeat(motActuel.length()));
        tentativesRestantes = 10; // Vous pouvez ajuster ce nombre selon la difficulté souhaitée
        lettresProposees.clear();
    }

    public boolean proposerLettre(char lettre) {
        if (!lettresProposees.contains(lettre)) {
            lettresProposees.add(lettre);
            if (motActuel.indexOf(lettre) >= 0) {
                for (int i = 0; i < motActuel.length(); i++) {
                    if (motActuel.charAt(i) == lettre) {
                        etatMot.setCharAt(i, lettre);
                    }
                }
                return true;
            } else {
                tentativesRestantes--;
                return false;
            }
        }
        return false; // La lettre a déjà été proposée
    }

    public boolean estGagne() {
        return motActuel.equals(etatMot.toString());
    }

    public boolean estPerdu() {
        return tentativesRestantes <= 0;
    }

    public String getEtatMot() {
        return etatMot.toString();
    }

    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    // Utilisez cette méthode pour recommencer une partie
    public void recommencerPartie() {
        choisirMot();
    }

    // Getters et Setters supplémentaires au besoin
}
