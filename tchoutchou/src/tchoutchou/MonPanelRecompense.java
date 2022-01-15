package tchoutchou;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Class <code>MonPanelRecompense</code>La classe MonPanelRecompense
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
@SuppressWarnings("serial")
public class MonPanelRecompense extends JPanel {

	/**
	 * R�f�rence sur la fen�tre de r�compense
	 */
	private FenetreRecompense maFenetreRecompense;

	/**
	 * 
	 * @param recompense : r�compense
	 */
	public MonPanelRecompense(FenetreRecompense recompense) {
		maFenetreRecompense = recompense;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la m�thode dessiner de la fenêtre principale...
		maFenetreRecompense.dessiner(g);
	}
}
