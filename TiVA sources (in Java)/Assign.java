
public class Assign {
	String clock;
	String comparateur;
	String val;
	
	public Assign(String clock, String comparateur, String val) {
		super();
		this.clock = clock;
		this.comparateur = comparateur;
		this.val = val;
	}

	@Override
	public String toString() {
		return "Assign [clock=" + clock + ", comparateur=" + comparateur
				+ ", val=" + val + "]";
	}
	
	public String getAssign() {
		return clock + " " + comparateur+ " " + val;
	}
}
