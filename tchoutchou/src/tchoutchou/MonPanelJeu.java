package tchoutchou;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MonPanelJeu extends JPanel {

	// Réference sur la fenêtre principale
	private jeu maFenetreJeu;

	public MonPanelJeu(jeu fenetreJeu) {
		maFenetreJeu = fenetreJeu;
	}

	/**
	 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la méthode dessiner de la fenêtre principale...
		maFenetreJeu.dessiner(g);
	}
}
