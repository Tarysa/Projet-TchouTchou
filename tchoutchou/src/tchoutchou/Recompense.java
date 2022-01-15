package tchoutchou;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Class <code>Recompense</code>La classe Récompense permet  de manipuler la collection de trains du joueur
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
public class Recompense {
	
	/**
	 * entier qui correspond au numéro du train qui est selectionné par le joueur
	 */
	static int numTrain = 1;
	
	/**
	 * Méthode afficher qui permet d'afficher la collection de train en grisant les trains non débloqués
	 * @param g : fenêtre graphique
	 * @param NbTrainDebloque : entier correspondant au nombre de trains qui sont débloqués
	 */
	public void afficher(Graphics2D g, int NbTrainDebloque) {
		Color p1 = new Color(0, 0, 0);
		Color p2 = new Color(0, 0, 0);
		Color p3 = new Color(0, 0, 0);
		Color p4 = new Color(0, 0, 0);
		Color p5 = new Color(0, 0, 0);

		switch (Recompense.numTrain) {
		    case 1: p1 = new Color(237, 28, 36, 255);
			break;
		    case 2: p2 = new Color(237, 28, 36, 255);
			break;
		    case 3: p3 = new Color(237, 28, 36, 255);
			break;
		    case 4: p4 = new Color(237, 28, 36, 255);
			break;
		    case 5: p5 = new Color(237, 28, 36, 255);
			break;
		}

		// Affichage Train 1
		g.setColor(p1);
		g.setStroke(new BasicStroke(10));
		g.drawRect(100, 100, 125, 125);
		g.drawImage(new ImageIcon("ImageTchouTchou/FondTrainVert.png").getImage(), 100, 100, 125, 125, null);
		g.drawImage(new ImageIcon("ImageTchouTchou/TrainRougeVertST.png").getImage(), 112, 112, 100, 100, null);

		// Affichage Train 2
		g.setColor(p2);
		g.drawRect(300, 100, 125, 125);
		g.drawImage(new ImageIcon("ImageTchouTchou/FondNeige.jpg").getImage(), 300, 100, 125, 125, null);
		g.drawImage(new ImageIcon("ImageTchouTchou/TrainBleuRougeST.png").getImage(), 312, 112, 100, 100, null);

		// Affichage Train 3
		g.setColor(p3);
		g.drawRect(100, 400, 125, 125);
		g.drawImage(new ImageIcon("ImageTchouTchou/FondAutomne.jpg").getImage(), 100, 400, 125, 125, null);
		g.drawImage(new ImageIcon("ImageTchouTchou/TrainOrangeMarronST.png").getImage(), 112, 412, 100, 100, null);

		// Affichage Train 4
		g.setColor(p4);
		g.drawRect(300, 400, 125, 125);
		g.drawImage(new ImageIcon("ImageTchouTchou/FondMarron.jpg").getImage(), 300, 400, 125, 125, null);
		g.drawImage(new ImageIcon("ImageTchouTchou/TrainOrangeVertST.png").getImage(), 312, 412, 100, 100, null);

		// Affichage Train 5
		g.setColor(p5);
		g.drawRect(200, 250, 125, 125);
		g.drawImage(new ImageIcon("ImageTchouTchou/FondKids.jpg").getImage(), 200, 250, 125, 125, null);
		g.drawImage(new ImageIcon("ImageTchouTchou/TrainKidST.png").getImage(), 212, 262, 100, 100, null);

		switch (NbTrainDebloque) {
		case 5: // On affiche tous les train
			break;
		case 4: // On affiche les 4 trains ext et on masque celui du centre
			g.setColor(new Color(0, 0, 0, 234));
			g.fillRect(200, 250, 125, 125);
			break;
		case 3: // On affiche les 3 premiers
			g.setColor(new Color(0, 0, 0, 234));
			g.fillRect(200, 250, 125, 125);
			g.fillRect(300, 400, 125, 125);
			break;
		case 2: // On affiche les 2 premiers
			g.setColor(new Color(0, 0, 0, 234));
			g.fillRect(200, 250, 125, 125);
			g.fillRect(300, 400, 125, 125);
			g.fillRect(100, 400, 125, 125);
			break;
		case 1: // On affiche que le train de base
			g.setColor(new Color(0, 0, 0, 234));
			g.fillRect(200, 250, 125, 125);
			g.fillRect(300, 400, 125, 125);
			g.fillRect(100, 400, 125, 125);
			g.fillRect(300, 100, 125, 125);
			break;
		}
	}

}
