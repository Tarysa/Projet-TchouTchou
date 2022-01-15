package tchoutchou;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Class <code>MonPanelRegle</code>La classe MonPanelRegle
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
@SuppressWarnings("serial")
public class MonPanelRegle extends JPanel {

	/**
	 * R�f�rence sur la fen�tre r�gle
	 */
	private regle maFenetreRegle;

	/**
	 * 
	 * @param fenetreRegle : fen�tre de r�gle
	 */
	public MonPanelRegle(regle fenetreRegle) {
		maFenetreRegle = fenetreRegle;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la méthode dessiner de la fenêtre principale...
		maFenetreRegle.dessiner(g);
	}
}
