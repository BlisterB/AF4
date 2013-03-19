
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Langage {

	Set<String> mots;

	Langage() {
		this.mots = new HashSet<String>();
	}

	Langage(String chaines[]) {
		this();
		for (int i = 0; i < chaines.length; i++) {
			ajoute(chaines[i]);
		}
	}

	public void ajoute(String u) {
	    mots.add(u);
	}

	public Langage inter(Langage L) {
	    Langage inter = new Langage();
	    inter.mots.addAll(mots);
	    inter.mots.retainAll(L.mots);
	    return inter;
	}

	public Langage union(Langage L) {
		Langage union = new Langage();
		union.mots.addAll(mots);
		union.mots.addAll(L.mots);
		return union;
	}

	public Langage concat(Langage L) {
		Langage concat = new Langage();
		for(String u : mots){
			for(String v : L.mots){
				concat.ajoute(u+v);
			}
		}
		return concat;
	}

	public Langage difference(Langage L) {
		Langage difference = new Langage();
		difference.mots.addAll(mots);
		for(String v : L.mots){
			if(mots.contains(v))
				difference.mots.remove(v);
		}
		return difference;
	}

	
	public static String miroirMot(String u) {
		String u2 = new String();
		for(int i = u.length() - 1; i >= 0; i--){
			u2 += u.charAt(i);
		}
		return u2;
	}

	public Langage miroir() {
		Langage miroir = new Langage();
		for(String s : this.mots){
			miroir.mots.add(miroirMot(s));
		}
		return miroir;
	}
	

	public String toString() {
		String res = "{ ";
		for (String u : mots) {
			if (u.length() == 0) {
				res += "mot_vide ";
			} else {
				res += u.toString() + " ";
			}
		}
		return res + "}";
	}

	public void ajouteMotsU(){
		mots.add("Chrono");
		mots.add("Marle");
		mots.add("Lucca");
		mots.add("Robo");
		mots.add("Frog");
		mots.add("Ayla");
		mots.add("Magus");
	}
	
	public void ajouteMotsV(){
		mots.add("Serge");
		mots.add("Kid");
		mots.add("Guile");
		mots.add("Viper");
		mots.add("Fargo");
	}
}