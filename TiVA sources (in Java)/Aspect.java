import java.util.ArrayList;
import java.util.List;

public class Aspect {
		boolean serie=false;
		String id="";
		String nom_aspect;
		String etat_initial;
		List<String> etats_finaux = new ArrayList<String>();
		List<Transition_aspect> transitions  = new ArrayList<Transition_aspect>();
		
		public void Etat_initial(String[] chaines){
			//System.out.println("traitement etat initial");
			//for(String c:chaines)System.out.println(c);
			etat_initial=chaines[1];
		}
		
		public void Etats_finaux(String[] chaines){
			//System.out.println("traitement etats finaux");
			//for(String c:chaines)System.out.println(c);
			for(int i=1;i<chaines.length;i++)etats_finaux.add(chaines[i]);
		}
		
		public void Nom_Systeme(String[] chaines){
			//System.out.println("traitement nom systeme");
			//for(String c:chaines)System.out.println(c);
			nom_aspect=chaines[1];
		}
		
		public void Transitions(String chaine){
			//System.out.println("traitement transitions");
			String[] lines =chaine.split(":");
			//for(String c:lines)System.out.println(c);
			Transition_aspect transition=new Transition_aspect(lines);
			transitions.add(transition);
		}

		@Override
		public String toString() {
			return "Aspect [nom_aspect=" + nom_aspect + ", etat_initial="
					+ etat_initial + ", etats_finaux=" + etats_finaux
					+ ", transitions=" + transitions + "]";
		}

//		@Override
//		public String toString() {
//			System.out.println(" nom systeme : "+nom_system+"\n Etat initiale : "+etat_initial+"\n Etat final : "+ etats_finaux.toString()+"\n Transition : "+transitions.toString());
//			return super.toString();
//		}

		
	}

