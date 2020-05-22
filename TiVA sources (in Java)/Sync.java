
public class Sync {
	Canal canal;
	String type;
	int iter;
	
	public Sync(Canal canal, String type) {
		super();
		this.canal = canal;
		this.type = type;
		this.iter=-1;
	}
	
	public Sync(Canal canal, String type, int iter) {
		super();
		this.canal = canal;
		this.type = type;
		this.iter = iter;
		
	}
		
	@Override
	public String toString() {
		return "Assign [canal=" + canal + ", type=" + type + "]";
	}
	
	public String getSync() {
		if (canal.nbr>1) if(iter==-1)return canal.nom+"[id]"+type;else return canal.nom+"["+iter+"]"+type;
		else return canal.nom+type;
	}
	
	
}
