package tchoutchou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenetreRecompense extends JDialog {

	private MonPanelRecompense contentPanel;

	private Recompense Collection = new Recompense();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FenetreRecompense dialog = new FenetreRecompense();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FenetreRecompense() {
		setTitle("Menu des R�compense");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 525) / 2, (screenSize.height - 600) / 2, 525, 600);

		contentPanel = new MonPanelRecompense(this);
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

	}

	public void dessiner(Graphics g) {
		g.drawImage(new ImageIcon("ImageTchouTchou/FondTrophe.jpg").getImage(), 0, 0, 525, 600, null);
		Collection.afficher((Graphics2D) g, mainwindow.NbPartie);

		g.setColor(new Color(0, 0, 0));
		g.setFont(new Font("Mv Boli", Font.PLAIN, 26));
		g.drawString("Collection Train", 165, 50);
	}

	private void formMouseClicked(MouseEvent evt) {
		// On récupere les coordonnées du pointeur de la souris dans la fenêtre

		Point p = new Point(evt.getPoint().x, evt.getPoint().y);

		// On fait le changement de repère pour se ramener au ContentPanel
		if ((p.getX() >= 100 && p.getX() <= 225) && (p.getY() >= 100 && p.getY() <= 225)) {
			Recompense.numTrain = 1;
		}
		if ((p.getX() >= 300 && p.getX() <= 425) && (p.getY() >= 100 && p.getY() <= 225)) {
			if (mainwindow.NbPartie >= 2)
				Recompense.numTrain = 2;
		}
		if ((p.getX() >= 100 && p.getX() <= 225) && (p.getY() >= 400 && p.getY() <= 525)) {
			if (mainwindow.NbPartie >= 3)
				Recompense.numTrain = 3;
		}
		if ((p.getX() >= 300 && p.getX() <= 425) && (p.getY() >= 400 && p.getY() <= 525)) {
			if (mainwindow.NbPartie >= 4)
				Recompense.numTrain = 4;
		}
		if ((p.getX() >= 200 && p.getX() <= 325) && (p.getY() >= 250 && p.getY() <= 375)) {
			if (mainwindow.NbPartie >= 5)
				Recompense.numTrain = 5;
		}

		repaint();

	}

}
