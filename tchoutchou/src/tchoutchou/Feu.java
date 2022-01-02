package tchoutchou;

import java.awt.Point;

import javax.swing.ImageIcon;

import java.awt.Graphics2D;

/**
 * Class <code>Feu</code>La classe feu permet de manipuler le feu du jeu
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 29/11/2021
 */

public class Feu extends ObjetGraphiqueFixe{

	/**
     * m_etat : bool�en qui repr�sente l'�tat du feu, true = feu vert, false = feu rouge
     */
	private boolean m_etat ;
    
	/**
	 * Constructeur de la classe feu
	 * @param p : Point qui correspond � l'endroit o� se trouvera ce feu
	 */
	public Feu(Point p) {
		
		super(p);
	}
	
	/**
	 * M�thode MiseAuRouge permettant de mettre le feu au rouge
	 */
	public void MiseAuRouge() {
		m_etat = false;
	}
	
	/**
	 * M�thode MiseAuVert permettant de mettre le feu au vert
	 */
	public void MiseAuVert() {
		m_etat = true;
	}
	
	/**
	 * M�thode afficher permettant d'afficher le feu sur le jeu
	 */
	@Override
	public void afficher(Graphics2D g)
	{
		if (m_etat)
			g.drawImage(new ImageIcon("ImageTchouTchou/FeuVert.png").getImage(), (int)m_p.getX(), (int)m_p.getY(), 41, 100, null);
		else
			g.drawImage(new ImageIcon("ImageTchouTchou/FeuRouge.png").getImage(), (int)m_p.getX(), (int)m_p.getY(), 41, 100, null);
	}
	
}
