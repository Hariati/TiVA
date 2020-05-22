import java.util.ArrayList;
import java.util.List;


public class Etat {
String etat;
List <Invariant> invar=new ArrayList<Invariant>();


public Etat(String etat) {
	super();
	this.etat = etat;
}

public void ajouter_invar(Invariant  invar){
	this.invar.add(invar);
}

@Override
public String toString() {
	return "Etat [etat=" + etat + ", invar=" + invar + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((etat == null) ? 0 : etat.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Etat other = (Etat) obj;
	if (etat == null) {
		if (other.etat != null)
			return false;
	} else if (!etat.equals(other.etat))
		return false;
	return true;
}

public String getInvar() {
	String result="";
	if(!invar.isEmpty()){
		result= "{"+invar.get(0).getInvar();
		  for (int i=1; i< invar.size();i++)result+=", "+invar.get(i).getInvar();
		  result+="}";
	}
	return result;
}
}
