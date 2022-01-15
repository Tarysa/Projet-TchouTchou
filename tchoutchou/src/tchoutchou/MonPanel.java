package tchoutchou;

import java.awt.Graphics;

import javax.swing.JPanel;


/**
 * Class <code>MonPanel</code>La classe MonPanel
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
@SuppressWarnings("serial")
public class MonPanel extends JPanel {

	/**
	 * Référence à la fenetre principale
	 */
	private mainwindow maFenetrePrincipale;

	/**
	 * 
	 * @param fenetrePrincipale : fenetre principale
	 */
	public MonPanel(mainwindow fenetrePrincipale) {
		maFenetrePrincipale = fenetrePrincipale;
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la mÃ©thode dessiner de la fenÃªtre principale...
		maFenetrePrincipale.dessiner(g);
	}
}