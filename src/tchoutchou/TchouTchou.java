package tchoutchou;
import java.awt.geom.Point2D;

public class TchouTchou {

        ///
        /// \brief m_taille : entier qui correspond à la taille du plateau
        ///
        private int m_taille;

        ///
        /// \brief m_nbAide : entier qui correspond au nombre d'aides déjà dévoilé
        ///
        private int m_nbAide;

        ///
        /// \brief m_fautes : entier qui correspond au nombre de fois où le train n'est pas arrivé à la sortie
        ///
        private int m_fautes;

        ///
        /// \brief num_soluce : entier indiquant le plateau que l'utilisateur possède
        ///
        private int m_num_soluce;

        ///
        /// \brief m_feu : feu du jeu
        ///
        private Feu m_feu;

        ///
        /// \brief m_plateauSoluce : plateau contenant la solution qui permet à l'aide d'être mise en place
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
        
        
	public void TchouTchou(int taille)
	{
	    m_taille = taille ;
	    m_nbAide = 0 ;
	    m_fautes = 0;
	    m_num_soluce = 0;
	    m_plateau = new Plateau(m_taille) ;
	    m_plateauSoluce = new Plateau(m_taille) ;
	    initPlateau();
	    m_feu = new Feu(Point2D(m_plateau.getCase(new Point2D(0,m_taille-1)).getPoint().getX() + 250, m_plateau.getCase(new Point2D(0,m_taille-1)).getPoint().getY() + 50)) ;
	    m_train = new Train(Point(m_plateau.getCase(Point(0,0)).getPoint().getX(),(int)m_plateau.getCase(Point(0,0)).getPoint().getY() + 100)) ;
	}

	TchouTchou::~TchouTchou()
	{
	    delete m_plateau;
	    delete m_plateauSoluce;
	}

	Train& TchouTchou::getTrain() const
	{
	    return *m_train ;
	}

	int TchouTchou::getTaille() const
	{
	    return m_taille;
	}

	Plateau& TchouTchou::getPlateau() const
	{
	    return *m_plateau ;
	}

	feu& TchouTchou::getFeu() const
	{
	    return *m_feu ;
	}

	void TchouTchou::afficher(QPainter* p) const
	{
	    m_plateau->afficher(p) ;
	    m_train->afficher(p) ;
	    m_feu->afficher(p);
	}

	void TchouTchou::initPlateau()
	{

	    if (m_taille == 2) {


	        Case *c1 = new RailCourbeGB(Point()) ;
	        Case *c2 = new Vide(Point()) ;
	        Case *c3 = new RailCourbeHD(Point()) ;
	        Case *c4 = new TraverseeHorizontale(Point()) ;

	        m_plateauSoluce->setCase(Point(0,0), m_plateau->InitCase(*c1,Point(0,0))) ;
	        m_plateauSoluce->setCase(Point(0,1), m_plateau->InitCase(*c2,Point(0,1))) ;
	        m_plateauSoluce->setCase(Point(1,0), m_plateau->InitCase(*c3,Point(1,0))) ;
	        m_plateauSoluce->setCase(Point(1,1), m_plateau->InitCase(*c4,Point(1,1))) ;

	    }
	    else {
	        m_num_soluce = rand() % 2 ;

	        if (m_num_soluce == 0)
	        {
	            Case *c1 = new RailCourbeGB(Point()) ;
	            Case *c2 = new RailCourbeBD(Point()) ;
	            Case *c3 = new Vide(Point()) ;
	            Case *c4 = new RailCourbeHD(Point()) ;
	            Case *c5 = new RailCourbeGB(Point()) ;
	            Case *c6 = new TraverseeVerticale(Point()) ;
	            Case *c7 = new RailCourbeGH(Point()) ;
	            Case *c8 = new RailCourbeHD(Point()) ;
	            Case *c9 = new TraverseeHorizontale(Point()) ;

	            m_plateauSoluce->setCase(Point(0,0), m_plateau->InitCase(*c1,Point(0,0))) ;
	            m_plateauSoluce->setCase(Point(0,1), m_plateau->InitCase(*c2,Point(0,1))) ;
	            m_plateauSoluce->setCase(Point(0,2), m_plateau->InitCase(*c3,Point(0,2))) ;
	            m_plateauSoluce->setCase(Point(1,0), m_plateau->InitCase(*c4,Point(1,0))) ;
	            m_plateauSoluce->setCase(Point(1,1), m_plateau->InitCase(*c5,Point(1,1))) ;
	            m_plateauSoluce->setCase(Point(1,2), m_plateau->InitCase(*c6,Point(1,2))) ;
	            m_plateauSoluce->setCase(Point(2,0), m_plateau->InitCase(*c7,Point(2,0))) ;
	            m_plateauSoluce->setCase(Point(2,1), m_plateau->InitCase(*c8,Point(2,1))) ;
	            m_plateauSoluce->setCase(Point(2,2), m_plateau->InitCase(*c9,Point(2,2))) ;
	        }
	        else {
	            if (m_num_soluce == 1)
	            {
	                Case *c1 = new TraverseeHorizontale(Point()) ;
	                Case *c2 = new TraverseeHorizontale(Point()) ;
	                Case *c3 = new RailCourbeGB(Point()) ;
	                Case *c4 = new TraverseeVerticale(Point()) ;
	                Case *c5 = new RailCourbeBD(Point()) ;
	                Case *c6 = new RailCourbeGH(Point()) ;
	                Case *c7 = new Vide(Point()) ;
	                Case *c8 = new RailCourbeHD(Point()) ;
	                Case *c9 = new TraverseeHorizontale(Point()) ;

	                m_plateauSoluce->setCase(Point(0,0), m_plateau->InitCase(*c1,Point(0,0))) ;
	                m_plateauSoluce->setCase(Point(0,1), m_plateau->InitCase(*c2,Point(0,1))) ;
	                m_plateauSoluce->setCase(Point(0,2), m_plateau->InitCase(*c3,Point(0,2))) ;
	                m_plateauSoluce->setCase(Point(1,0), m_plateau->InitCase(*c4,Point(1,0))) ;
	                m_plateauSoluce->setCase(Point(1,1), m_plateau->InitCase(*c5,Point(1,1))) ;
	                m_plateauSoluce->setCase(Point(1,2), m_plateau->InitCase(*c6,Point(1,2))) ;
	                m_plateauSoluce->setCase(Point(2,0), m_plateau->InitCase(*c7,Point(2,0))) ;
	                m_plateauSoluce->setCase(Point(2,1), m_plateau->InitCase(*c8,Point(2,1))) ;
	                m_plateauSoluce->setCase(Point(2,2), m_plateau->InitCase(*c9,Point(2,2))) ;
	            }
	            else
	            {
	                Case *c1 = new RailCourbeGB(Point()) ;
	                Case *c2 = new TraverseeHorizontale(Point()) ;
	                Case *c3 = new TraverseeVerticale(Point()) ;
	                Case *c4 = new TraverseeVerticale(Point()) ;
	                Case *c5 = new Vide(Point()) ;
	                Case *c6 = new RailCourbeGB(Point()) ;
	                Case *c7 = new RailCourbeHD(Point()) ;
	                Case *c8 = new TraverseeHorizontale(Point()) ;
	                Case *c9 = new TraverseeHorizontale(Point()) ;

	                m_plateauSoluce->setCase(Point(0,0), m_plateau->InitCase(*c1,Point(0,0))) ;
	                m_plateauSoluce->setCase(Point(0,1), m_plateau->InitCase(*c2,Point(0,1))) ;
	                m_plateauSoluce->setCase(Point(0,2), m_plateau->InitCase(*c3,Point(0,2))) ;
	                m_plateauSoluce->setCase(Point(1,0), m_plateau->InitCase(*c4,Point(1,0))) ;
	                m_plateauSoluce->setCase(Point(1,1), m_plateau->InitCase(*c5,Point(1,1))) ;
	                m_plateauSoluce->setCase(Point(1,2), m_plateau->InitCase(*c6,Point(1,2))) ;
	                m_plateauSoluce->setCase(Point(2,0), m_plateau->InitCase(*c7,Point(2,0))) ;
	                m_plateauSoluce->setCase(Point(2,1), m_plateau->InitCase(*c8,Point(2,1))) ;
	                m_plateauSoluce->setCase(Point(2,2), m_plateau->InitCase(*c9,Point(2,2))) ;
	            }
	       }
	    }
	    *m_plateau = *m_plateauSoluce;

	    while (*m_plateau == *m_plateauSoluce)
	    {
	        //On remélange car la solution est déjà donnée
	        this->getPlateau().melangePlateau();
	    }

	    m_nbAide = 0;
	    m_fautes = 0;
	}


	Point TchouTchou::dansQuelleCase(Point p)
	{

	    Point nouv(-1,-1) ;

	    for (int i = 0 ; i < m_taille ; i++) {
	        for (int j = 0 ; j < m_taille ; j++) {
	            if ( ( m_plateau->getCase(Point(i,j)).getPoint().getX() + 200 >= p.getX() ) && ( m_plateau->getCase(Point(i,j)).getPoint().getY() + 200 >= p.getY() ) && ( m_plateau->getCase(Point(i,j)).getPoint().getX() <= p.getX() ) && ( m_plateau->getCase(Point(i,j)).getPoint().getY() <= p.getY() ) ) {
	                nouv.setX(i) ;
	                nouv.setY(j) ;
	            }
	        }
	    }

	    return nouv ;

	}

	void TchouTchou::deplacerTrain(Case& c)
	{
	    this->getTrain().deplacer(c,this->getTrain().getSens());
	}

	bool TchouTchou::estalaSortie(Train t)
	{
	    bool sortie = false;

	    if ((t.getPoint().getX() == m_plateau->getCase(Point(m_taille-1,m_taille-1)).getPoint().getX()+200) && (t.getPoint().getY() == m_plateau->getCase(Point(m_taille-1,m_taille-1)).getPoint().getY()+100))
	        sortie = true;

	    return sortie;
	}

	void TchouTchou::setFaute(int faute)
	{
	    this->m_fautes = faute ;
	}

	void TchouTchou::incrFaute()
	{
	    this->m_fautes ++ ;
	}

	int TchouTchou::getFaute() const
	{
	    return m_fautes ;
	}

	void TchouTchou::aide(int nbAide)
	{

	    Point p_sol;
	    Point p_erreur;
	    Point p_vide;
	    Case *vide = new Vide(Point(0,0)) ;
	    bool correct = false;
	    QList<Point> liste;
	    p_vide = m_plateau->rechercheCaseType(vide->getType());

	    if (m_num_soluce == 0)
	        liste = {Point(0,0),Point(1,0),Point(1,1)};
	    else
	    {
	        if (m_num_soluce == 1)
	            liste = {Point(0,0),Point(0,1),Point(0,2)};
	        else
	            liste = {Point(0,0),Point(1,0),Point(2,0)};
	    }

	    if (m_plateauSoluce->getCase(liste[nbAide-1]).getType() != m_plateau->getCase(liste[nbAide-1]).getType())
	    {
	        p_sol = m_plateau->rechercheCaseType(m_plateauSoluce->getCase(liste[nbAide-1]).getType());
	        p_erreur = m_plateau->rechercheCaseType(m_plateau->getCase(liste[nbAide-1]).getType());
	    }
	    else
	    {
	        // La case est correcte
	        correct = true;
	        p_sol = liste[nbAide-1];
	    }

	    if (!correct)
	    {
	        m_plateau->echangerCase(m_plateau->getCase(p_erreur),m_plateau->getCase(p_vide));
	        p_vide = p_erreur;
	        m_plateau->echangerCase(m_plateau->getCase(p_sol),m_plateau->getCase(p_vide));
	        p_sol = p_vide;
	    }
	    m_plateau->getCase(p_sol).setCase_bloquee(true);

	}

}
