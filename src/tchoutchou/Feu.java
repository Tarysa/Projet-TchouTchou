package tchoutchou;

import java.awt.Point;
/**
 * Class <code>Feu</code>La classe feu permet de manipuler le feu du jeu
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 29/11/2021
 */

public class Feu extends ObjetGraphiqueFixe{

	/**
     * m_etat : booléen qui représente l'état du feu, true = feu vert, false = feu rouge
     */
	private boolean m_etat ;
    
	/**
	 * Constructeur de la classe feu
	 * @param p : Point qui correspond à l'endroit où se trouvera ce feu
	 */
	public Feu(Point p) {
		
		super(p);
	}
	
	/**
	 * Méthode MiseAuRouge permettant de mettre le feu au rouge
	 */
	public void MiseAuRouge() {
		m_etat = false;
	}
	
	/**
	 * Méthode MiseAuVert permettant de mettre le feu au vert
	 */
	public void MiseAuVert() {
		m_etat = true;
	}
	
	/**
	 * Méthode afficher permettant d'afficher le feu sur le jeu
	 */
	@Override
	public void afficher()
	{
		
	}
	
}
