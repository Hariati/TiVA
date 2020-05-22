
public class Canal {
	String nom;
	int nbr;
	String id;
	String constante;
	public Canal(String nom, int nbr, String id, String constante) {
		super();
		this.nom = nom;
		this.nbr = nbr;
		this.id=id;
		this.constante=constante;
	}
	
	
	@Override
	public String toString() {
		return "Canal [nom=" + nom + ", nbr=" + nbr + "]";
	}
	
	

}
