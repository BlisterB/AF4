import java.util.HashSet;

public class EnsEtat extends HashSet<Etat> {

	public EnsEtat() {
		
	}
	
	
	public String toString(){
		String s = "{";
		for(Etat etat : this){
			s +=etat.id;
		}
		s+="}";
		return s;
	}
}