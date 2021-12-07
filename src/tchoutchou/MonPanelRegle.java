package tchoutchou;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MonPanelRegle extends JPanel{

	// Réference sur la fenêtre principale
	 private regle maFenetreRegle;

	 public MonPanelRegle(regle fenetreRegle) {
		 maFenetreRegle = fenetreRegle;
	 }

	 /**
	 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
	 */
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 // On appel la méthode dessiner de la fenêtre principale...
		 maFenetreRegle.dessiner(g);
	 }
}
