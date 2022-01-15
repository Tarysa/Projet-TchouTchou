package tchoutchou;

import java.awt.Point;
import java.util.Random;
import java.awt.Graphics2D;

/**
 * Class <code>Plateau</code>La classe Plateau permet de manipuler le tableau de jeu
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 13/12/2021
 */

public class Plateau{

	/**
	 * Entier qui correspond � la taille du plateau
	 */
	private int m_taille;
	
	/**
	 * Matrice de case repr�sentant le plateau
	 */
	private Case[][] m_plateau;
	
	/**
	 * Constructeur de la classe Plateau
	 * @param taille : entier correspondant � la taille du plateau
	 */
	public Plateau(int taille){
		
		m_taille = taille;
		m_plateau = new Case[taille][taille];
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				m_plateau[i][j] = null;
			}
		}
	}
	
	/**
	 * Constructeur de recopie pour le plateau
	 * @param p : plateau servant pour la copie
	 */
	public Plateau(Plateau p){
		
		m_taille = p.m_taille;
		m_plateau = new Case[m_taille][m_taille];
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				m_plateau[i][j] = p.m_plateau[i][j];
			}
		}
	}
	
	/**
	 * Accesseur de la taille du plateau
	 * @return renvoie la taille du plateau
	 */
	public int getTaille() {
		return m_taille;
	}
	
	/**
	 * Mutateur pour mettre � jour une case du plateau
	 * @param p : cooordonn�es dans le plateau de la case � mettre � jour 
	 * @param c : case � ins�rer dans le plateau
	 */
	public void setCase(Point p, Case c) {
		m_plateau[(int)p.getX()][(int)p.getY()] = c;
	}
	
	/**
	 * Accesseur d'une case d'un plateau
	 * @param p : coordonn�es dans le plateau de la case voulue
	 * @return renvoie la case 
	 */
	public Case getCase(Point p) {
		return m_plateau[(int)p.getX()][(int)p.getY()];
	}
	
	/**
	 * Affichage d'une case
	 * @param g : fenetre graphique
	 */
	public void afficher(Graphics2D g) {
		
		//Affichage par d�faut des cases
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				getCase(new Point(i,j)).afficher(g);
			}
		}
		
		
		//Suraffichage pour les cases s�lectionn�es ou dans un �tat bloqu�
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				if ( (getCase(new Point(i,j)).getCase_Selectionnee()) || (getCase(new Point(i,j)).getCase_bloquee())) {
					getCase(new Point(i,j)).afficher(g);
				}
			}
		}
	}
	
	/**
	 * M�thode rechercheCase qui permet de chercher la case dans le tableau � partir d'un point se situant dans le plateau
	 * @param p: Point qui correspond au coordonn�e du point de la fen�tre
	 * @return renvoie (-1,-1) si le point n'appartient pas au tableau sinon renvoie les coordonn�es du plateau (ligne,colonne) si le point appartient au plateau
	 */
	public Point rechercheCase(Point p) {
		
		Point nouv = new Point(-1, -1);
		for (int i = 0; i < m_taille; i ++) {
			for (int j = 0; j < m_taille; j ++) {
				if (( m_plateau[i][j].getPoint().getX() == p.getX() ) && (m_plateau[i][j].getPoint().getY() == p.getY() )) {
					nouv.setLocation(i,j) ;
				}
			}
		}
		
		return nouv;
		
	}
	
	/**
	 * M�thode echangerCase qui permet d'�changer deux cases de notre plateau
	 * @param c1 : premi�re case du plateau � �changer
	 * @param c2 : seconde case du plateau � �changer
	 * @return renvoie true si l'�change � �t� effectuer, false si c'est immpossible
	 */
	public boolean echangerCase(Case c1, Case c2) {

		// On recup�re les coordonn�es dans le plateau des deux cases
	    Point v1 = rechercheCase(c1.getPoint()) ;
	    Point v2 = rechercheCase(c2.getPoint()) ;

	    if (!(c1 instanceof Vide) && !(c2 instanceof Vide)) {
	        // Cas o� les deux cases ne sont pas vides
	    }
	    else {
	        if ( (!c1.getCase_bloquee()) && (!c2.getCase_bloquee()))
	        {
	            Point pt = c2.getPoint() ;
	            c2.setPoint(c1.getPoint()) ;
	            setCase(v2, c1) ;
	            c1.setPoint(pt) ;
	            setCase(v1, c2) ;
	            return true ;
	        }
	    }

	    return false ;

	}
	
	/**
	 * M�thode InitCase qui permet d'initialiser le point d'une case du plateau en fonction de sa position dans le plateau et de la taille du plateau
	 * @param c : case du plateau � initialiser
	 * @param coord_plateau : Point correspondant � sa place dans le plateau
	 * @return renvoie la case ainsi modifi�e
	 */
	public Case InitCase(Case c, Point coord_plateau)
	{
	    Point n_p = new Point();

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

	/**
	 * M�thode rechercheCaseType qui permet de cherche une case dans le plateau � partir d'un type
	 * @param type : entier type qui est recherch� dans le plateau
	 * @return renvoie (-1,-1) si le type na pas �t� trouv� dans le tableau sinon renvoie les coordonn�es du plateau (ligne,colonne) qui correspond
	 */
	public Point rechercheCaseType(int type) {

	    Point nouv = new Point(-1,-1) ;
	    boolean trouve = false;
	    int i=0;
	    
	    while((i<m_taille)&&(!trouve))
	    {
	        int j = 0;
	        while((j<m_taille)&&(!trouve))
	        {
	            if (( m_plateau[i][j].getType() == type )&&(!m_plateau[i][j].getCase_bloquee())) {
	                nouv.setLocation(i,j) ;
	                trouve = true;
	            }
	            j ++;
	        }
	       i++;
	    }

	    return nouv ;
	}
	
	/**
	 * Surcharge de la m�thode equals entre 2 objets
	 * @param p : plateau � comparer avec la plateau courant
	 * @return renvoie true si p poss�de les m�mes cases et false sinon
	 */
	public boolean equals(Plateau p) {
		
		boolean res = true;
		
		int i = 0, j=0;
		
		while(res && i<m_taille) {
			while(res && j<m_taille) {
				if (! m_plateau[i][j].equals(p.getCase(new Point(i,j))))
					res = false;
				j++;
			}
			i++;
		}
		
		return res;
	}
	
	/**
	 * M�thode melangePlateau qui permet de m�langer les cases au sein du plateau
	 */
	public void melangePlateau()
	{
	    int echangeok = 0 ;
	    int nbechange = m_taille * m_taille;

	    while(echangeok < nbechange)
	    {
	        //On recherche la case vide
	        Point p_vide = rechercheCaseType(7);
	        //On g�n�re un point du plateau
	        Point p = genererCoord();
	        if ((p_vide.getX() != p.getX())||(p_vide.getY() != p.getY()))
	        {
	            //Les deux cases sont diff�rentes
	            echangerCase(getCase(p),getCase(p_vide));
	            echangeok ++;
	        }
	    }


	    for (int i=0;i<m_taille;i++)
	    {
	        for  (int j=0;j<m_taille;j++)
	        {
	            getCase(new Point(i,j)).setCase_bloquee(false);
	        }
	    }

	}

	/**
	 * M�thode genererCoord qui permet de generer un point al�atoire dans le plateau
	 * @return renvoie un point entre 0 et la taille du plateau dans le plateau al�atoirement
	 */
	public Point genererCoord()
	{
		Random random = new Random();
        int x = random.nextInt(m_taille) ;
        int y = random.nextInt(m_taille) ;
        
	    return new Point(x,y);
	}

	
	
	
}