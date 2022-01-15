package tchoutchou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Class <code>jeu</code>La classe jeu permet d'afficher notre jeu
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
public class jeu extends JDialog {

	/**
	 * Panel correspondant au jeu
	 */
	private MonPanelJeu contentPanel;

	/**
	 * contient toutes les informations du jeu
	 */
	private TchouTchou jeu;

	/**
	 * train qui possède une itération d'avance sur le train réel
	 */
	private Train t_fantome = new Train(new Point());

	/**
	 * coordonnée du plateau où se trouve la case selectionnée, (-1,-1) si aucune case n'est selectionnée
	 */
	private Point temp = new Point(-1, -1);

	/**
	 * case intiale où se trouve notre train
	 */
	private Point p_case;

	/**
	 * timer permettant de faire avancer notre train à intervalle de temps régulier
	 */
	private Timer monTimer;

	/**
	 * 
	 */
	private TimerTask task;

	/**
	 * son qui va s'activer lors du déplacement du train
	 */
	private Clip clip = null;
	
	/**
	 * 
	 * @param args : argument
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
	 * Constructeur de la classe jeu
	 */
	public jeu() {
		setTitle("Partie de TchouTchou");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 900) / 2, (screenSize.height - 800) / 2, 900, 800);

		contentPanel = new MonPanelJeu(this);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.setContentPane(contentPanel);
		contentPanel.setLayout(null);

		// On regarde le click
		contentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				formMouseClicked(e);
			}
		});

		jeu = new TchouTchou(mainwindow.niveau);
		monTimer = new Timer();

	}

	/**
	 * Méthode permettant d'afficher les divers éléments présents dans le jeu
	 * @param g : fenêtre graphique
	 */
	public void dessiner(Graphics g) {
		afficherFond((Graphics2D) g);
		tracerFleche((Graphics2D) g);
		jeu.afficher((Graphics2D) g);

	}

	/**
	 * Méthode permettant d'afficher le fond du plateau
	 * @param g : fenêtre graphique
	 */
	public void afficherFond(Graphics2D g) {
		switch (Recompense.numTrain) {
		case 1:
			g.drawImage(new ImageIcon("ImageTchouTchou/FondTrainVert.png").getImage(), 0, 0, 900, 800, null);
			break;
		case 2:
			g.drawImage(new ImageIcon("ImageTchouTchou/FondNeige.jpg").getImage(), 0, 0, 900, 800, null);
			break;
		case 3:
			g.drawImage(new ImageIcon("ImageTchouTchou/FondAutomne.jpg").getImage(), 0, 0, 900, 800, null);
			break;
		case 4:
			g.drawImage(new ImageIcon("ImageTchouTchou/FondMarron.jpg").getImage(), 0, 0, 900, 800, null);
			break;
		case 5:
			g.drawImage(new ImageIcon("ImageTchouTchou/FondKids.jpg").getImage(), 0, 0, 900, 800, null);
			break;
		}
		g.drawImage(new ImageIcon("ImageTchouTchou/Recompense.png").getImage(),
				(int) jeu.getPlateau().getCase(new Point(jeu.getTaille() - 1, 0)).getPoint().getX() - 100,
				(int) jeu.getPlateau().getCase(new Point(jeu.getTaille() - 1, 0)).getPoint().getY() + 50, 75, 86, null);

		g.drawImage(new ImageIcon("ImageTchouTchou/MaisonMenu.png").getImage(), 250, 35, 100, 100, null);
		g.drawImage(new ImageIcon("ImageTchouTchou/logoRejouer.png").getImage(), 550, 35, 100, 100, null);
	}

	/**
	 * Méthode permettant d'afficher les flèches présentent à l'entrée et sortie du plateau
	 * @param g : fenêtre graphique
	 */
	public void tracerFleche(Graphics2D g) {
		// Flèches du début
		int x_entree = (int) jeu.getPlateau().getCase(new Point(0, 0)).getPoint().getX() - 100;
		int y_entree = (int) jeu.getPlateau().getCase(new Point(0, 0)).getPoint().getY() + 90;

		g.setColor(new Color(139, 0, 0));
		g.fillRect(x_entree, y_entree, 30, 20);

		int xValues3e[] = { x_entree + 30, x_entree + 30, x_entree + 55 };
		int yValues3e[] = { y_entree - 15, y_entree + 35, y_entree + 10 };
		g.fillPolygon(xValues3e, yValues3e, 3);

		// Flèches de la fin
		int x_sortie = (int) jeu.getPlateau().getCase(new Point(jeu.getTaille() - 1, jeu.getTaille() - 1)).getPoint()
				.getX() + 245;
		int y_sortie = (int) jeu.getPlateau().getCase(new Point(jeu.getTaille() - 1, jeu.getTaille() - 1)).getPoint()
				.getY() + 90;

		g.fillRect(x_sortie, y_sortie, 30, 20);

		int xValues3s[] = { x_sortie + 30, x_sortie + 30, x_sortie + 55 };
		int yValues3s[] = { y_sortie - 15, y_sortie + 35, y_sortie + 10 };
		g.fillPolygon(xValues3s, yValues3s, 3);
	}

	/**
	 * Méthode permettant d'activer toutes les tâches lors de l'activation du feu
	 */
	public void cliquerFeu() {
		
		File f = new File("./" + "son/jingle.wav");
	    AudioInputStream audioIn = null;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
		} catch (UnsupportedAudioFileException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			clip.open(audioIn);
		} catch (LineUnavailableException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    clip.start();
	    
	    // On fait une pause pour le jingle
	    try {
	    	  Thread.sleep(2000);//time is in ms (1000 ms = 1 second)
	    	} catch (InterruptedException e) {e.printStackTrace();}
	    clip.stop();
	    
		// Pré-réglage
		jeu.getTrain().setEnDeplacement(true);
		p_case = new Point(0, 0);
		jeu.getTrain().setSens(jeu.getPlateau().getCase(p_case).sens(jeu.getTrain()));
		jeu.getFeu().MiseAuVert();
		
		//Ajout du son
		f = new File("./" + "son/son.wav");
		audioIn = null;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
		} catch (UnsupportedAudioFileException | IOException e2) {
			e2.printStackTrace();
		}  
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	    try {
			clip.open(audioIn);
		} catch (LineUnavailableException | IOException e1) {
			e1.printStackTrace();
		}
	    clip.start();
			    
		// Lancement du timer
		task = new TimerTask() {
			public void run() {
				update();
			}
		};
		monTimer.schedule(task, new Date(), 10);
		
	}

	/**
	 * Méthode permettant d'activer toutes les tâches lors d'un clic de souris
	 * @param evt : évenement lié à un clic 
	 */
	private void formMouseClicked(MouseEvent evt) {

		if (!jeu.getTrain().getEnDeplacement()) {
			Point p = new Point(evt.getPoint().x, evt.getPoint().y);
			// On regarde dans quelle case est le clic
			if (jeu.dansQuelleCase(p).getX() != -1) {
				if (temp.getX() == -1) {
					temp = jeu.dansQuelleCase(p);
					jeu.getPlateau().getCase(temp).setCase_Selectionnee(true);
				} 
				else {
					Point p_aEchanger = jeu.dansQuelleCase(p);
					Boolean echange_ok = jeu.getPlateau().echangerCase(jeu.getPlateau().getCase(temp),
							jeu.getPlateau().getCase(p_aEchanger));
					if (echange_ok) {
						jeu.getPlateau().getCase(p_aEchanger).setCase_Selectionnee(false);
					} 
					else {
						jeu.getPlateau().getCase(temp).setCase_Selectionnee(false);
					}
					temp = new Point(-1, -1);
				}
				repaint();
			} 
		else {
				Point a = jeu.getFeu().getPoint();
				if ((p.getX() <= a.getX() + 41 && p.getX() >= a.getX())
						&& (p.getY() >= a.getY() && p.getY() <= a.getY() + 100))
					cliquerFeu();
				else {
					Point r = new Point(
							(int) jeu.getPlateau().getCase(new Point(jeu.getTaille() - 1, 0)).getPoint().getX() - 100,
							(int) jeu.getPlateau().getCase(new Point(jeu.getTaille() - 1, 0)).getPoint().getY() + 50);
					if ((p.getX() <= r.getX() + 75 && p.getX() >= r.getX())
							&& (p.getY() >= r.getY() && p.getY() <= r.getY() + 86)) {
						FenetreRecompense Recom = new FenetreRecompense();
						Recom.setVisible(true);
					} 
					else {
						if ((p.getX() <= 350 && p.getX() >= 250) && (p.getY() >= 35 && p.getY() <= 135)) {
							setVisible(false);
						} 
						else {
							if ((p.getX() <= 650 && p.getX() >= 550) && (p.getY() >= 35 && p.getY() <= 135)) {
								jeu.initPlateau();
								repaint();
							}
						}
					}
				}
			}
		}
		repaint();
	}

	/**
	 * Méthode permettant de déplacer le train en fonction du plateau
	 */
	public void update() {

		JFrame frame = new JFrame("Pop up");
		String mess;
		
		t_fantome.setPoint(jeu.getTrain().getPoint());
		t_fantome.deplacer(jeu.getPlateau().getCase(p_case), jeu.getTrain().getSens());

		if (jeu.getTrain().getSens() == 0) {
			// Le train sort du plateau
			monTimer.cancel();
			clip.stop();
			monTimer = new Timer();
			initJeu(false);
			if ((jeu.getFaute() % 3 == 0) && (jeu.getFaute() <= 3 * jeu.getPlateau().getTaille()) && mainwindow.aide) {
				jeu.aide(jeu.getFaute() / 3);
				mess = "Une aide vous a été fournie";
			} else
				mess = "Perdu : sens";
			JOptionPane.showMessageDialog(frame, mess);
		} else {
			if (jeu.estalaSortie(t_fantome)) {
				monTimer.cancel();
				clip.stop();
				monTimer = new Timer();
				JOptionPane.showMessageDialog(frame, "Gagné");
				initJeu(true);
			} else {
				if (jeu.getTrain().getPoint().equals(new Point((int)jeu.getPlateau().getCase(p_case).getPoint().getX()+ 100 ,(int)jeu.getPlateau().getCase(p_case).getPoint().getY() + 100 )) && (jeu.getPlateau().getCase(p_case) instanceof Croisement)) {
					
					JOptionPane d = new JOptionPane();
					ImageIcon lesTextes[] = { new ImageIcon("ImageTchouTchou/FlecheDroite.png"), new ImageIcon("ImageTchouTchou/FlecheDroite.png"), new ImageIcon("ImageTchouTchou/FlecheDroite.png"), new ImageIcon("ImageTchouTchou/FlecheDroite.png")};
					int choix = d.showOptionDialog(this, "Veuillez choisir votre trajectoire !!", "Choix de la trajectoire",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, lesTextes,lesTextes[0]);

			        if (choix == 0) {
			            jeu.getTrain().setSens(2);
			            Croisement.direction = 1;
			        }
			        else if (choix == 1) {
			        	jeu.getTrain().setSens(1);
			        	Croisement.direction = 2;
			        }
			        else if (choix == 2) {
			        	jeu.getTrain().setSens(2);
			        	Croisement.direction = 2;
			        }
			        else {
			        	jeu.getTrain().setSens(1);
			        	Croisement.direction = 1;
			        }
				}
				jeu.deplacerTrain(jeu.getPlateau().getCase(p_case));
				t_fantome.deplacer(jeu.getPlateau().getCase(p_case), jeu.getTrain().getSens());

				if (!jeu.getTrain().estDansCase(jeu.getPlateau().getCase(p_case))) {
					// Future case
					p_case = jeu.dansQuelleCase(t_fantome.getPoint());
					if (p_case.getX() == -1 || p_case.getY() == -1) {
						monTimer.cancel();
						clip.stop();
						monTimer = new Timer();
						initJeu(false);
						if ((jeu.getFaute() % 3 == 0) && (jeu.getFaute() <= 3 * jeu.getPlateau().getTaille())
								&& mainwindow.aide) {
							jeu.aide(jeu.getFaute() / 3);
							mess = "Une aide vous a été fournie";
						} else
							mess = "Perdu : chemin incompatible";
						JOptionPane.showMessageDialog(frame, mess);
					} else
						// Future sens
						jeu.getTrain().setSens(jeu.getPlateau().getCase(p_case).sens(jeu.getTrain()));
				}
			}
		}
		repaint();
	}

	/**
	 * Méthode permettant de réinitialiser le jeu
	 * @param win : booléen permettant de savoir si le joueur a gagné ou s'il s'agit d'une autre tentative
	 */
	public void initJeu(Boolean win) {
		if (win) {
			if (mainwindow.NbPartie <= 4)
				mainwindow.NbPartie++;
			jeu.setFaute(0);
			jeu.initPlateau();
		} else
			jeu.incrFaute();

		jeu.getTrain().reinitTrain();
		jeu.getTrain().setPoint(new Point((int) jeu.getPlateau().getCase(new Point(0, 0)).getPoint().getX(),
				(int) jeu.getPlateau().getCase(new Point(0, 0)).getPoint().getY() + 100));
		jeu.getFeu().MiseAuRouge();
	}

}
