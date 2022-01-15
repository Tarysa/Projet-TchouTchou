package tchoutchou;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Class <code>MonPanelJeu</code>La classe MonPaneljeu
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
@SuppressWarnings("serial")
public class MonPanelJeu extends JPanel {

	/**
	 * Référence sur le fenêtre de jeu
	 */
	private jeu maFenetreJeu;

	/**
	 * 
	 * @param fenetreJeu : fenêtre de jeu
	 */
	public MonPanelJeu(jeu fenetreJeu) {
		maFenetreJeu = fenetreJeu;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la mÃ©thode dessiner de la fenÃªtre principale...
		maFenetreJeu.dessiner(g);
	}
}
