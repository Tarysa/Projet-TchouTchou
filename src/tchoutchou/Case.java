package tchoutchou;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.BasicStroke;


/**
 * Class <code>Case</code>La classe abstraite Case permet de manipuler des cases
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 29/11/2021
 */
public abstract class Case extends ObjetGraphiqueMobile{

	/**
	 * case_selectionnee : booléen qui permet de définir si la case est selectionnée ou non, true si elle est selectionnée, false si elle ne l'est pas
	 */
	private boolean case_selectionnee = false ;
	
	/**
     * case_bloquee : booléen qui permet de définir si la case est bloquee ou non, true si elle est bloquee, false si elle ne l'est pas
    */
    private boolean case_bloquee = false;
    
    /**
     * Constructeur de la classe case
     * @param p : Point qui correspond à l'endroit où se trouvera cette case
     */
    public Case(Point2D p) {
    	super(p);
    }
    
    /**
     * Surcharge du constructeur de la classe case
     * @param p : Point qui correspond à l'endroit où se trouvera cette case
     * @param type : entier correspondant au type de la case (1-7 sera des rails)
     */
    public Case(Point2D p, int type) {
    	super(p,type);
    }
    
    /**
	 * Méthode afficher permettant d'afficher le feu sur le jeu
     * @param g 
	 */
    @Override
    public void afficher(Graphics2D g) {
    	
    	Color defaut = new Color(59, 130, 8) ;
    	BasicStroke strokeDefaut = new BasicStroke(1) ;
    	
    	if (case_bloquee) {
    		defaut = new Color(222,220,20) ;
    		g.setColor(new Color(255,255,255)) ;
    		g.setStroke(new BasicStroke(6)) ;
    	}
    	
    	else {
    		if (case_selectionnee){
    			g.setColor(new Color(225,106,12)) ;
        		g.setStroke(new BasicStroke(10)) ;
    		}
    		else {
    			g.setColor(new Color(255,255,255)) ;
        		g.setStroke(new BasicStroke(6)) ;
    		}
    	}
    	
    	g.drawRect((int)m_p.getX(), (int)m_p.getY(), 200, 200) ;
    	g.setColor(defaut) ;
    	g.fillRect((int)m_p.getX(), (int)m_p.getY(), 200, 200) ;
    	
    	if (this instanceof RailCourbeGH) {
    		g.setColor(new Color(255,255,255)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() - 120, 240, 240, -90, 90) ;
    		g.setColor(new Color(0, 153, 0)) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() - 80, 160, 160, -90, 90) ;
    		
    	}
    	else if (this instanceof RailCourbeGB) {
    		g.setColor(new Color(255,255,255)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() - 120, 240, 240, -90, 90) ;
    		g.setColor(new Color(0, 153, 0)) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() - 80, 160, 160, -90, 90) ;
    	}
    	else if (this instanceof RailCourbeBD) {
    		g.setColor(new Color(255,255,255)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() - 120, 240, 240, -90, 90) ;
    		g.setColor(new Color(0, 153, 0)) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() - 80, 160, 160, -90, 90) ;
    	}
    	else if (this instanceof RailCourbeHD) {
    		g.setColor(new Color(255,255,255)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() - 120, 240, 240, -90, 90) ;
    		g.setColor(new Color(0, 153, 0)) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() - 80, 160, 160, -90, 90) ;
    	}
    	else if (this instanceof TraverseeHorizontale) {
    		g.setColor(new Color(255,255,255)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() - 120, 240, 240, -90, 90) ;
    		g.setColor(new Color(0, 153, 0)) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() - 80, 160, 160, -90, 90) ;
    	}
    	else if (this instanceof TraverseeVerticale) {
    		g.setColor(new Color(255,255,255)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() - 120, 240, 240, -90, 90) ;
    		g.setColor(new Color(0, 153, 0)) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() - 80, 160, 160, -90, 90) ;
    	}
    	
    }
    
    /**
     * Mutateur de case_selectionnee
     * @param select : booléen qui permet de définir si la case est selectionnée ou non, true si elle est selectionnée, false si elle ne l'est pas
     */
    public void setCase_Selectionnee(boolean select) {
    	case_selectionnee = select;
    }
    
    /**
     * Accesseur de case_selectionnee
     * @return renvoie la valeur de l'attribut case_selectionnee
     */
    public boolean getCase_Selectionnee() {
    	return case_selectionnee;
    }
    
    /**
     * Mutateur de cas_bloquee
     * @param bloque: booléan qui permet de définir si la case est bloquee ou non, true si elle est bloquee, false si elle ne l'est pas
     */
    public void setCase_bloquee(boolean bloque) {
    	case_bloquee = bloque;
    }
    
    /**
     * Accesseur de case_bloquee
     * @return renvoie la valeur de l'attribut case_bloquee
     */
    public boolean getCase_bloquee() {
    	return case_bloquee;
    }
    
    /**
     * Redéfinition dans toutes les rails
     */
    
    public Point2D getPoint() {
    	return m_p;
    }
    
    abstract Point2D trajectoire(Point2D p, boolean sens);
    
    abstract int sens(ObjetGraphiqueMobile t);
    
    abstract Point2D centre_rotation();
    
}
