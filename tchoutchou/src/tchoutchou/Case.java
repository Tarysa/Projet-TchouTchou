package tchoutchou;

import java.awt.Graphics2D;
import java.awt.Point;
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
    public Case(Point p) {
    	super(new Point(p));
    }
    
    /**
     * Surcharge du constructeur de la classe case
     * @param p : Point qui correspond à l'endroit où se trouvera cette case
     * @param type : entier correspondant au type de la case (1-7 sera des rails)
     */
    public Case(Point p, int type) {
    	super(new Point(p),type);
    }
    
    /**
	 * Méthode afficher permettant d'afficher le feu sur le jeu
     * @param g : fenêtre graphique
	 */
    @Override
    public void afficher(Graphics2D g) {
    	
    	Color defaut = new Color(0, 153, 0) ;
    	
    	if (case_bloquee) {
    		defaut = new Color(222,220,20) ;
    		g.setColor(new Color(0,0,0)) ;
    		g.setStroke(new BasicStroke(6)) ;
    	}
    	
    	else {
    		if (case_selectionnee){
    			g.setColor(new Color(225,106,12)) ;
        		g.setStroke(new BasicStroke(10)) ;
    		}
    		else {
    			g.setColor(new Color(0,0,0)) ;
        		g.setStroke(new BasicStroke(6)) ;
    		}
    	}
    	
    	g.drawRect((int)m_p.getX(), (int)m_p.getY(), 200, 200) ;
    	g.setColor(defaut) ;
    	g.fillRect((int)m_p.getX(), (int)m_p.getY(), 200, 200) ;
    	
    	if (this instanceof RailCourbeGH) {
    		g.setColor(new Color(139,0,0)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		//Création d'un quart de cercle pour le rail
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() - 120, 240, 240, -90, 90) ;
    		
    		//Création d'un autre quart de cercle plus petit pour dessiner réellement le rail
    		g.setColor(defaut) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() - 80, 160, 160, -90, 90) ;
    		
    		g.setColor(new Color(9,82,40)) ;
    		g.fillOval((int)m_p.getX() + 125, (int)m_p.getY() + 110 ,30,30);
    		g.fillOval((int)m_p.getX() + 115, (int)m_p.getY() + 100 ,30,30);
    		g.fillOval((int)m_p.getX() + 105, (int)m_p.getY() + 110 ,30,30);
    		g.fillOval((int)m_p.getX() + 115, (int)m_p.getY() + 120 ,30,30);
    		
    	}
    	else if (this instanceof RailCourbeGB) {
    		g.setColor(new Color(139,0,0)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() - 120, (int)m_p.getY() + 80, 240, 240, 90, -90) ;
    		g.setColor(defaut) ;
    		g.fillArc((int)m_p.getX() - 80, (int)m_p.getY() + 120, 160, 160, 90, -90) ;
    		
    		g.setColor(new Color(128,0,0)) ;
    		g.fillRoundRect((int)m_p.getX() + 140, (int)m_p.getY() + 70,20,60,10,10);
    		
    		g.setColor(new Color(9,82,40)) ;
    		g.fillOval((int)m_p.getX() + 145, (int)m_p.getY() + 50 ,30,30);
    		g.fillOval((int)m_p.getX() + 135, (int)m_p.getY() + 40 ,30,30);
    		g.fillOval((int)m_p.getX() + 125, (int)m_p.getY() + 50 ,30,30);
    		
    		g.setColor(new Color(160,0,0)) ;
    		g.fillOval((int)m_p.getX() + 145, (int)m_p.getY() + 50 ,5,5);
    		g.fillOval((int)m_p.getX() + 155, (int)m_p.getY() + 55 ,5,5);
    		g.fillOval((int)m_p.getX() + 145, (int)m_p.getY() + 60 ,5,5);
    	}
    	else if (this instanceof RailCourbeBD) {
    		g.setColor(new Color(139,0,0)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() + 80, (int)m_p.getY() + 80, 240, 240, 90, 90) ;
    		g.setColor(defaut) ;
    		g.fillArc((int)m_p.getX() + 120, (int)m_p.getY() + 120, 160, 160, 90, 90) ;
    	}
    	else if (this instanceof RailCourbeHD) {
    		g.setColor(new Color(139,0,0)) ;
    		g.setStroke(new BasicStroke(50)) ;
    		
    		g.fillArc((int)m_p.getX() + 80, (int)m_p.getY() - 120, 240, 240, -90, -90) ;
    		g.setColor(defaut) ;
    		g.fillArc((int)m_p.getX() + 120, (int)m_p.getY() - 80, 160, 160, -90, -90) ;
    	}
    	else if (this instanceof TraverseeHorizontale) {
    		g.setColor(new Color(139,0,0)) ;
    		g.setStroke(new BasicStroke(1)) ;
    		
    		g.drawRect((int)m_p.getX(), (int)m_p.getY() + 80, 200, 40) ;
            g.fillRect((int)m_p.getX(), (int)m_p.getY() + 80, 200, 40) ;
           
            
            g.setColor(new Color(9,82,40)) ;
            
            g.fillRoundRect((int)m_p.getX()+ 20, (int)m_p.getY() + 140, 40, 40, 20, 20);
            g.fillRoundRect((int)m_p.getX()+ 60, (int)m_p.getY() + 140, 40, 40, 20, 20);
        	g.fillRoundRect((int)m_p.getX()+ 100, (int)m_p.getY() + 140, 40, 40, 20, 20);
        	g.fillRoundRect((int)m_p.getX()+ 140, (int)m_p.getY() + 140, 40, 40, 20, 20);
        		
        	g.fillRoundRect((int)m_p.getX()+ 20, (int)m_p.getY() + 20, 40, 40, 20, 20);
        	g.fillRoundRect((int)m_p.getX()+ 60, (int)m_p.getY() + 20, 40, 40, 20, 20);
        	g.fillRoundRect((int)m_p.getX()+ 100, (int)m_p.getY() + 20, 40, 40, 20, 20);
        	g.fillRoundRect((int)m_p.getX()+ 140, (int)m_p.getY() + 20, 40, 40, 20, 20);
            
    	}
    	else if (this instanceof TraverseeVerticale) {
    		g.setColor(new Color(139,0,0)) ;
    		g.setStroke(new BasicStroke(1)) ;
    		
    		g.drawRect((int)m_p.getX() + 80 , (int)m_p.getY(), 40, 200) ;
            g.fillRect((int)m_p.getX() + 80 , (int)m_p.getY(), 40, 200) ;
    	}
    	else if (this instanceof Croisement) {
    		g.setColor(new Color(139,0,0)) ;
    		g.setStroke(new BasicStroke(1)) ;
    		
    		g.drawRect((int)m_p.getX(), (int)m_p.getY() + 80, 200, 40) ;
            g.fillRect((int)m_p.getX(), (int)m_p.getY() + 80, 200, 40) ;
    		g.drawRect((int)m_p.getX() + 80 , (int)m_p.getY(), 40, 200) ;
            g.fillRect((int)m_p.getX() + 80 , (int)m_p.getY(), 40, 200) ;
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
     * Accesseur du point
     * @return renvoie le point lié à la position de la case au sein dans la fenetre
     */
    public Point getPoint() {
    	return m_p;
    }
    
    abstract Point trajectoire(Point p, boolean sens);
    
    abstract int sens(ObjetGraphiqueMobile t);
    
    abstract Point centre_rotation();
    
}
