import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main {
	private boolean instance=true;
	private int id_num=0;
	private int constante_num=0;
	private int  etat_num=0;
	private int  clock_num=0;
	private int  instance_num=0;
	private int  chanel_num=0;
	private List <String> liste_instance=new ArrayList<String>();
	private Systeme s_global=new Systeme();
	private Code_dsl code_dsl=new Code_dsl();;
	private Xta_global xta_global=new Xta_global();
	private String code="",resultat="";
	
	/**
	 * @param args
	 * 
	 */
	

	public void principal(File source, File dest) {
		
		
		traitement_lexical(source);
		
		
		//System.out.println(s_global);
		
		creer_xta_global ();
		
		System.out.println(xta_global);	
		
		generer_code_xta_global();
		
		System.out.println(resultat);	
		
		save_xta(dest);
		
	}

	private void creer_xta_global () {
		
		
		if(!s_global.weaves.isEmpty()) traiter_weaves();
		
		
		else traiter_system_basic();
		
		
	}

	
	private void traiter_system_basic() {
		
		creer_xta_sb();
		
		
	}

	private void traiter_weaves() {
		
		
		creer_xta_sb();
		//System.out.println("nombre de weave : "+s_global.weaves.size()+" "+s_global.weaves);
		for(Weave w:s_global.weaves) traiter_weave(w);
		
		
		}
	private void traiter_weave(Weave w) {
		
		
		
		creer_xta_aspect(w);
	}
	

	private void save_xta(File dest) {
		
		try {
			FileWriter fd = new FileWriter(dest);
			BufferedWriter bd=new BufferedWriter(fd);
		
	    bd.write(this.resultat);
	   
	    bd.close();
	    fd.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
	}

	private void traitement_lexical(File source) {
		try {
				FileReader fr=new FileReader(source);
				BufferedReader br=new BufferedReader(fr);
				String ligne= br.readLine();
				while(ligne!=null){
					if(ligne.equals(""))ligne="";
					code+=ligne;
					ligne=br.readLine();
				}
				//System.out.println("le code : "+ code);
				br.close();
				fr.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		Traiter(code);
	}

	private void generer_code_xta(Xta x) {
	  
		
		// declaration nom de process  const id_t id
		String parametre="";
		if(!x.parametre.equals(""))parametre="const "+x.parametre+ " id ";
	  echo("\nprocess "+x.process+"( "+parametre+" ) {");
	  //debut
	  //echo("");
	  
	  //declaration des horloge locales
	  if(!x.clock_local.isEmpty()){
		  echo("\nclock");
		  String horloge= x.clock_local.get(0);
		  for (int i=1; i< x.clock_local.size();i++)horloge+=",\n"+x.clock_local.get(i);
		  echo(horloge+";");
	  }
	  //declaration action
	 
	  if(!x.action.isEmpty()){
		   echo ("\nbool");
		  String actions= x.action.get(0)+"=false";
		  for (int i=1; i< x.action.size();i++)actions+=",\n"+x.action.get(i)+"=false";
		  echo(actions+";");
	  } 
	  // declaration des states
	  	  
	  if(!x.state.isEmpty()){
		  echo("\nstate");
		  String etat= x.state.get(0).etat+" "+ x.state.get(0).getInvar();
		  for (int i=1; i< x.state.size();i++)etat+=",\n"+x.state.get(i).etat+" "+x.state.get(i).getInvar();
		  echo(etat+";");
	  }
	  
	  //declaration des urgents
	  
	  if(!x.urgent.isEmpty()){
		  echo("\nurgent");
		  String etat= x.urgent.get(0);
		  for (int i=1; i< x.urgent.size();i++)etat+=",\n"+x.urgent.get(i);
		  echo(etat+";");
	  }
	  
	  //declaration de l'état initial
	  
	  echo("\ninit "+x.s_init+";");
	  
	  //declaration transition
	  
	 
	  if(!x.trans.isEmpty()){
		  echo("\ntrans");
		  String trans= x.trans.get(0).E_debut+"->"+ x.trans.get(0).E_final+" { "+x.trans.get(0).getGarde()+x.trans.get(0).getAssign()+ " }";
		  for (int i=1; i< x.trans.size();i++)trans+=",\n"+x.trans.get(i).E_debut+" ->"+ x.trans.get(i).E_final+" { "+x.trans.get(i).getGarde()+x.trans.get(i).getSync()+x.trans.get(i).getAssign()+ " }";
		  echo(trans+";");
		  }
	  echo("}\n");
	  }
	  
	  
	  private void generer_code_xta_global() {


		
		//declaration canaux
		if(!xta_global.canaux.isEmpty()){
			  
					  
			  for (int i=0; i< xta_global.canaux.size();i++) if(xta_global.canaux.get(i).nbr>1) {
				    instance=false;
					String declaration="const int "+xta_global.canaux.get(i).constante+" = "+xta_global.canaux.get(i).nbr+";\n";
					declaration+= "typedef int[0,"+xta_global.canaux.get(i).constante+"-1] "+xta_global.canaux.get(i).id+";\n";
					echo(declaration);
				   }
				}
			 
			  
			  
		  
		
		
		if(!xta_global.canaux.isEmpty()){
			  echo("chan");
			  String canal= ((xta_global.canaux.get(0).nbr>1)?(xta_global.canaux.get(0).nom+"["+xta_global.canaux.get(0).constante+"]"):xta_global.canaux.get(0).nom);
			  for (int i=1; i< xta_global.canaux.size();i++)canal+=",\n"+((xta_global.canaux.get(i).nbr>1)?(xta_global.canaux.get(i).nom+"["+xta_global.canaux.get(i).constante+"]"):xta_global.canaux.get(i).nom);
			  echo(canal+";");
		  }
		
		//declaration horloge principal
		echo("clock "+xta_global.clock_global+";");
		
		//generer xta systeme basic
		generer_code_xta(xta_global.sb);
		
		
		//generer xta de tous les aspect
		if(xta_global.xta_aspect!=null)for(Xta aspect:xta_global.xta_aspect)generer_code_xta(aspect);
		
		
//	  //instantiation system basic
//	  String instance=nouvel_instance();
//	  liste_instance.add(instance);
//	  echo(instance+"="+xta_global.sb.process+"();");
//	  
	 
//	//instantiation de tous les aspect
//	  if(xta_global.xta_aspect!=null)for(Xta aspect:xta_global.xta_aspect) {
//		  instance=nouvel_instance();
//		  liste_instance.add(instance);
//		  echo(instance+"="+aspect.process+"();");  
//	  }
//	  
//	  //generation su systeme  systeme complet
//	  String instances= liste_instance.get(0);
//	  for (int i=1; i< liste_instance.size();i++)instances+=", "+liste_instance.get(i);
//	  echo("\nsystem "+instances+";");
	  
	 String nom_systeme= xta_global.sb.process;
	 if(xta_global.xta_aspect!=null)for(Xta aspect:xta_global.xta_aspect) {
		nom_systeme+=", "+ aspect.process;
		 
	 }
	  echo("\nsystem "+nom_systeme+";");
	  
	}

	private void echo(String s){
		this.resultat+=s+"\n";
	}
	
	
	private  void creer_xta_sb() {
		Systeme_basic s=s_global.sbs;
		Xta xta=new Xta();
		//nom process
		xta.process=s.nom_system;
		
		//traitement etat initial
		xta.s_init=s.etat_initial;
		xta.add_state(new Etat(s.etat_initial));
		xta.add_urgent(s.etat_initial);
		
		//traitement etat final
		for(String etat:s.etats_finaux){
		String etat_intermediare=nouvel_etat();
		xta.add_state(new Etat(etat));xta.add_state(new Etat(etat_intermediare));
		xta.add_urgent(etat);
		
		Trans_xta transi=new Trans_xta(etat, etat_intermediare,"", "");
		xta.trans.add(transi);
		
		transi=new Trans_xta(etat_intermediare, etat_intermediare,"", "");
		xta.trans.add(transi);
		}
		
		//traitement transitions
		
		for(Transition transit:s.transitions){	
			//System.out.println("traitement transition :"+transit.E_debut+" vers "+transit.E_final+" avec action "+transit.action+" et min="+ transit.g_val_min+" et max ="+transit.g_val_max);
			if(transit.g_val_min.equals("0") && transit.g_val_max.equals("0")){
				xta.add_state(new Etat(transit.E_debut));xta.add_state(new Etat(transit.E_final));
				xta.add_urgent(transit.E_debut);xta.add_urgent(transit.E_final);
				xta.add_action(transit.action);
				Trans_xta transi=new Trans_xta(transit.E_debut, transit.E_final,transit.alpha, transit.action);
				
				transi.ajouter_assign(new Assign(transit.action, "=", "true"));
				xta.trans.add(transi);
			}
			else
			{
				String horloge=nouvel_clock();
				xta.clock_local.add(horloge);
				String etat_intermediare =nouvel_etat();
				xta.add_state(new Etat(transit.E_debut));xta.add_state(new Etat(transit.E_final));
				Etat intermediare=new Etat(etat_intermediare);
				intermediare.ajouter_invar(new Invariant(horloge, "<=", transit.g_val_max));
				xta.add_state(intermediare);
				xta.add_urgent(transit.E_debut);xta.add_urgent(transit.E_final);
				
				Trans_xta transi=new Trans_xta(transit.E_debut, etat_intermediare,"", "");
				transi.ajouter_assign(new Assign(horloge, "=", "0"));
				xta.trans.add(transi);
				xta.add_action(transit.action);
				transi=new Trans_xta(etat_intermediare, transit.E_final,transit.alpha, transit.action);
				transi.ajouter_garde(new Garde(horloge, ">=", transit.g_val_min));
				transi.ajouter_assign(new Assign(transit.action, "=", "true"));
				xta.trans.add(transi);
				
			}
		}
		
		xta_global.sb=xta;
	}
	
	
	
	
	private void creer_xta_aspect(Weave w) {
		String id="";
		String constante="";
		Aspect aspect=null;
        for(Aspect asp: s_global.asps) {if(asp.nom_aspect.contentEquals(w.aspect))aspect=asp;}
        String alpha=w.alpha;
        System.out.println(alpha);
        String [] st=alpha.split("[\\[\\]-]");
		String action=st[0];
        String place=w.place;
        //System.out.println(aspect);
        int occurence=rechercher_action(alpha);
        String canal=nouvel_channel();
        if (occurence>1) {id=nouvel_id();constante=nouvel_constante();}
        Canal chan=new Canal(canal, occurence, id,constante);
		xta_global.canaux.add(chan);
        creer_xta_aspect(aspect,chan,id);
        //suite
        mise_a_jour_sb(alpha,action,chan,place,occurence);
        
        

	}
	
	private void mise_a_jour_sb(String alpha, String action, Canal chan, String place, int occurence) {
		int ite=0;
		boolean multi=(occurence>1);
		
		List<Transition> transitions= chercher_transition_dsl(alpha);
		
		for(int i=0;i<transitions.size();i++) {
			int it=ite++;
			Transition trans=transitions.get(i);
			if(non_temporelle(trans)) {
				
				Trans_xta trans_xta=chercher_transition_xta(trans); 
				
				if(place.contentEquals("before")) {
					
					
					String etat_b=nouvel_etat();
					
					Trans_xta t1=new Trans_xta(trans_xta.E_debut, etat_b,"","");
					
					Trans_xta t2=new Trans_xta(etat_b, trans_xta.E_final, alpha,action);
					if (multi) {
						t1.ajouter_sync(new Sync(chan, "!",it));
						t2.ajouter_sync(new Sync(chan, "?",it));
						}
					else {
						t1.ajouter_sync(new Sync(chan, "!"));
						t2.ajouter_sync(new Sync(chan, "?"));
					}
					t2.ajouter_assign(new Assign(trans_xta.action, "=", "true"));
					xta_global.sb.state.add(new Etat(etat_b));
					xta_global.sb.trans.remove(trans_xta);
					xta_global.sb.trans.add(t1);
					xta_global.sb.trans.add(t2);
					
					
				}else {
					
					String etat_b=nouvel_etat();
					
					Trans_xta t1=new Trans_xta(trans_xta.E_debut, etat_b,alpha,action);
					
					t1.ajouter_assign(new Assign(trans_xta.action, "=", "true"));
					Trans_xta t2=new Trans_xta(etat_b, trans_xta.E_final, "","");
					if (!multi) {
						t1.ajouter_sync(new Sync(chan, "!"));
						t2.ajouter_sync(new Sync(chan, "?"));
					}
					else
					{
						t1.ajouter_sync(new Sync(chan, "!",it));
						t2.ajouter_sync(new Sync(chan, "?",it));
					}
					xta_global.sb.state.add(new Etat(etat_b));
					xta_global.sb.trans.remove(trans_xta);
					xta_global.sb.trans.add(t1);
					xta_global.sb.trans.add(t2);
					
				}
			}
			else 
			{
				
				Trans_xta [] trans_xta = chercher_transition_xta_temp (trans); 
				
				if(place.contentEquals("before")) {
					
					List<Assign> ass=trans_xta[0].assign;
					
					String etat_b=nouvel_etat();
					
					Trans_xta t1=new Trans_xta(trans_xta[0].E_debut, etat_b,"","");
					
					
					Trans_xta t2=new Trans_xta(etat_b, trans_xta[0].E_final, "","");
					
					for(Assign as:ass)t2.ajouter_assign(as);
					
					if(!multi) {
					t1.ajouter_sync(new Sync(chan, "!"));
					t2.ajouter_sync(new Sync(chan, "?"));
					}
					else {
						t1.ajouter_sync(new Sync(chan, "!",it));
						t2.ajouter_sync(new Sync(chan, "?", it));
					}
					
					xta_global.sb.state.add(new Etat(etat_b));
					xta_global.sb.trans.remove(trans_xta[0]);
					xta_global.sb.trans.add(t1);
					xta_global.sb.trans.add(t2);
					
					
//					for s1 cl:=0-> sA and sA [cl>=x]-> s2 
//					ETA = ETA - {s1	cl:=0 -> sA}
//						
//						Create a new state sB < LTA
//						ETA = ETA U {s1	ch!-> sB, sBch? /cl:=0	-> sA}
//					
				}else {
					
					
					List<Garde> garde=trans_xta[1].garde;
					String etat_b=nouvel_etat();
					
					Trans_xta t1=new Trans_xta(trans_xta[1].E_debut, etat_b,alpha,action);
					
					for(Garde g:garde)t1.ajouter_garde(g);
					Trans_xta t2=new Trans_xta(etat_b, trans_xta[1].E_final, "","");
					if(!multi) {
						t1.ajouter_sync(new Sync(chan, "!"));
						t2.ajouter_sync(new Sync(chan, "?"));
					
					}
					else {
						t1.ajouter_sync(new Sync(chan, "!",it));
						t2.ajouter_sync(new Sync(chan, "?",it));
					}
					
					xta_global.sb.state.add(new Etat(etat_b));
					xta_global.sb.trans.remove(trans_xta[1]);
					xta_global.sb.trans.add(t1);
					xta_global.sb.trans.add(t2);
//					for s1 cl:=0-> sA and sA [cl>=x]-> s2 
//					ETA = ETA - {sA -> s2}
//					
//					Create a new state sB < LTA
//					ETA = ETA U {sA	[cl>=x] ch!	-> sB, sB ch?-> s2}

					
				}
			}
			
		}
		 
		 
		
		
	}

	private Trans_xta[] chercher_transition_xta_temp (Transition transition) {
		Trans_xta[] txta=new Trans_xta[2];
		String etat_debut=transition.E_debut,etat_final=transition.E_final,alpha=transition.alpha,action=transition.action;
		for(Trans_xta trans1 : xta_global.sb.trans) {
			for(Trans_xta trans2 : xta_global.sb.trans)
			if(trans1.E_debut.contentEquals(etat_debut) && trans1.E_final.contentEquals(trans2.E_debut)&&trans2.E_debut.contentEquals(trans1.E_final) && trans2.E_final.contentEquals(etat_final)&&trans2.alpha.contentEquals(alpha) ) {txta[0]=trans1;txta[1]=trans2;}
		}
		return txta;
	}

	private boolean non_temporelle(Transition transition) {
		
		return (transition.g_val_min.contentEquals("0") && transition.g_val_max.contentEquals("0"));
	}

	private Trans_xta chercher_transition_xta(Transition transition) {
		Trans_xta txta=null;
		String etat_debut=transition.E_debut, etat_final=transition.E_final, action=transition.action,alpha=transition.action;
		System.out.println(etat_debut+ " " +etat_final+" "+alpha+" "+action);
		for(Trans_xta trans : xta_global.sb.trans) {
			if(trans.E_debut.contentEquals(etat_debut)&&trans.E_final.contentEquals(etat_final)&&trans.action.contentEquals(action) )txta=trans;
		}
		System.out.println(txta);
		return txta;
	}

	private List<Transition> chercher_transition_dsl(String alpha) {
		List<Transition> liste_trans=new ArrayList<Transition>();
		
		for(Transition trans : s_global.sbs.transitions) {
			if(trans.alpha.contentEquals(alpha) )liste_trans.add(trans);
		}
		//Transition[] tab=(Transition[]) liste_trans.toArray();
		return liste_trans;
	}

	private int rechercher_action(String alpha) {
		int nbr=0;
		for(Transition tr:s_global.sbs.transitions)if(tr.alpha.equals(alpha))nbr++;
		return nbr;
	}

	private void creer_xta_aspect(Aspect s, Canal canal,String id) { 
		Xta xta=new Xta();
		
		//nom process
		xta.process=s.nom_aspect;
		xta.parametre=id;
		//traitement etat initial
		xta.s_init=s.etat_initial;
		xta.add_state(new Etat(s.etat_initial));
		xta.add_urgent(s.etat_initial);
		
		//traitement etat final
		for(String etat:s.etats_finaux){
		String etat_intermediare=nouvel_etat();
		xta.add_state(new Etat(etat));xta.add_state(new Etat(etat_intermediare));
		xta.add_urgent(etat);
		
		Trans_xta transi=new Trans_xta(etat, etat_intermediare,"", "");
		xta.trans.add(transi);
		
		transi=new Trans_xta(etat_intermediare, etat_intermediare,"", "");
		xta.trans.add(transi);
		}
		
		//traitement transitions
		
		for(Transition_aspect transit:s.transitions){	
		 
		if(transit.g_val_min.equals("0") && transit.g_val_max.equals("0")){
				xta.add_state(new Etat(transit.E_debut));xta.add_state(new Etat(transit.E_final));
				xta.add_urgent(transit.E_debut);xta.add_urgent(transit.E_final);
				xta.add_action(transit.action);
				Trans_xta transi=new Trans_xta(transit.E_debut, transit.E_final,transit.alpha, transit.action);
				transi.ajouter_assign(new Assign(transit.action, "=", "true"));
				if(!transit.comm.equals("")) {transi.ajouter_sync(new Sync(canal,transit.comm));if(transit.comm.equals("?"))xta.delete_urgent(transit.E_debut);}
				xta.trans.add(transi);
				
			}
			else
			{
				String horloge=nouvel_clock();
				xta.clock_local.add(horloge);
				String etat_intermediare =nouvel_etat();
				xta.add_state(new Etat(transit.E_debut));xta.add_state(new Etat(transit.E_final));
				Etat intermediare=new Etat(etat_intermediare);
				intermediare.ajouter_invar(new Invariant(horloge, "<=", transit.g_val_max));
				xta.add_state(intermediare);
				xta.add_urgent(transit.E_debut);xta.add_urgent(transit.E_final);
				
				Trans_xta transi=new Trans_xta(transit.E_debut, etat_intermediare,"", "");
				transi.ajouter_assign(new Assign(horloge, "=", "0"));
				xta.trans.add(transi);
				xta.add_action(transit.action);
				transi=new Trans_xta(etat_intermediare, transit.E_final,transit.alpha, transit.action);
				transi.ajouter_garde(new Garde(horloge, ">=", transit.g_val_min));
				transi.ajouter_assign(new Assign(transit.action, "=", "true"));
				xta.trans.add(transi);
				
			}
		}
		//System.out.println(xta);
		
		xta_global.xta_aspect.add(xta);
		//System.out.println(xta_global);
	}
	

	private void Traiter(String code) {
		
		String  codes[]=code.split("end");
		
		for( String st: codes) {
			//System.out.println(st);
			String[] type = st.split(" ",2);
			
			if(type[0].equals("system"))this.code_dsl.sb=st;
			else if(type[0].equals("aspect"))this.code_dsl.aspect.add(st);
			else if(type[0].equals("Weaving"))this.code_dsl.weave=st;
		}
		
		
		traiter_dsl(this.code_dsl);
		
		}
		
	private void traiter_dsl(Code_dsl code_dsl) {
		
		s_global.sbs=traiter_dsl_sb(code_dsl.sb);
		s_global.asps=traiter_dsl_aspect(code_dsl.aspect);
		s_global.weaves=traiter_dsl_weave(code_dsl.weave);
		
	}

	private List<Weave> traiter_dsl_weave(String weave) {
		List <Weave> listweave=new ArrayList<Weave>();
		if (!weave.equals("")) {
			//System.out.println(weave);
			String weaves[] = weave.split("[,]");
			//System.out.println(weaves.length);
			for (int i = 0; i < weaves.length; i++) {
				//System.out.println(weaves[i]);
				String[] ws = weaves[i].split("[()]");
				//System.out.println(ws[1]);
				ws = ws[1].split(":");
				Weave w = new Weave(ws);
				listweave.add(w);
			} 
		}
		return listweave;
	}

	private List<Aspect> traiter_dsl_aspect(List<String> aspect) {
		List <Aspect> listasp=new ArrayList<Aspect>();
		//System.out.println(aspect);
		for (String asp:aspect) {
			Aspect aspunite=new Aspect();
			String[] chaines = asp.split(";");
			for (String chaine : chaines) {
				//System.out.println(chaine);
				String unites[]=chaine.split("[ ,]");
				for(String unite:unites) {
					//System.out.println(unite);
				}
				if(unites[0].contentEquals("init"))aspunite.Etat_initial(unites);
				else if(unites[0].contentEquals("aspect"))aspunite.Nom_Systeme(unites);
				else if(unites[0].contentEquals("final"))aspunite.Etats_finaux(unites);
				else if(unites[0].contentEquals("trans"))for(int i=1;i<unites.length;i++)aspunite.Transitions(unites[i]);
			} 
			listasp.add(aspunite);
		}
		return listasp;
	}

	private Systeme_basic traiter_dsl_sb(String sb) {
		Systeme_basic sbc=new Systeme_basic();
		//System.out.println(sb);
		String[] chaines=sb.split(";");
		for(String chaine:chaines) {
			//System.out.println(chaine);
			String unites[]=chaine.split("[ ,]");
			for(String unite:unites) {
				//System.out.println(unite);
			}
			
			if(unites[0].contentEquals("behaviourinit"))sbc.Etat_initial(unites);
			else if(unites[0].contentEquals("system"))sbc.Nom_Systeme(unites);
			else if(unites[0].contentEquals("final"))sbc.Etats_finaux(unites);
			else if(unites[0].contentEquals("trans"))for(int i=1;i<unites.length;i++)sbc.Transitions(unites[i]);
		}
		
		return sbc;
	}

	private String nouvel_etat(){
		String etat="A"+Integer.toString(++this.etat_num);
		return etat;
		
	}
	
	private String nouvel_clock(){
		String clock="cl"+Integer.toString(++this.clock_num);
		return clock;
		
	}
	
	private String nouvel_instance(){
		String instance="I"+Integer.toString(++this.instance_num);
		return instance;
		
	}
	
	private String nouvel_channel(){
		String channel="Ch"+Integer.toString(++this.chanel_num);
		return channel;
		
	}
	
	private String nouvel_id(){
		String id="id"+Integer.toString(++this.id_num);
		return id;
		
	}
	
	private String nouvel_constante(){
		String constante="N"+Integer.toString(++this.constante_num);
		return constante;
		
	}

	@SuppressWarnings("finally")
	public File verify(File fs1, File fs2) {
		File fr=new File("c:\\temp\\resultat.txt");
		try {
			
			String s1=fs1.getAbsolutePath();
			String s2=fs2.getAbsolutePath();
			String s3=fr.getAbsolutePath();
			String st[]= {"cmd.exe","/C","verifyta.exe "+s1+" "+s2+" > "+s3+" 2>&1"};
			//for (String s:st)System.out.println(s);
			Runtime runtime = Runtime.getRuntime();
			final Process process = runtime.exec(st);
			process.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return fr;
		}
		
	}
	
}


