package tchoutchou;

import java.awt.Point;

/**
 * Class <code>Case</code>La classe TraverseeVerticale permet de manipuler des Rails verticaux
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/12/2021
 */


public class TraverseeVerticale extends Case {
	

	/**
	 * Constructeur de la classe TraverseeHorizontale
	 * @param p : Point qui correspond � l'endroit o� se trouvera cet rail
	 */
	public TraverseeVerticale(Point p) {
		super(p, 6);
	}
	
	/**
	 * M�thode centre_rotation permettant d'obtenir le centre de notre cercle
     * @return renvoie le point du centre de rotation du rail (ici bas gauche du rail)
	 */
	@Override
	public Point centre_rotation(){
		
	    return new Point((int)m_p.getX(), (int)m_p.getY());
	}
	
	/**
	 * M�thode sens permettant de calculer le sens du train dans le rail
	 * On regarde les coordonn�es d'entr�e dans la case pour derterminer le sens
	 * @param t : objetgraphiquemobile qui va traverser le rail
	 * @return : renvoie 1 si l'objet t traverse la rail dans sens gauche -> droite, 2 si l'objet t traverse la rail dans sens gauche -> droite, 0 s'il ne peut pas traverser
	 */
	@Override
	public int sens(ObjetGraphiqueMobile t) {
		
		int sens = 0;
		
		if ( (t.getPoint().getX() <= m_p.getX()) && (t.getPoint().getY() == m_p.getY()))
			sens = 1;
		else
		{
			if ( (t.getPoint().getX() == m_p.getX() + 100) && (t.getPoint().getY() == m_p.getY() + 200))
				sens = 2;
		}
		
		return sens;
	}
	
	/**
	 * M�thode trajectoire permettant de calculer le point suivant sur la trajectoire du rail
     * @param p : point � partir du quel on applique la trajectoire
     * @param sens : entier qui indique dans quel sens cet rail est travers� (1 gauche-droite, 2 droite-gauche, 0 aucun)
     * @return renvoie le point de l'it�ration suivante
	 */
	@Override
	public Point trajectoire(Point p, boolean sens) {
		
		   Point pt = new Point();

		    if (sens)
		        pt.setLocation((int)p.getX(), (int)p.getY() + 1) ;
		    else
		        pt.setLocation((int)p.getX(), (int)p.getY() - 1) ;


		    return pt ;

	}
}
