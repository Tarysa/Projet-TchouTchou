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
	 * R�f�rence sur le fen�tre de jeu
	 */
	private jeu maFenetreJeu;

	/**
	 * 
	 * @param fenetreJeu : fen�tre de jeu
	 */
	public MonPanelJeu(jeu fenetreJeu) {
		maFenetreJeu = fenetreJeu;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la méthode dessiner de la fenêtre principale...
		maFenetreJeu.dessiner(g);
	}
}
