package tchoutchou;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class <code>TchouTchou</code>La classe Tchoutchou permet de manipuler l'ensemble du jeu
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2021
 */
public class TchouTchou {

    ///
    /// \brief 
    ///
	/**
	 * m_taille : entier qui correspond à la taille du plateau
	 */
    private int m_taille;

    ///
    /// \brief 
    ///
    /**
     * m_nbAide : entier qui correspond au nombre d'aides déjà dévoilé
     */
    private int m_nbAide;

    ///
    /// \brief 
    ///
    /**
     * m_fautes : entier qui correspond au nombre de fois où le train n'est pas arrivé à la sortie
     */
    private int m_fautes;

    ///
    /// \brief 
    ///
    /**
     * num_soluce : entier indiquant le plateau que l'utilisateur possède
     */
    private int m_num_soluce;

    ///
    /// \brief 
    ///
    /**
     * m_feu : feu du jeu
     */
    private Feu m_feu;

    ///
    /// \brief 
    ///
    /**
     * m_plateauSoluce : plateau contenant la solution qui permet à l'aide d'être mise en place
     */
    private Plateau m_plateauSoluce;

    ///
    /// \brief 
    ///
    /**
     * m_train : train du jeu
     */
    private Train m_train ;

    ///
    /// \brief 
    ///
    /**
     * m_plateau : plateau du jeu
     */
    private Plateau m_plateau ;
        
    /**
     * Constructeur de la classe Tchoutchou
     * @param taille : taille du plateau
     */
	public TchouTchou(int taille)
	{
	    m_taille = taille ;
	    m_nbAide = 0 ;
	    m_fautes = 0;
	    m_num_soluce = 0;
	    m_plateau = new Plateau(m_taille) ;
	    m_plateauSoluce = new Plateau(m_taille) ;
	    initPlateau();
	    m_feu = new Feu(new Point((int)m_plateau.getCase(new Point(0,m_taille-1)).getPoint().getX() + 250, (int)m_plateau.getCase(new Point(0,m_taille-1)).getPoint().getY() + 50)) ;
	    m_train = new Train(new Point((int)m_plateau.getCase(new Point(0,0)).getPoint().getX(),(int)m_plateau.getCase(new Point(0,0)).getPoint().getY() + 100));

	}

	/**
	 * Accesseur de l'attribut train
	 * @return renvoie le train du jeu
	 */
	public Train getTrain()
	{
	    return m_train ;
	}

	/**
	 * Accesseur de l'attribut taille
	 * @return renvoie la taille du plateau du jeu
	 */
	public int getTaille()
	{
	    return m_taille;
	}

	/**
	 * Accesseur de l'attribut plateau
	 * @return renvoie le plateau du jeu
	 */
	public Plateau getPlateau()
	{
	    return m_plateau ;
	}

	/**
	 * Accesseur de l'attribut feu
	 * @return renvoie le feu du jeu
	 */
	public Feu getFeu()
	{
	    return m_feu ;
	}

	/**
	 * Méthode pour afficher les éléments du jeu
	 * @param g : fenêtre graphique
	 */
	void afficher(Graphics2D g)
	{
	    m_plateau.afficher(g) ;
	    m_train.afficher(g) ;
	    m_feu.afficher(g);
	}

	/**
	 * Méthode initPlateau qui permet d'initialiser le plateau et le plateau solution
	 */
	public void initPlateau()
	{

	    if (m_taille == 2) {
	        m_plateauSoluce.setCase(new Point(0,0), m_plateau.InitCase(new RailCourbeGB(new Point()),new Point(0,0))) ;
	        m_plateauSoluce.setCase(new Point(0,1), m_plateau.InitCase(new Vide(new Point()),new Point(0,1))) ;
	        m_plateauSoluce.setCase(new Point(1,0), m_plateau.InitCase(new RailCourbeHD(new Point()),new Point(1,0))) ;
	        m_plateauSoluce.setCase(new Point(1,1), m_plateau.InitCase(new TraverseeHorizontale(new Point()),new Point(1,1))) ;
	    }
	    else {
	    	Random random = new Random();
	        int m_num_soluce = random.nextInt(2) ;

	        if (m_num_soluce == 0)
	        {
	            m_plateauSoluce.setCase(new Point(0,0), m_plateau.InitCase(new RailCourbeGB(new Point()),new Point(0,0))) ;
	            m_plateauSoluce.setCase(new Point(0,1), m_plateau.InitCase(new RailCourbeBD(new Point()),new Point(0,1))) ;
	            m_plateauSoluce.setCase(new Point(0,2), m_plateau.InitCase(new Vide(new Point()),new Point(0,2))) ;
	            m_plateauSoluce.setCase(new Point(1,0), m_plateau.InitCase(new RailCourbeHD(new Point()),new Point(1,0))) ;
	            m_plateauSoluce.setCase(new Point(1,1), m_plateau.InitCase(new RailCourbeGB(new Point()),new Point(1,1))) ;
	            m_plateauSoluce.setCase(new Point(1,2), m_plateau.InitCase(new TraverseeVerticale(new Point()),new Point(1,2))) ;
	            m_plateauSoluce.setCase(new Point(2,0), m_plateau.InitCase(new RailCourbeGH(new Point()),new Point(2,0))) ;
	            m_plateauSoluce.setCase(new Point(2,1), m_plateau.InitCase(new TraverseeVerticale(new Point()),new Point(2,1))) ;
	            m_plateauSoluce.setCase(new Point(2,2), m_plateau.InitCase(new Croisement(new Point()),new Point(2,2))) ;
	        }
	        else {
	            if (m_num_soluce == 1)
	            {

	                m_plateauSoluce.setCase(new Point(0,0), m_plateau.InitCase( new TraverseeHorizontale(new Point()),new Point(0,0))) ;
	                m_plateauSoluce.setCase(new Point(0,1), m_plateau.InitCase( new TraverseeHorizontale(new Point()),new Point(0,1))) ;
	                m_plateauSoluce.setCase(new Point(0,2), m_plateau.InitCase( new RailCourbeGB(new Point()),new Point(0,2))) ;
	                m_plateauSoluce.setCase(new Point(1,0), m_plateau.InitCase( new TraverseeVerticale(new Point()),new Point(1,0))) ;
	                m_plateauSoluce.setCase(new Point(1,1), m_plateau.InitCase( new RailCourbeBD(new Point()),new Point(1,1))) ;
	                m_plateauSoluce.setCase(new Point(1,2), m_plateau.InitCase( new RailCourbeGH(new Point()),new Point(1,2))) ;
	                m_plateauSoluce.setCase(new Point(2,0), m_plateau.InitCase( new Vide(new Point()),new Point(2,0))) ;
	                m_plateauSoluce.setCase(new Point(2,1), m_plateau.InitCase( new Croisement(new Point()),new Point(2,1))) ;
	                m_plateauSoluce.setCase(new Point(2,2), m_plateau.InitCase( new TraverseeHorizontale(new Point()),new Point(2,2))) ;
	            }
	            else
	            {

	                m_plateauSoluce.setCase(new Point(0,0), m_plateau.InitCase( new RailCourbeGB(new Point()),new Point(0,0))) ;
	                m_plateauSoluce.setCase(new Point(0,1), m_plateau.InitCase( new TraverseeHorizontale(new Point()),new Point(0,1))) ;
	                m_plateauSoluce.setCase(new Point(0,2), m_plateau.InitCase( new TraverseeVerticale(new Point()),new Point(0,2))) ;
	                m_plateauSoluce.setCase(new Point(1,0), m_plateau.InitCase( new Croisement(new Point()),new Point(1,0))) ;
	                m_plateauSoluce.setCase(new Point(1,1), m_plateau.InitCase( new Vide(new Point()),new Point(1,1))) ;
	                m_plateauSoluce.setCase(new Point(1,2), m_plateau.InitCase( new RailCourbeGB(new Point()),new Point(1,2))) ;
	                m_plateauSoluce.setCase(new Point(2,0), m_plateau.InitCase( new RailCourbeHD(new Point()),new Point(2,0))) ;
	                m_plateauSoluce.setCase(new Point(2,1), m_plateau.InitCase( new TraverseeHorizontale(new Point()),new Point(2,1))) ;
	                m_plateauSoluce.setCase(new Point(2,2), m_plateau.InitCase( new TraverseeHorizontale(new Point()),new Point(2,2))) ;
	            }
	       }
	    }

	    m_plateau =  new Plateau(m_plateauSoluce);
	    		
	    while (m_plateau.equals(m_plateauSoluce))
	    {
	        //On remélange car la solution est déjà donnée
	        getPlateau().melangePlateau();
	    }

	    m_nbAide = 0;
	    m_fautes = 0;
	}

	/**
	 * Méthode dansQuelleCase qui permet de savoir à partir d'un point de la fenêtre dans quelle case on se trouve
	 * @param p : Point de notre fenêtre
	 * @return renvoie ligne et colonne du plateau ou se trouve notre point , (-1,-1) si on se trouve à coté du plateau
	 */
	public Point dansQuelleCase(Point p)
	{

	    Point nouv = new Point(-1,-1) ;

	    for (int i = 0 ; i < m_taille ; i++) {
	        for (int j = 0 ; j < m_taille ; j++) {
	            if ( ( m_plateau.getCase(new Point(i,j)).getPoint().getX() + 200 >= p.getX() ) && ( m_plateau.getCase(new Point(i,j)).getPoint().getY() + 200 >= p.getY() ) && ( m_plateau.getCase(new Point(i,j)).getPoint().getX() <= p.getX() ) && ( m_plateau.getCase(new Point(i,j)).getPoint().getY() <= p.getY() ) ) {
	                nouv.setLocation(i,j) ;
	            }
	        }
	    }

	    return nouv ;

	}

	/**
	 * Méthode deplacertrain qui permet de déplacer le train dans une case du plateau
	 * @param c : case du plateau
	 */
	public void deplacerTrain(Case c)
	{
	    getTrain().deplacer(c,getTrain().getSens());
	}

	/**
	 * Méthode estalaSortie qui permet de regarder si le train est à la sortie du plateau
	 * @param t : train 
	 * @return renvoie True si le train est à la sortie et false sinon
	 */
	public boolean estalaSortie(Train t)
	{
	    boolean sortie = false;

	    if ((t.getPoint().getX() == m_plateau.getCase(new Point(m_taille-1,m_taille-1)).getPoint().getX()+200) && (t.getPoint().getY() == m_plateau.getCase(new Point(m_taille-1,m_taille-1)).getPoint().getY()+100))
	        sortie = true;

	    return sortie;
	}

	/**
	 * Mutateur de l'attribut m_fautes
	 * @param faute : nombre de fautes commises
	 */
	public void setFaute(int faute)
	{
	    m_fautes = faute ;
	}

	/**
	 * Méthode incrFaute qui permet d'augmenter le nombre de faute du joueur
	 */
	public void incrFaute()
	{
	    m_fautes ++ ;
	}

	/**
	 * Accesseur de l'attribut m_fautes
	 * @return le nombre de fautes déjà commises
	 */
	public int getFaute()
	{
	    return m_fautes ;
	}

	/**
	 * Méthode aide qui permet d'executer une aide en fonction du nombre d'aide déjà dévoilé, uniquement si l'aide à été activé
	 * @param nbAide : entier qui correspond au nombre d'aide déjà dévoilé
	 */
	public void aide(int nbAide)
	{

	    Point p_sol = new Point();
	    Point p_erreur = new Point();
	    //Case vide = new Vide(new Point(0,0)) ;
	    boolean correct = false;
	    List<Point> liste = new ArrayList<Point>();
	    Point p_vide = new Point(m_plateau.rechercheCaseType(7)); //7 correspond au type d'une case Vide

	    if (m_num_soluce == 0)
	    {
	    	liste.add(new Point(0,0));
		    liste.add(new Point(1,0));
		    liste.add(new Point(1,1));
	    }
	    else
	    {
	        if (m_num_soluce == 1)
	        {
	        	liste.add(new Point(0,0));
			    liste.add(new Point(0,1));
			    liste.add(new Point(0,2));
	        }
	        else
	        {
	        	liste.add(new Point(0,0));
			    liste.add(new Point(1,0));
			    liste.add(new Point(2,0));
	        }
	    }

	    if (m_plateauSoluce.getCase(liste.get(nbAide-1)).getType() != m_plateau.getCase(liste.get(nbAide-1)).getType())
	    {
	        p_sol = m_plateau.rechercheCaseType(m_plateauSoluce.getCase(liste.get(nbAide-1)).getType());
	        p_erreur = m_plateau.rechercheCaseType(m_plateau.getCase(liste.get(nbAide-1)).getType());
	    }
	    else
	    {
	        // La case est correcte
	        correct = true;
	        p_sol = liste.get(nbAide-1);
	    }

	    if (!correct)
	    {
	        m_plateau.echangerCase(m_plateau.getCase(p_erreur),m_plateau.getCase(p_vide));
	        p_vide = p_erreur;
	        m_plateau.echangerCase(m_plateau.getCase(p_sol),m_plateau.getCase(p_vide));
	        p_sol = p_vide;
	    }
	    m_plateau.getCase(p_sol).setCase_bloquee(true);

	}

}
