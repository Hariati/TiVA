import java.util.ArrayList;
import java.util.List;


public class Trans_xta {

	String E_debut;
	String E_final;
	String alpha;
	String action;
	List<Garde> garde =new ArrayList<Garde>();
	List<Assign> assign =new ArrayList<Assign>();
	List<Sync> sync =new ArrayList<Sync>();
	
	public Trans_xta(String e_debut, String e_final, String alpha,String action) {
		super();
		this.E_debut = e_debut;
		this.E_final = e_final;
		this.alpha=alpha;
		this.action = action;
	}
	
	public void ajouter_garde(Garde  guarde){
		this.garde.add(guarde);
	}
	
	public void ajouter_assign(Assign  assign){
		this.assign.add(assign);
	}

	public void ajouter_sync(Sync  sync){
		this.sync.add(sync);
	}
	
	@Override
	public String toString() {
		return "Trans_xta [E_debut=" + E_debut + ", E_final=" + E_final
				+ ", alpha=" + alpha + ",action=" + action + ", garde=" + garde + ", assination="
				+ assign + "]";
	}

	public String getSync(){
		String result="";
		if(!sync.isEmpty()){
			result= "sync "+sync.get(0).getSync();
			  for (int i=1; i< sync.size();i++)result+=", "+sync.get(i).getSync();
			  result+=";";
		}
		return result;
}
	
	
	
	public String getAssign(){
		String result="";
		if(!assign.isEmpty()){
			result= "assign "+assign.get(0).getAssign();
			  for (int i=1; i< assign.size();i++)result+=", "+assign.get(i).getAssign();
			  result+=";";
		}
		return result;
}
	
	public String getGarde(){
		String result="";
		if(!garde.isEmpty()){
			result= "guard "+garde.get(0).getGarde();
			  for (int i=1; i< garde.size();i++)result+=", "+garde.get(i).getGarde();
			  result+=";";
		}
		return result;
}
}
