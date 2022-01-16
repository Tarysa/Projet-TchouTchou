package tchoutchou;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;

import java.awt.Image;
import java.awt.Point;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class <code>mainwindow</code>La classe mainwindow permet d'afficher notre
 * page d'accueils
 * 
 * @author Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
public class mainwindow extends JFrame implements ActionListener {

	/**
	 * Image de fond
	 */
	private ImageIcon monImageFond = new ImageIcon("ImageTchouTchou/Gare.jpg");

	/**
	 * Panel lié au mainwindow
	 */
	private MonPanel contentPane;

	/**
	 * Niveau du jeu (2x2 ou 3x3)
	 */
	static int niveau = 2;

	/**
	 * Nombre de partie joué
	 */
	static int NbPartie = 1;

	/**
	 * Aide au joueur
	 */
	static boolean aide = false;

	/**
	 * Checkbow lié à l'aide
	 */
	private JCheckBox checkbox;

	/**
	 * 
	 * @param args : arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainwindow frame = new mainwindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainwindow() {

		setTitle("TchouTchou");
		setIconImage(new ImageIcon("ImageTchouTchou/ID.png").getImage());

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 800) / 2, (screenSize.height - 600) / 2, 800, 600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Ici on place le check box
		checkbox = new JCheckBox("Check");
		checkbox.setBounds(100, 90, 16, 16);
		checkbox.addActionListener(this);

		contentPane = new MonPanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		// Ajout des boutons
		contentPane.add(checkbox);

		// On regarde le click
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				formMouseClicked(e);
			}
		});

	}

	/**
	 * Affichage du fond de la page d'accueil
	 * 
	 * @param g : fenêtre graphique
	 */
	public void dessiner(Graphics g) {
		g.drawImage(monImageFond.getImage(), 0, 0, 800, 600, null);
		selectniv((Graphics2D) g);
		g.drawImage(new ImageIcon("ImageTchouTchou/LogoPlay.png").getImage(), 260, 220, 291, 81, null);

	}

	/**
	 * Méthode permettant d'afficher graphiquement le niveau voulu
	 * 
	 * @param g : fenêtre graphique
	 */
	public void selectniv(Graphics2D g) {
		// Cas 2x2 et 3x3
		Color c2x2 = new Color(0, 0, 0);
		Color c3x3 = new Color(0, 0, 0);

		if (niveau == 2) {
			c2x2 = new Color(160, 82, 45);
		} else {
			c3x3 = new Color(160, 82, 45);
		}

		// Cas 2x2
		g.setColor(c2x2);
		g.setStroke(new BasicStroke(10));
		g.drawRoundRect(200, 375, 150, 150, 10, 10);

		g.setColor(new Color(21, 68, 155));
		g.fillRoundRect(200, 375, 150, 150, 10, 10);

		g.setColor(new Color(0, 0, 0));
		g.setStroke(new BasicStroke(3));
		g.drawLine(275, 375, 275, 525);
		g.drawLine(200, 450, 350, 450);

		// Cas 3x3
		g.setColor(c3x3);
		g.setStroke(new BasicStroke(10));
		g.drawRoundRect(450, 375, 150, 150, 10, 10);

		g.setColor(new Color(21, 68, 155));
		g.fillRoundRect(450, 375, 150, 150, 10, 10);

		g.setColor(new Color(0, 0, 0));
		g.setStroke(new BasicStroke(3));
		g.drawLine(500, 375, 500, 525);
		g.drawLine(550, 375, 550, 525);
		g.drawLine(450, 425, 600, 425);
		g.drawLine(450, 475, 600, 475);

	}

	/**
	 * 
	 * @param evt : Evenement lié au clic
	 */
	private void formMouseClicked(MouseEvent evt) {
		// On rÃ©cupere les coordonnÃ©es du pointeur de la souris dans la fenÃªtre
		int sourisX = evt.getPoint().x;
		int sourisY = evt.getPoint().y;
		// On fait le changement de repÃ¨re pour se ramener au ContentPane

		if ((sourisX >= 200 && sourisX <= 350) && (sourisY >= 375 && sourisY <= 525)) {
			niveau = 2;
		}
		if ((sourisX >= 450 && sourisX <= 600) && (sourisY >= 375 && sourisY <= 525)) {
			niveau = 3;
		}
		if ((sourisX >= 35 && sourisX <= 110) && (sourisY >= 453 && sourisY <= 528)) {
			regle regles = new regle();
			regles.setVisible(true);
		}
		if ((sourisX >= 260 && sourisX <= 260 + 291) && (sourisY >= 220 && sourisY <= 220 + 81)) {
			jeu Jeu = new jeu();
			Jeu.setVisible(true);
		}

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (checkbox.isSelected())
			aide = true;
		else
			aide = false;

	}

}
