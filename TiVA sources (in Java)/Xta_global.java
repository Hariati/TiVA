import java.util.ArrayList;
import java.util.List;

public class Xta_global {
	public String clock_global;
	public Xta sb;
	public List<Xta>xta_aspect;
	public List<Canal>canaux;
	
	public Xta_global(){
		this.sb=new Xta();
		this.clock_global="g";
		this.xta_aspect=new ArrayList<Xta>();
		this.canaux=new ArrayList<Canal>();
	}

	@Override
	public String toString() {
		return "Xta_global [clock_global=" + clock_global + ", sb=" + sb + ", xta_aspect=" + xta_aspect + "]";
	}

	
}
