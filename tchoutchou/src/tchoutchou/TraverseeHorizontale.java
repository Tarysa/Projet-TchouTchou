package tchoutchou;

import java.awt.Point;

/**
 * Class <code>Case</code>La classe TraverseeHorizontale permet de manipuler des Rails horizontaux
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/12/2021
 */


public class TraverseeHorizontale extends Case {
	

	/**
	 * Constructeur de la classe TraverseeHorizontale
	 * @param p : Point qui correspond à l'endroit où se trouvera cet rail
	 */
	public TraverseeHorizontale(Point p) {
		super(p, 5);
	}
	
	/**
	 * Méthode centre_rotation permettant d'obtenir le centre de notre cercle
     * @return renvoie le point du centre de rotation du rail (ici bas gauche du rail)
	 */
	@Override
	public Point centre_rotation(){
		
	    return new Point((int)m_p.getX(), (int)m_p.getY());
	}
	
	/**
	 * Méthode sens permettant de calculer le sens du train dans le rail
	 * On regarde les coordonnées d'entrée dans la case pour derterminer le sens
	 * @param t : objetgraphiquemobile qui va traverser le rail
	 * @return : renvoie 1 si l'objet t traverse la rail dans sens gauche -> droite, 2 si l'objet t traverse la rail dans sens gauche -> droite, 0 s'il ne peut pas traverser
	 */
	@Override
	public int sens(ObjetGraphiqueMobile t) {
		
		int sens = 0;
		
		if ( (t.getPoint().getX() == m_p.getX()) && (t.getPoint().getY() == m_p.getY() + 100))
			sens = 1;
		else
		{
			if ( (t.getPoint().getX() == m_p.getX() + 200) && (t.getPoint().getY() == m_p.getY() + 100))
				sens = 2;
		}
		
		return sens;
	}
	
	/**
	 * Méthode trajectoire permettant de calculer le point suivant sur la trajectoire du rail
     * @param p : point à partir du quel on applique la trajectoire
     * @param sens : entier qui indique dans quel sens cet rail est traversé (1 gauche-droite, 2 droite-gauche, 0 aucun)
     * @return renvoie le point de l'itération suivante
	 */
	@Override
	public Point trajectoire(Point p, boolean sens) {
		
		   Point pt = new Point();

		    if (sens)
		        pt.setLocation((int)p.getX() + 1, (int)p.getY()) ;
		    else
		        pt.setLocation((int)p.getX() - 1, (int)p.getY()) ;


		    return pt ;

	}
}
