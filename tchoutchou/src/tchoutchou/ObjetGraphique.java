package tchoutchou;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;


/**
 * Class <code>ObjetGraphique</code> La classe abstraite ObjetGraphique permet de manipuler des ObjetGraphiques
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 29/11/2021
 */

public abstract class ObjetGraphique {

	/**
	 * m_p : Point qui correspond � l'endroit o� se trouvera cette objet graphique
	 */
	protected Point2D m_p;
	
	/**
	 * Constructeur de la classe ObjetGraphique
     * @param p : Point qui correspond � l'endroit o� se trouvera cet objet graphique
	*/
	public ObjetGraphique(Point2D p) {
		
		m_p = p;
	}
		
	/**
	 * Accesseur de m_p
	 * @return renvoie le Point de l'objet graphique
	 */
	public Point2D getPoint(){
		
		return m_p;
	}

	/**
	 *  Mutateur de m_p
	 *  @param p : nouveau point o� se trouvera l'objet graphique
	 */
    public void setPoint(Point2D p) {
    	
    	this.m_p = p;
    }
    
    /**
	 * M�thode abstraite Afficher
	 */
	public abstract void afficher(Graphics2D g);
}