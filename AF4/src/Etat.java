
import java.util.HashMap;
import java.util.Set;

public class Etat {

	HashMap<Character, EnsEtat> transitions;
	boolean init;
	boolean term;
	int id;

	//Constructeurs
	
	public Etat() {
		this.transitions = new HashMap<Character, EnsEtat>();
	}

	public Etat(int id) {
		this.transitions = new HashMap<Character, EnsEtat>();
		this.id = id;
	}

	public Etat(boolean init, boolean term, int id) {
		this.transitions = new HashMap<Character, EnsEtat>();
		this.init = init;
		this.term = term;
		this.id = id;
	}

	public Etat(boolean estInit, boolean estTerm) {
		this.init = estInit;
		this.term = estTerm;
		this.transitions = new HashMap<Character, EnsEtat>();
	}
	
	  ////////////////////////////////
	 //       MES FONCTIONS        //
	////////////////////////////////
	
	EnsEtat succ(char c){
		return this.transitions.get(c);
	}
	EnsEtat succ(){
		EnsEtat unionEtats = new EnsEtat();
		for(char c : transitions.keySet()){
			for(Etat etat : transitions.get(c)){
				unionEtats.add(etat);
			}
		}
		return unionEtats;
	}
	void ajouteTransition(char c, Etat e){
		if(transitions.containsKey(c)){
			transitions.get(c).add(e);
		}
		else{
			EnsEtat nouvelEtat = new EnsEtat();
			nouvelEtat.add(e);
			transitions.put(c, nouvelEtat);
		}
	}
	
	public String toString(){
		String s = "" + id + " : ";
		for(Character cle : transitions.keySet()){
			s+= " (" + cle + ", " + succ(cle).toString() + "), "; 
		}
		return s;
	}
	
	//Accesseurs/Modifieurs
	
	public boolean isInit() {
		return init;
	}

	public boolean isTerm() {
		return term;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public void setTerm(boolean term) {
		this.term = term;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		} else {
			final Etat other = (Etat) obj;
			return (id == other.id);
		}
	}

}