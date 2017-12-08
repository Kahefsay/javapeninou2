package principal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import personne.Personne;
import utilitaires.Keyboard;

public class MainInspecteur {

	
	public static void main (String argv[]) {
		Personne p1 = new Personne ("Ochon", "Jean-Paul");
		Personne p2 = new Personne ("Peurceluila", "Humphrey");
		
		ArrayList <Personne> v = new ArrayList<Personne> ();
		v.add (p1);
		v.add (p2);
		
		Object o = new Object ();
		
		Personne[] t = new Personne [2];
		t[0] = p1;
		t[1] = p2;

		Integer obji = new Integer(12);
		int i=12;
	
		// Q1 :
		
		MainInspecteur.affmain("aff de Object.class");
		// Déjà fait
			MainInspecteur.affmain(""+Object.class);
		
		MainInspecteur.affmain("aff de Personne.class");
		// Ajouter ici l'affichage de Personne.class
			MainInspecteur.affmain("" + Personne.class);
		
		MainInspecteur.affmain("aff de ArrayList.class");
		// Ajouter ici l'affichage de ArrayList.class
			MainInspecteur.affmain("" + ArrayList.class);
		
		MainInspecteur.affmain("aff de int.class");
		// ...
			MainInspecteur.affmain("" + int.class);
	
		MainInspecteur.affmain("aff de void.class");
		// ...
			MainInspecteur.affmain("" + void.class);	
		
		Keyboard.readForWait("-> return pour continuer");

		// Q2 (rien à modifier ici, voir classe Inspecteur) :
			
		MainInspecteur.affmain("Inspection de Personne p1");
			Inspecteur.inspect(p1);
			Keyboard.readForWait("-> return pour continuer");
		
		MainInspecteur.affmain("Inspection de ArrayList<Personne> v");
			Inspecteur.inspect(v);
			Keyboard.readForWait("-> return pour continuer");
			
		MainInspecteur.affmain("Inspection de Object o");
			Inspecteur.inspect(o);
			Keyboard.readForWait("-> return pour continuer");
			
		MainInspecteur.affmain("Inspection de tableau de Personne t");
			Inspecteur.inspect(t);
			Keyboard.readForWait("-> return pour continuer");
		
		MainInspecteur.affmain("Inspection de Integer obji");
			Inspecteur.inspect(obji);
			
		MainInspecteur.affmain("Inspection de int i");
			Inspecteur.inspect(i);
			Keyboard.readForWait("-> return pour continuer");
			MainInspecteur.affmain("Pour vérifier dernier appel de inspect(i)");		
			MainInspecteur.affmain(""+int.class.isPrimitive());		
	}
	
	private static void affmain(String s)
	{
		System.out.println("-> "+s);
	}
}
