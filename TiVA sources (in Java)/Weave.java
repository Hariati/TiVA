
public class Weave {
	String sb;
	String alpha;
	String aspect;
	String place;
	
	
	public Weave(String sb, String alpha, String aspect, String place) {
		super();
		this.sb = sb;
		this.alpha = alpha;
		this.aspect = aspect;
		this.place = place;
	}


	public Weave(String[] lines) {
		
		this(lines[0],lines[1],lines[2],lines[3]);


	}


	@Override
	public String toString() {
		return "weaven [sb=" + sb + ", alpha=" + alpha + ", aspect=" + aspect + ", place=" + place + "]";
	}


}
