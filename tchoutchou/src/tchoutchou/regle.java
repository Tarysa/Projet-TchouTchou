package tchoutchou;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class regle extends JDialog {

	private MonPanelRegle contentPanel;
	private int numPage = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regle dialog = new regle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regle() {

		setTitle("Règles");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 794) / 2, (screenSize.height - 550) / 2, 794, 550);

		contentPanel = new MonPanelRegle(this);
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

	private void formMouseClicked(MouseEvent evt) {
		// On récupere les coordonnées du pointeur de la souris dans la fenêtre
		int sourisX = evt.getPoint().x;
		int sourisY = evt.getPoint().y;
		// On fait le changement de repère pour se ramener au ContentPane

		if ((sourisX >= 120 && sourisX <= 160) && (sourisY >= 450 && sourisY <= 490)) {
			decrPage();
		}
		if ((sourisX >= 655 && sourisX <= 695) && (sourisY >= 450 && sourisY <= 490)) {
			incrPage();
		}

		repaint();

	}

	private void incrPage() {
		if (numPage <= 7) {
			numPage++;
		}
	}

	private void decrPage() {
		if (numPage >= 2) {
			numPage--;
		}
	}

	public void dessiner(Graphics g) {
		// afficher(g);
		switch (numPage) {
		case 1:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page1.png").getImage(), 0, 0, 800, 544, null);
			break;
		case 2:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page2.png").getImage(), 0, 0, 800, 544, null);
			break;
		case 3:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page3.png").getImage(), 0, 0, 800, 544, null);
			break;
		case 4:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page4.png").getImage(), 0, 0, 800, 544, null);
			break;
		case 5:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page5.png").getImage(), 0, 0, 800, 544, null);
			break;
		case 6:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page6.png").getImage(), 0, 0, 800, 544, null);
			break;
		case 7:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page7.png").getImage(), 0, 0, 800, 544, null);
			break;
		case 8:
			g.drawImage(new ImageIcon("ImageTchouTchou/Page8.png").getImage(), 0, 0, 800, 544, null);
			break;
		}
	}
}