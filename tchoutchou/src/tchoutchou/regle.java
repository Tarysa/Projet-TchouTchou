package tchoutchou;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;

/**
 * Class <code>regle</code>La classe regle permettant d'afficher les r�gles au
 * joueur
 * 
 * @author Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 06/01/2022
 */
public class regle extends JDialog {

	/**
	 * Panel li� aux r�gles
	 */
	private MonPanelRegle contentPanel;

	/**
	 * Attribut li� � la page des r�gles affich�es
	 */
	private int numPage = 1;

	/**
	 * 
	 * @param args : argument
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

		setTitle("R�gles");

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

	/**
	 * Gestionnaire d'�venement lors du clic
	 * 
	 * @param evt : evenement
	 */
	private void formMouseClicked(MouseEvent evt) {
		// On r�cupere les coordonn�es du pointeur de la souris dans la fen�tre
		int sourisX = evt.getPoint().x;
		int sourisY = evt.getPoint().y;
		// On fait le changement de rep�re pour se ramener au ContentPane

		if ((sourisX >= 120 && sourisX <= 160) && (sourisY >= 450 && sourisY <= 490)) {
			decrPage();
		}
		if ((sourisX >= 655 && sourisX <= 695) && (sourisY >= 450 && sourisY <= 490)) {
			incrPage();
		}

		repaint();

	}

	/**
	 * Incr�mentation du num�ro de page courante
	 */
	private void incrPage() {
		if (numPage <= 7) {
			numPage++;
		}
	}

	/**
	 * D�crementation du num�ro de page courante
	 */
	private void decrPage() {
		if (numPage >= 2) {
			numPage--;
		}
	}

	/**
	 * Affichage des r�gles
	 * 
	 * @param g : fen�tre graphique
	 */
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
			g.drawImage(new ImageIcon("ImageTchouTchou/Page5bis.png").getImage(), 0, 0, 800, 544, null);
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