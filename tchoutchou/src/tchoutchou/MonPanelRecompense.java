package tchoutchou;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MonPanelRecompense extends JPanel {

	// Réference sur la fenêtre principale
	private FenetreRecompense maFenetreRecompense;

	public MonPanelRecompense(FenetreRecompense recompense) {
		maFenetreRecompense = recompense;
	}

	/**
	 * Gestionnaire d'evenement associe a l'evenement "paint" du panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la m�thode dessiner de la fenêtre principale...
		maFenetreRecompense.dessiner(g);
	}
}
