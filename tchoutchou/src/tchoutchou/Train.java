package tchoutchou;

import java.awt.Point;

import javax.swing.ImageIcon;

import java.awt.Graphics2D;


/**
 * Class <code>Case</code>La classe Train permet de manipuler des trains
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/12/2021
 */

public class Train extends ObjetGraphiqueMobile{
	
	private boolean m_EnDeplacement;
	private int m_sens;
	
	/**
	 * Constructeur de la classe Train
	 * @param p : Point qui correspond à l'endroit où se trouvera cet objet graphique
	 */
	public Train(Point p) {
		super(new Point(p));
		m_EnDeplacement = false;
		m_sens = 1;
	}
	
	/**
	 * Méthode deplacer permettant de déplacer le train au sein d'une case
	 * @param c : case où le train va se déplacer
	 * @param sens : sens dans lequel va se déplacer le train dans cette case
	 */
	public void deplacer(Case c, int sens) {
		
		if (sens == 1)
			m_p.setLocation(c.trajectoire(m_p, true));
		else
			m_p.setLocation(c.trajectoire(m_p, false));
	}
	
	/**
	 * Méthode reinitTrain qui permet de reinitialiser son sens ainsi que le fait que le train soit en déplacement ou non
	 */
	public void reinitTrain() {
		
		m_EnDeplacement = false;
		m_sens = 1;
	}
	
	/**
	 * Méthode afficher permettant d'afficher le train sur le jeu
	 */
	@Override
	public void afficher(Graphics2D g)
	{
		g.drawImage(new ImageIcon("ImageTchouTchou/TrainBleuRougeST.png").getImage(), (int)m_p.getX()-21, (int)m_p.getY()-28, 50, 50, null);
	}
	
	/**
	 * Méthode estDansCase permettant de regarder l'appartenance ou non du train à une case
	 * @param c : case
	 * @return true si le train se trouve dans la case c et false sinon
	 */
	public boolean estDansCase(Case c) {
		
		boolean sol = false;
		
		while( (m_p.getX() < c.getPoint().getX() + 200) && (m_p.getY() < c.getPoint().getY() + 200) && (m_p.getX() > c.getPoint().getX()) && (m_p.getY() > c.getPoint().getY()) && !sol)
			sol = true;
		
		return sol;
	}
	
	/**
	 * Mutateur de m_EnDeplacement
	 * @param dep : booléen qui indique si le train est en déplacement
	 */
	public void setEnDeplacement(boolean dep) {
		
		m_EnDeplacement = dep;
	}
	
	/**
	 * Accesseur de m_EnDeplacement
	 * @return renvoie true si le train est en train de se déplacer, false sinon
	 */
	public boolean getEnDeplacement() {
		
		return m_EnDeplacement;
	}
	
	/**
	 * Mutateur de m_sensTrain
	 * @param s : entier correspondant au sens du train
	 */
	public void setSens(int s) {
		
		m_sens = s;
	}
	
	/**
	 * Accesseur de m_sensTrain
	 * @return renvoie le sens de notre train
	 */
	public int getSens() {
		
		return m_sens;
	}

}
