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
	 * Référence sur la fenêtre règle
	 */
	private regle maFenetreRegle;

	/**
	 * 
	 * @param fenetreRegle : fenêtre de règle
	 */
	public MonPanelRegle(regle fenetreRegle) {
		maFenetreRegle = fenetreRegle;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la mÃ©thode dessiner de la fenÃªtre principale...
		maFenetreRegle.dessiner(g);
	}
}
