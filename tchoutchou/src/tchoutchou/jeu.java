package tchoutchou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

import javax.swing.JOptionPane;

public class jeu extends JDialog {

	private MonPanelJeu contentPanel;

	private TchouTchou jeu;

	private Train t_fantome = new Train(new Point());

	private Point temp = new Point(-1, -1);

	private Point p_case;

	private Timer monTimer;

	private TimerTask task;

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

	public void dessiner(Graphics g) {
		afficherFond((Graphics2D) g);
		tracerFleche((Graphics2D) g);
		jeu.afficher((Graphics2D) g);

	}

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

	public void cliquerFeu() {
		// Pré-réglage
		jeu.getTrain().setEnDeplacement(true);
		p_case = new Point(0, 0);
		jeu.getTrain().setSens(jeu.getPlateau().getCase(p_case).sens(jeu.getTrain()));
		jeu.getFeu().MiseAuVert();
		// Lancement du timer
		task = new TimerTask() {
			public void run() {
				update();
			}
		};
		monTimer.schedule(task, new Date(), 50);
	}

	private void formMouseClicked(MouseEvent evt) {

		if (!jeu.getTrain().getEnDeplacement()) {
			Point p = new Point(evt.getPoint().x, evt.getPoint().y);
			if (jeu.dansQuelleCase(p).getX() != -1) {
				if (temp.getX() == -1) {
					temp = jeu.dansQuelleCase(p);
					jeu.getPlateau().getCase(temp).setCase_Selectionnee(true);
				} else {
					Point p_aEchanger = jeu.dansQuelleCase(p);
					Boolean echange_ok = jeu.getPlateau().echangerCase(jeu.getPlateau().getCase(temp),
							jeu.getPlateau().getCase(p_aEchanger));
					if (echange_ok) {
						jeu.getPlateau().getCase(p_aEchanger).setCase_Selectionnee(false);
					} else {
						jeu.getPlateau().getCase(temp).setCase_Selectionnee(false);
					}
					temp = new Point(-1, -1);
				}
				repaint();
			} else {
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
					} else {
						if ((p.getX() <= 350 && p.getX() >= 250) && (p.getY() >= 35 && p.getY() <= 135)) {
							this.setVisible(false);
						} else {
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

	public void update() {

		JFrame frame = new JFrame("Pop up");
		String mess;

		t_fantome.setPoint(jeu.getTrain().getPoint());
		t_fantome.deplacer(jeu.getPlateau().getCase(p_case), jeu.getTrain().getSens());

		if (jeu.getTrain().getSens() == 0) {
			monTimer.cancel();
			initJeu(false);
			if ((jeu.getFaute() % 3 == 0) && (jeu.getFaute() <= 3 * jeu.getPlateau().getTaille()) && mainwindow.aide) {
				jeu.aide(jeu.getFaute() / 3);
				mess = "Une aide vous a été fournie";
			} else
				mess = "Perdu";
			JOptionPane.showMessageDialog(frame, mess);
		} else {
			if (jeu.estalaSortie(t_fantome)) {
				monTimer.cancel();
				JOptionPane.showMessageDialog(frame, "Gagné");
				initJeu(true);
			} else {
				jeu.deplacerTrain(jeu.getPlateau().getCase(p_case));

				t_fantome.deplacer(jeu.getPlateau().getCase(p_case), jeu.getTrain().getSens());

				if (!jeu.getTrain().estDansCase(jeu.getPlateau().getCase(p_case))) {
					// Future case
					p_case = jeu.dansQuelleCase(t_fantome.getPoint());
					if (p_case.getX() == -1 || p_case.getY() == -1) {
						monTimer.cancel();
						initJeu(false);
						if ((jeu.getFaute() % 3 == 0) && (jeu.getFaute() <= 3 * jeu.getPlateau().getTaille())
								&& mainwindow.aide) {
							jeu.aide(jeu.getFaute() / 3);
							mess = "Une aide vous a été fournie";
						} else
							mess = "Perdu";
						JOptionPane.showMessageDialog(frame, mess);
					} else
						// Future sens
						jeu.getTrain().setSens(jeu.getPlateau().getCase(p_case).sens(jeu.getTrain()));
				}
			}
		}
		repaint();
	}

	public void initJeu(Boolean win) {
		if (win) {
			if (mainwindow.NbPartie <= 4)
				mainwindow.NbPartie++;
			jeu.setFaute(0);
			// jeu.getPlateau().melangePlateau();
		} else
			jeu.incrFaute();

		jeu.getTrain().reinitTrain();
		jeu.getTrain().setPoint(new Point((int) jeu.getPlateau().getCase(new Point(0, 0)).getPoint().getX(),
				(int) jeu.getPlateau().getCase(new Point(0, 0)).getPoint().getY() + 100));
		jeu.getFeu().MiseAuRouge();
	}

}
