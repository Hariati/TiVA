
public class Transition_aspect extends Transition {
	String comm="";
	public Transition_aspect(String[] lines) {
		super(lines);
		
		
		if(lines.length>3)comm=lines[3].equals("stop")?"!":"?";
		
		
	}
	
	
	@Override
	public String toString() {
		return "Transition_aspect [pos=" + comm + ", E_debut=" + E_debut + ", E_final=" + E_final + ", alpha=" + alpha+", action=" + action
				+ ", g_val_min=" + g_val_min + ", g_val_max=" + g_val_max + "]";
	}
	
	

}
