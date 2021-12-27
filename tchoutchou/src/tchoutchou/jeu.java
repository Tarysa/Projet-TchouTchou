package tchoutchou;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;


public class jeu extends JDialog {

	private MonPanelJeu contentPanel;

	private TchouTchou monPlateau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			jeu dialog = new jeu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public void jeu() {
		setTitle("Partie de TchouTchou");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 900) / 2, (screenSize.height - 800) / 2, 900, 800);

		contentPanel = new MonPanelJeu(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		TchouTchou partie = new TchouTchou(mainwindow.niveau);
		
		timer = new QTimer(this) ;
	    connect(timer, SIGNAL(timeout()), this, SLOT(update())) ;
		
	}

	public void dessiner(Graphics g) {
		afficherFond((Graphics2D) g);

	}

	public void afficherFond(Graphics2D g) {

		g.setColor(new Color(0, 0, 0));
		g.setStroke(new BasicStroke(10));
		g.drawRect(150, 150, 200, 200);
		g.setColor(new Color(0, 153, 0));
		g.fillRect(150, 150, 200, 200);
		g.setColor(new Color(204, 0, 0));
		g.setStroke(new BasicStroke(50));
		g.fillArc(150 - 120, 150 - 120, 240, 240, -90, 90);
		g.setColor(new Color(0, 153, 0));
		g.fillArc(150 - 80, 150 - 80, 160, 160, -90, 90);
	}

	public void cliquerFeu()
	{
	   // Pré-réglage
		monPlateau.getTrain().setEnDeplacement(true);
		Point p_case = new Point(0,0);
		monPlateau.getTrain().setSens(monPlateau.getPlateau().getCase(p_case).sens(monPlateau.getTrain())) ;
		monPlateau.getFeu().MiseAuVert();
	   // Lancement du timer
	   timer->start(10) ;
	}
	
	void initJeu(boolean win)
	{
	    if (win)
	    {
	        if (mainwindow.NbPartie <= 4)
	            mainwindow.NbPartie ++;
	        monPlateau.setFaute(0);
	        //jeu.getPlateau().melangePlateau();
	    }
	    else
	    	monPlateau.incrFaute();


	    monPlateau.getTrain().reinitTrain();
	    monPlateau.getTrain().setPoint(Point(monPlateau.getPlateau().getCase(new Point(0,0)).getPoint().getX(),monPlateau.getPlateau().getCase(new Point(0,0)).getPoint().getY()+100));
	    monPlateau.getFeu().MiseAuRouge();

	}
}
