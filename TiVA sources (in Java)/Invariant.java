
public class Invariant {
	String clock;
	String comparateur;
	String val;
	
	
	public Invariant(String clock, String comparateur, String val) {
		super();
		this.clock = clock;
		this.comparateur = comparateur;
		this.val = val;
	}


	@Override
	public String toString() {
		return "Invariant [clock=" + clock + ", comparateur=" + comparateur
				+ ", val=" + val + "]";
	}
	
	public String getInvar() {
		return clock+comparateur+val;
	}
	
}
