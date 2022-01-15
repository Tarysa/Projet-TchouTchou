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
	 * Référence sur la fenêtre de récompense
	 */
	private FenetreRecompense maFenetreRecompense;

	/**
	 * 
	 * @param recompense : récompense
	 */
	public MonPanelRecompense(FenetreRecompense recompense) {
		maFenetreRecompense = recompense;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// On appel la méthode dessiner de la fenÃªtre principale...
		maFenetreRecompense.dessiner(g);
	}
}
