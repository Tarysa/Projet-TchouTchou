package tchoutchou;

import java.awt.geom.Point2D;
import java.awt.Graphics2D;

/**
 * Class <code>Case</code>La classe Plateau permet de manipuler le tableau de jeu
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 13/12/2021
 */

public class Plateau{

	/**
	 * Entier qui correspond à la taille du plateau
	 */
	private int m_taille;
	
	/**
	 * 
	 */
	private Case[][] m_plateau;
	
	public Plateau(int taille){
		
		m_taille = taille;
		m_plateau = new Case[taille][taille];
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				m_plateau[i][j] = null;
			}
		}
	}
	
	public Plateau(Plateau p){
		
		m_taille = p.m_taille;
		m_plateau = new Case[m_taille][m_taille];
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				m_plateau[i][j] = p.m_plateau[i][j];
			}
		}
	}
	
	public int getTaille() {
		return m_taille;
	}
	
	public void setCase(Point2D p, Case c) {
		m_plateau[(int)p.getX()][(int)p.getY()] = c;
	}
	
	public Case getCase(Point2D p) {
		return m_plateau[(int)p.getX()][(int)p.getY()];
	}
	
	public void afficher(Graphics2D g) {
		
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				getCase(new Point2D(i,j)).afficher(g);
			}
		}
		
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				if ( (getCase(new Point2D(i,j)).getCase_Selectionnee()) || (getCase(new Point2D(i,j)).getCase_bloquee())) {
					getCase(new Point2D(i,j)).afficher(g);
				}
			}
		}
	}
	
	public Point2D rechercheCase(Point2D p) {
		
		Point2D nouv = new Point2D(-1, -1);
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				if (( m_plateau[i][j].getPoint().getX() == p.getX() ) && (m_plateau[i][j].getPoint().getY() == p.getY() )) {
					p.setLocation((int)nouv.getX(), (int)nouv.getY()) ;
				}
			}
		}
		
		return nouv;
		
	}
	
	public boolean echangerCase(Case c1, Case c2) {

	    Point2D v1 = rechercheCase(c1.getPoint()) ;
	    Point2D v2 = rechercheCase(c2.getPoint()) ;

	    if (!(c1 instanceof Vide) && !(c2 instanceof Vide)) {
	        // Cas où les deux cases ne sont pas vides
	    }
	    else {
	        if ( (!c1.getCase_bloquee()) && (!c2.getCase_bloquee()))
	        {
	            Point2D pt = c2.getPoint() ;
	            c2.setPoint(c1.getPoint()) ;
	            setCase(v2, c1) ;
	            c1.setPoint(pt) ;
	            setCase(v1, c2) ;
	            return true ;
	        }
	    }

	    return false ;

	}
	
	public Case InitCase(Case c, Point2D coord_plateau)
	{
	    Point2D n_p ;

	    if (m_taille == 2)
	    {
	    	n_p.setLocation(250 + (int)coord_plateau.getY()*200, 250 + (int)coord_plateau.getX()*200);
	    }
	    else
	    {
	    	n_p.setLocation(150 + (int)coord_plateau.getY()*200, 150 + (int)coord_plateau.getX()*200);
	    }

	    c.setPoint(n_p);

	    return c;
	}

	/* operator==(const Plateau& p1,const Plateau& p2)
	{
	    bool egaux = true;

	    for (int i=0;i<p1.getTaille();i++)
	    {
	        for  (int j=0;j<p1.getTaille();j++)
	        {
	            if (p1.getCase(Point(i,j)).getType() != p2.getCase(Point(i,j)).getType())
	               egaux = false;
	        }
	    }
	    return egaux;
	}

	Plateau& Plateau::operator=(const Plateau& p){

	    if (this != &p)
	     {
	        this->~Plateau();
	        m_taille = p.getTaille() ;
	        m_plateau = new Case**[m_taille] ;
	        for (int i = 0 ; i < m_taille ; i++) {
	           m_plateau[i] = new Case*[m_taille] ;
	           for (int j = 0 ; j < m_taille ; j++) {
	                this->setCase(Point(i,j), p.getCase(Point(i,j))) ;
	           }
	        }
	     }
	     return *this;
	}

	void Plateau::melangePlateau()
	{
	    int echangeok = 0 ;
	    int nbechange = m_taille * m_taille;

	    Case *vide = new Vide(Point()) ;

	    while(echangeok < nbechange)
	    {
	        //On recherche la case vide
	        Point p_vide = rechercheCaseType(7);
	        //On génère un point du plateau
	        Point p = genererCoord();
	        if ((p_vide.getX() != p.getX())||(p_vide.getY() != p.getY()))
	        {
	            //Les deux cases sont différentes
	            echangerCase(getCase(p),getCase(p_vide));
	            echangeok ++;
	        }
	    }


	    for (int i=0;i<m_taille;i++)
	    {
	        for  (int j=0;j<m_taille;j++)
	        {
	            getCase(Point(i,j)).setCase_bloquee(false);
	        }
	    }

	    delete vide;

	}

	Point Plateau::genererCoord()
	{

	    return Point((rand() % m_taille) ,(rand() % m_taille ));
	}

	*/
	
	
	
}