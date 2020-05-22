import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Xta {

	String process;
	String s_init;
	List <String> urgent;
	List <Etat> state;
	List <Trans_xta> trans;
	List <String> clock_local;
	List <String> action;
	String parametre;
	
	
	public Xta(){
		parametre="";
		trans=new ArrayList<Trans_xta>();
		clock_local=new ArrayList<String>();
		urgent=new ArrayList<String>();
		state=new ArrayList<Etat>();
		action=new ArrayList<String>();
	}

	@Override
	public String toString() {
		return "Xta [process=" + process
				+ ", s_init=" + s_init + ", urgent=" + urgent + ", state="
				+ state + ", trans=" + trans + ", clock_local=" + clock_local
				+ "]";
	}
	
	public void add_state (Etat etat){
		boolean trouve=false;
		for( Object e: state){
			Etat et=(Etat)e;
			if(et.equals(etat)){trouve=true;break;}
		}
		if(!trouve)state.add(etat);
	}
	
	public void add_urgent (String etat){
		boolean trouve=false;
		for( Object e: urgent){
			String et=(String)e;
			if(et.equals(etat)){trouve=true;break;}
		}
		if(!trouve)urgent.add(etat);
	}
	
	public void add_action (String a){
		boolean trouve=false;
		for( Object e: action){
			String act=(String)e;
			if(act.equals(a)){trouve=true;break;}
		}
		if(!trouve)action.add(a);
	}

	public void delete_urgent(String etat) {
		urgent.remove(etat);
		
	}
}
