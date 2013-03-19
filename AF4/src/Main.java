import java.util.HashSet;


public class Main {
	public static void main(String args[]) {
		//Automate 1
		Automate A1 = new Automate();
		Etat E0 = new Etat(true, false, 0);
		Etat E1 = new Etat(false, false, 1);
		Etat E2 = new Etat(false, true, 2);
		E0.ajouteTransition('a', E1);
		E1.ajouteTransition('a', E1);
		E1.ajouteTransition('b', E2);
		E1.ajouteTransition('c', E1);
		A1.ajouteEtatSeul(E0);
		A1.ajouteEtatSeul(E1);
		A1.ajouteEtatSeul(E2);
		
		System.out.println(A1.toString());
		System.out.println("E1 est-il deterministre ? " + A1.estDeterministe());
		
	}
}
