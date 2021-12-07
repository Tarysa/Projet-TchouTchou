package tchoutchou;
import java.awt.Point;

/**
 * Class <code>Case</code>La classe abstraite Case permet de manipuler des cases
 * @author  Limousin Lucas, Lafon Gabin, Sendra Thomas
 * @version 1.0 29/11/2021
 */
public abstract class Case extends ObjetGraphiqueMobile{

	/**
	 * case_selectionnee : bool�en qui permet de d�finir si la case est selectionn�e ou non, true si elle est selectionn�e, false si elle ne l'est pas
	 */
	private boolean case_selectionnee = false ;
	
	/**
     * case_bloquee : bool�en qui permet de d�finir si la case est bloquee ou non, true si elle est bloquee, false si elle ne l'est pas
    */
    private boolean case_bloquee = false;
    
    /**
     * Constructeur de la classe case
     * @param p : Point qui correspond � l'endroit o� se trouvera cette case
     */
    public Case(Point p) {
    	super(p);
    }
    
    /**
     * Surcharge du constructeur de la classe case
     * @param p : Point qui correspond � l'endroit o� se trouvera cette case
     * @param type : entier correspondant au type de la case (1-7 sera des rails)
     */
    public Case(Point p, int type) {
    	super(p,type);
    }
    
    /**
	 * M�thode afficher permettant d'afficher le feu sur le jeu
	 */
    public void afficher() {
    	
    }
    
    /**
     * Mutateur de case_selectionnee
     * @param select : bool�an qui permet de d�finir si la case est selectionn�e ou non, true si elle est selectionn�e, false si elle ne l'est pas
     */
    public void setCase_Selectionnee(boolean select) {
    	case_selectionnee = select;
    }
    
    /**
     * Accesseur de case_selectionnee
     * @return renvoie la valeur de l'attribut case_selectionnee
     */
    public boolean getCase_Selectionnee() {
    	return case_selectionnee;
    }
    
    /**
     * Mutateur de cas_bloquee
     * @param bloque: bool�an qui permet de d�finir si la case est bloquee ou non, true si elle est bloquee, false si elle ne l'est pas
     */
    public void setCase_bloquee(boolean bloque) {
    	case_bloquee = bloque;
    }
    
    /**
     * Accesseur de case_bloquee
     * @return renvoie la valeur de l'attribut case_bloquee
     */
    public boolean getCase_bloquee() {
    	return case_bloquee;
    }
    
    /**
     * Red�finition dans toutes les rails
     */
    
    abstract Point trajectoire(Point p, boolean sens);
    
    abstract int sens(ObjetGraphiqueMobile t);
    
    abstract Point centre_rotation();
    
}
