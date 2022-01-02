package tchoutchou;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TchouTchou {

        ///
        /// \brief m_taille : entier qui correspond � la taille du plateau
        ///
        private int m_taille;

        ///
        /// \brief m_nbAide : entier qui correspond au nombre d'aides d�j� d�voil�
        ///
        private int m_nbAide;

        ///
        /// \brief m_fautes : entier qui correspond au nombre de fois o� le train n'est pas arriv� � la sortie
        ///
        private int m_fautes;

        ///
        /// \brief num_soluce : entier indiquant le plateau que l'utilisateur poss�de
        ///
        private int m_num_soluce;

        ///
        /// \brief m_feu : feu du jeu
        ///
        private Feu m_feu;

        ///
        /// \brief m_plateauSoluce : plateau contenant la solution qui permet � l'aide d'�tre mise en place
        ///
        private Plateau m_plateauSoluce;

        ///
        /// \brief m_train : train du jeu
        ///
        private Train m_train ;

        ///
        /// \brief m_plateau : plateau du jeu
        ///
        private Plateau m_plateau ;
        
        
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

	/* public TchouTchou::~TchouTchou()
	{
	    delete m_plateau;
	    delete m_plateauSoluce;
	} */

	public Train getTrain()
	{
	    return m_train ;
	}

	public int getTaille()
	{
	    return m_taille;
	}

	public Plateau getPlateau()
	{
	    return m_plateau ;
	}

	public Feu getFeu()
	{
	    return m_feu ;
	}

	void afficher(Graphics2D g)
	{
	    m_plateau.afficher(g) ;
	    m_train.afficher(g) ;
	    m_feu.afficher(g);
	}

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
	            m_plateauSoluce.setCase(new Point(2,1), m_plateau.InitCase(new RailCourbeHD(new Point()),new Point(2,1))) ;
	            m_plateauSoluce.setCase(new Point(2,2), m_plateau.InitCase(new TraverseeHorizontale(new Point()),new Point(2,2))) ;
	        }
	        else {
	            if (m_num_soluce == 1)
	            {
	                Case  c1 = new TraverseeHorizontale(new Point()) ;
	                Case  c2 = new TraverseeHorizontale(new Point()) ;
	                Case  c3 = new RailCourbeGB(new Point()) ;
	                Case  c4 = new TraverseeVerticale(new Point()) ;
	                Case  c5 = new RailCourbeBD(new Point()) ;
	                Case  c6 = new RailCourbeGH(new Point()) ;
	                Case  c7 = new Vide(new Point()) ;
	                Case  c8 = new RailCourbeHD(new Point()) ;
	                Case  c9 = new TraverseeHorizontale(new Point()) ;

	                m_plateauSoluce.setCase(new Point(0,0), m_plateau.InitCase( c1,new Point(0,0))) ;
	                m_plateauSoluce.setCase(new Point(0,1), m_plateau.InitCase( c2,new Point(0,1))) ;
	                m_plateauSoluce.setCase(new Point(0,2), m_plateau.InitCase( c3,new Point(0,2))) ;
	                m_plateauSoluce.setCase(new Point(1,0), m_plateau.InitCase( c4,new Point(1,0))) ;
	                m_plateauSoluce.setCase(new Point(1,1), m_plateau.InitCase( c5,new Point(1,1))) ;
	                m_plateauSoluce.setCase(new Point(1,2), m_plateau.InitCase( c6,new Point(1,2))) ;
	                m_plateauSoluce.setCase(new Point(2,0), m_plateau.InitCase( c7,new Point(2,0))) ;
	                m_plateauSoluce.setCase(new Point(2,1), m_plateau.InitCase( c8,new Point(2,1))) ;
	                m_plateauSoluce.setCase(new Point(2,2), m_plateau.InitCase( c9,new Point(2,2))) ;
	            }
	            else
	            {
	                Case  c1 = new RailCourbeGB(new Point()) ;
	                Case  c2 = new TraverseeHorizontale(new Point()) ;
	                Case  c3 = new TraverseeVerticale(new Point()) ;
	                Case  c4 = new TraverseeVerticale(new Point()) ;
	                Case  c5 = new Vide(new Point()) ;
	                Case  c6 = new RailCourbeGB(new Point()) ;
	                Case  c7 = new RailCourbeHD(new Point()) ;
	                Case  c8 = new TraverseeHorizontale(new Point()) ;
	                Case  c9 = new TraverseeHorizontale(new Point()) ;

	                m_plateauSoluce.setCase(new Point(0,0), m_plateau.InitCase( c1,new Point(0,0))) ;
	                m_plateauSoluce.setCase(new Point(0,1), m_plateau.InitCase( c2,new Point(0,1))) ;
	                m_plateauSoluce.setCase(new Point(0,2), m_plateau.InitCase( c3,new Point(0,2))) ;
	                m_plateauSoluce.setCase(new Point(1,0), m_plateau.InitCase( c4,new Point(1,0))) ;
	                m_plateauSoluce.setCase(new Point(1,1), m_plateau.InitCase( c5,new Point(1,1))) ;
	                m_plateauSoluce.setCase(new Point(1,2), m_plateau.InitCase( c6,new Point(1,2))) ;
	                m_plateauSoluce.setCase(new Point(2,0), m_plateau.InitCase( c7,new Point(2,0))) ;
	                m_plateauSoluce.setCase(new Point(2,1), m_plateau.InitCase( c8,new Point(2,1))) ;
	                m_plateauSoluce.setCase(new Point(2,2), m_plateau.InitCase( c9,new Point(2,2))) ;
	            }
	       }
	    }
	    m_plateau =  m_plateauSoluce;

	    /*while ( m_plateau ==  m_plateauSoluce)
	    {
	        //On rem�lange car la solution est d�j� donn�e
	        //getPlateau().melangePlateau();
	    }*/

	    m_nbAide = 0;
	    m_fautes = 0;
	}


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

	public void deplacerTrain(Case c)
	{
	    getTrain().deplacer(c,getTrain().getSens());
	}

	public boolean estalaSortie(Train t)
	{
	    boolean sortie = false;

	    if ((t.getPoint().getX() == m_plateau.getCase(new Point(m_taille-1,m_taille-1)).getPoint().getX()+200) && (t.getPoint().getY() == m_plateau.getCase(new Point(m_taille-1,m_taille-1)).getPoint().getY()+100))
	        sortie = true;

	    return sortie;
	}

	public void setFaute(int faute)
	{
	    m_fautes = faute ;
	}

	public void incrFaute()
	{
	    m_fautes ++ ;
	}

	public int getFaute()
	{
	    return m_fautes ;
	}

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
