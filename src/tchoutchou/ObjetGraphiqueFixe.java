package tchoutchou;

import java.awt.Point;

/**
 * Class <code>ObjetGraphiqueFixe</code>La classe abstraite ObjetGraphiqueFixe permet de manipuler des ObjetGraphiques qui seront fixes
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 29/11/2021
 */


public abstract class ObjetGraphiqueFixe extends ObjetGraphique{

	/**
	 * Constructeur de la classe ObjetGraphiqueFixe
	 * @param p : Point qui correspond à l'endroit où se trouvera cette objet graphique fixe
	 */
	public ObjetGraphiqueFixe(Point p) {
			
		super(p);
	}
}
