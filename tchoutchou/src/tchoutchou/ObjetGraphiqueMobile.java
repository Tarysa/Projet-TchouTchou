package tchoutchou;
import java.awt.Point;

/**
 * Class <code>ObjetGraphiqueMobile</code>La classe abstraite ObjetGraphiqueMobile permet de manipuler des ObjetGraphiques qui seront mobiles
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 29/11/2021
 */
public abstract class ObjetGraphiqueMobile extends ObjetGraphique{

	/**
	 * m_type : entier correspondant au type de l'ObjetGraphiqueMobile (1-7 sera des rails, et 0 le train)
	 */
	protected int m_type;
	
	/**
	 * Constructeur de la classe ObjetGraphiqueMobile
	 * @param p : Point qui correspond à l'endroit où se trouvera cette objet graphique mobile
	 */
	public ObjetGraphiqueMobile(Point p) {
		
		super(p);
		m_type = 1;
	}
	
	/**
	 * Surcharge du constructeur de la classe ObjetGraphiqueMobile
	 * @param p : Point qui correspond à l'endroit où se trouvera cette objet graphique mobile
	 * @param type : entier correspondant au type de l'ObjetGraphiqueMobile, 1 par défaut
	 */
	public ObjetGraphiqueMobile(Point p, int type) {
		
		super(p);
		m_type = type;
	}
	
	/**
	 * Accesseur de m_type
	 * @return renvoie le type de l'objet graphique mobile courant
	 */
	public int getType()
	{
		return m_type;
	}
	
	/**
	 * Mutateur de m_type
	 * @param type : entier correspondant au nouveau type de notre objet graphique mobile
	 */
	public void setType(int type) {
		m_type = type;
	}
	
	
}
