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

public class mainwindow extends JFrame {

	private ImageIcon monImageFond = new ImageIcon("ImageTchouTchou/Gare.jpg");
	private MonPanel contentPane;
	static int niveau = 2;

	/**
	 * Launch the application.
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

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 800) / 2, (screenSize.height - 600) / 2, 800, 600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Ici on place le bouton central Play
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("MV Boli", Font.BOLD, 26));
		btnPlay.setBounds(260, 220, 291, 81);

		// Ici on place le check box
		JCheckBox checkBox = new JCheckBox("Check");
		checkBox.setBounds(100, 90, 16, 16);

		contentPane = new MonPanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		// Ajout des boutons
		contentPane.add(btnPlay);
		contentPane.add(checkBox);

		// On regarde le click
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				formMouseClicked(e);
			}
		});

	}

	public void dessiner(Graphics g) {
		g.drawImage(monImageFond.getImage(), 0, 0, 800, 600, null);
		selectniv((Graphics2D) g);
	}

	public void selectniv(Graphics2D g) {
		// Cas 2x2 et 3x3
		Color c2x2 = new Color(0, 0, 0);
		Color c3x3 = new Color(0, 0, 0);

		if (niveau == 2) {
			c2x2 = new Color(225, 106, 12);
		} else {
			c3x3 = new Color(225, 106, 12);
		}

		// Cas 2x2
		g.setColor(c2x2);
		g.setStroke(new BasicStroke(10));
		g.drawRect(200, 375, 150, 150);

		g.setColor(new Color(21, 68, 155));
		g.fillRect(200, 375, 150, 150);

		g.setColor(new Color(0, 0, 0));
		g.setStroke(new BasicStroke(3));
		g.drawLine(275, 375, 275, 525);
		g.drawLine(200, 450, 350, 450);

		// Cas 3x3
		g.setColor(c3x3);
		g.setStroke(new BasicStroke(10));
		g.drawRect(450, 375, 150, 150);

		g.setColor(new Color(21, 68, 155));
		g.fillRect(450, 375, 150, 150);

		g.setColor(new Color(0, 0, 0));
		g.setStroke(new BasicStroke(3));
		g.drawLine(500, 375, 500, 525);
		g.drawLine(550, 375, 550, 525);
		g.drawLine(450, 425, 600, 425);
		g.drawLine(450, 475, 600, 475);

	}

	private void formMouseClicked(MouseEvent evt) {
		// On récupere les coordonnées du pointeur de la souris dans la fenêtre
		int sourisX = evt.getPoint().x;
		int sourisY = evt.getPoint().y;
		// On fait le changement de repère pour se ramener au ContentPane

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

		repaint();
	}

}
