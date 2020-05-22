
public class Transition {
String E_debut;
String E_final;
String alpha;
String action;
String g_val_min;
String g_val_max;


Transition(){
	g_val_min="0";
	g_val_max="0";
}

public Transition(String[] lines) {
	this();
	//System.out.println(lines[0]+" "+lines[1]);
	E_debut=lines[0];
	alpha=lines[1];
	E_final=lines[2];
	
	String [] st=alpha.split("[\\[\\]-]");
	action=st[0];
	if(st.length>1){g_val_min=st[1];g_val_max=st[2];}
}

@Override
public String toString() {
	return "Transition [E_debut=" + E_debut + ", E_final=" + E_final
			+ ", alpha=" + alpha + ",action=" + action + ", g_val_min=" + g_val_min
			+ ", g_val_max=" + g_val_max + "]";
}


}
