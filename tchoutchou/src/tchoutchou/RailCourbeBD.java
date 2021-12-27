package tchoutchou;
import java.awt.Point;

/**
 * Class <code>Case</code>La classe RailCoubrBD permet de manipuler des Rails courbés du bas vers la droite
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/12/2021
 */

public class RailCourbeBD extends Case{

	
	/**
	 * Constructeur de la classe RailCourbeBD
	 * @param p : Point qui correspond à l'endroit où se trouvera cet rail
	 */
	public RailCourbeBD(Point p) {
		super(p, 3);
	}
	
	/**
	 * Méthode centre_rotation permettant d'obtenir le centre de notre cercle
     * @return renvoie le point du centre de rotation du rail (ici bas droite du rail)
	 */
	@Override
	public Point centre_rotation(){
		
	    return new Point((int)m_p.getX() + 200, (int)m_p.getY() + 200);
	}
	
	/**
	 * Méthode sens permettant de calculer le sens du train dans le rail
	 * On regarde les coordonnées d'entrée dans la case pour derterminer le sens
	 * @param t : objetgraphiquemobile qui va traverser le rail
	 * @return : renvoie 1 si l'objet t traverse la rail dans le sens bas -> droite (anti-horaire), 2 si l'objet t traverse le rail dans le sens bas -> droite (horaire), 0 s'il ne peut pas traverser
	 */
	@Override
	public int sens(ObjetGraphiqueMobile t) {
		
		int sens = 0;
		
		if ( (t.getPoint().getX() == m_p.getX() + 100) && (t.getPoint().getY() == m_p.getY() + 200))
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

		    int x0 = (int)this.centre_rotation().getX() ;
		    int y0 = (int)this.centre_rotation().getY() ;

		    if (sens)
		    {
		        pt.setLocation((int)p.getX() + 1, (int)pt.getY()) ;
		        if (100*100 - (pt.getX() - x0)*(pt.getX() - x0) <0) // Cas de la racine <0
		        {
		        	pt.setLocation(p.getX() + 3, p.getY() + 3);
		        }
		        else
		        	pt.setLocation((int)pt.getX(), y0 - (int)Math.floor(Math.sqrt(100*100 - (pt.getX() - x0)*(pt.getX() - x0))) );
		    }
		    else
		    {
		        pt.setLocation(p.getX() - 1, (int)pt.getY()) ;
		        if (100*100 - (pt.getX() - x0)*(pt.getX() - x0) < 0) // Cas de la racine <0
		        {
		        	pt.setLocation(p.getX() - 3, p.getY() + 3);
		        }
		        else
		        	pt.setLocation((int)pt.getX(), y0 - (int)Math.floor(Math.sqrt(100*100 - (pt.getX() - x0)*(pt.getX() - x0))) );
		    }

		    return pt ;

	}
}
