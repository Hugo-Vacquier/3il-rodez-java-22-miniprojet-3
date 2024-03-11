import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class HangmanGame {

    private String selectedWord; // Le mot sélectionné pour la partie

    // L'écran de démarrage
    private void showStartScreen() {
        JFrame startFrame = new JFrame("Bienvenue au Jeu du Pendu");
        JButton startButton = new JButton("Jouons");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWord = pickRandomWord("mots.txt"); // Sélectionner un mot aléatoire
                System.out.println("Le mot à deviner est : " + selectedWord); // Afficher le mot dans la console
                startFrame.dispose(); // Fermer l'écran de démarrage
                showGameScreen(); // Montrer l'écran de jeu
            }
        });

        startFrame.setLayout(new GridBagLayout());
        startFrame.add(startButton);
        startFrame.setSize(300, 200);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setVisible(true);
    }

    // L'écran de jeu
    private void showGameScreen() {
        // Ici, vous pourrez construire votre interface de jeu en Swing
        // comme indiqué dans l'image, avec le pendu, les lettres, etc.
    }

    // Fonction pour sélectionner un mot aléatoire
    private String pickRandomWord(String filePath) {
        try {
            List<String> words = Files.readAllLines(Path.of(filePath));
            if (words.isEmpty()) {
                return "";
            }
            Random random = new Random();
            return words.get(random.nextInt(words.size()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                game.showStartScreen();
            }
        });
    }
}
