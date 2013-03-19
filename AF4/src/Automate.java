
public class Automate extends EnsEtat {

    private EnsEtat initiaux;

    public Automate() {
        super();
        initiaux = new EnsEtat();
    }

    public EnsEtat getInitiaux() {
        return initiaux;
    }
    
    boolean ajouteEtatSeul(Etat e){
    	if(this.contains(e)){
    		return false; //Cet automate contient déjà l'état e
    	}
    	else{
    		this.add(e);
    		if(e.isInit()){
    			this.initiaux.add(e);
    		}
    		return true;
    	}
    }
    
    boolean ajouteEtatRecursif(Etat e){
    	if(!this.ajouteEtatSeul(e)){
    		for(Etat etatSuccesseur : e.succ()){
    			ajouteEtatRecursif(etatSuccesseur);
    		}
    		return true;
    	}
    	else return false;
    }
    
    boolean estDeterministe(){
    	//il possède un seul état initial ;
    	int compteur = 0;
    	for(Etat etat : this){
    		if(etat.isInit()) compteur++;
    	}
    	if(compteur != 1) return false;
    	//Pour tout état q, et pour toute lettre a, il existe au plus une transition 
    	//partant de q et portant l'étiquette a
    	for(Etat etat : this){
    		for(Character cle : etat.transitions.keySet()){
    			if(etat.transitions.get(cle).size() > 1)
    				return false;
    		}
    	}
    	return true;
    }
    
    public String toString(){
    	String s = "";
    	//Ensemble des états + Fonction de transition
    	s +="Ensemble des états :\n";
    	for(Etat etat : this){
    		s+= "\t" + etat.toString() + "\n";
    	}
    	
    	//Etat Initial
    	s+="Etat Initial : {";
    	for(Etat etatInitial : initiaux){
    		s+= " "+etatInitial.id + " "; 
    	}
    	s+="}\n";
    	
    	//Etat Final
    	s+="Etat Final :{";
    	for(Etat etat : this){
    		if(etat.term == true) s+= " "+etat.id+" ";
    	}
    	s+="}\n";
    	
    	return s;
    }
}