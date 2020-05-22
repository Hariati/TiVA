
public class Garde {
	String clock;
	String comparateur;
	String val;
	
	
	
	public Garde(String clock, String comparateur, String val) {
		super();
		this.clock = clock;
		this.comparateur = comparateur;
		this.val = val;
	}



	@Override
	public String toString() {
		return "Garde [clock=" + clock + ", comparateur=" + comparateur
				+ ", val=" + val + "]";
	}
	
	public String getGarde() {
		return clock + " " + comparateur+ " " + val ;
	}
	
}
