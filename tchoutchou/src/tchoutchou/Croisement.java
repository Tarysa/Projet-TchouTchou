package tchoutchou;

import java.awt.Point;

/**
 * Class <code>Croisement</code>La classe Croisement permet de manipuler des croisements
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
public class Croisement extends Case {
	
	static int direction = 0;
	
	/**
	 * Constructeur de la classe Croisement
	 * @param p : Point qui correspond à l'endroit où se trouvera cet rail
	 */
	public Croisement(Point p) {
		super(p, 8);
	}
	
	/**
	 * Méthode centre_rotation permettant d'obtenir le centre de notre cercle
     * @return renvoie le point du centre de rotation du rail (ici bas gauche du rail)
	 */
	@Override
	public Point centre_rotation(){
		
	    return new Point((int)m_p.getX() + 100, (int)m_p.getY() + 100);
	}
	
	/**
	 * Méthode sens permettant de calculer le sens du train dans le rail
	 * On regarde les coordonnées d'entrée dans la case pour derterminer le sens
	 * La direction va être également modifiée afin de déterminer si l'objet doit se déplacer suivant l'axe horizontale ou verticale
	 * @param t : objetgraphiquemobile qui va traverser le rail
	 * @return : renvoie 1 si l'objet t traverse la rail dans sens gauche -> droite ou haut-> bas, 2 si l'objet t traverse la rail dans sens droite-> gauche ou bas -> haut, 0 s'il ne peut pas traverser
	 */
	@Override
	public int sens(ObjetGraphiqueMobile t) {
		
		int sens = 0;
		
		if ( (t.getPoint().getX() == m_p.getX()) && (t.getPoint().getY() == m_p.getY() + 100)) {
			sens = 1;
			direction = 1;
		}
		if ((t.getPoint().getX() <= m_p.getX() + 100) && (t.getPoint().getY() == m_p.getY())){
			sens = 1;
			direction = 2;
		}
		else
		{
			if ((t.getPoint().getX() == m_p.getX() + 200) && (t.getPoint().getY() == m_p.getY() + 100)) {
				sens  = 2;
				direction = 1;
			}
			
			if  ( (t.getPoint().getX() == m_p.getX() + 100) && (t.getPoint().getY() == m_p.getY() + 200)){
				sens = 2;
				direction = 2;
			}
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

		    if (sens) {
		    	if (direction == 1)
		    		pt.setLocation((int)p.getX() + 1, (int)p.getY()) ; // On avance dans le sens horaire suivant l'axe horizontale
		    	else
		    		pt.setLocation((int)p.getX() , (int)p.getY() + 1) ;// On avance dans le sens horaire suivant l'axe verticale
		    }
		    else
		    	if (direction == 2)
		    		pt.setLocation((int)p.getX() - 1, (int)p.getY()) ;// On avance dans le sens anti-horaire suivant l'axe horizontale
		    	else
		    		pt.setLocation((int)p.getX() , (int)p.getY() - 1) ;// On avance dans le sens anti-horaire suivant l'axe verticale

		    return pt ;

	}
}
