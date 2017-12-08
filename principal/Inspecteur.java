package principal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class Inspecteur {
	
	/**
	 * Méthode permettant d'inspecter l'objet o : 
	 * - afficher son type et différentes informations,
	 * - ses superclasses,
	 * - ses attributs,
	 * - ses méthodes, ...
	 *  
	 * @param o		Objet que l'on veut inspecter 
	 */

	public static void inspect (Object o)
	{
		Class <?> classDeO = o.getClass();
		Class <?> superClassDeO = classDeO.getSuperclass();
	
		if (superClassDeO != null) {
			Inspecteur.affiche("" + superClassDeO.getClass());
			do {
				Inspecteur.affiche("" + superClassDeO);
				superClassDeO = superClassDeO.getSuperclass();			
			}while(superClassDeO != null);
		}
		
		if ( classDeO.isAnonymousClass()) {
			Inspecteur.affiche("La classe est anonyme");
		}
		
		if ( classDeO.isArray()) {
			Inspecteur.affiche("La classe est un array");
		}
		
		if ( classDeO.isPrimitive()) {
			Inspecteur.affiche("La classe est un type primitif");
		}
		
		
		Inspecteur.affiche("" + o); 
		Inspecteur.affiche("" + classDeO + " même chose que " + o.getClass());
		
		try {
			Object autreO = classDeO.newInstance();
			Inspecteur.affiche("Création réussi");
		} catch (InstantiationException | IllegalAccessException e) {
			Inspecteur.affiche(e.getClass().getName());
		}
				
		// Q3 :
		// Allez y
		// ... 
		for (Constructor<?> c : classDeO.getDeclaredConstructors()) {
			Inspecteur.affiche("" + c);
		}
		
		for (Field f : classDeO.getDeclaredFields() ) {
			Inspecteur.affiche("" + f);
			try {
				f.setAccessible(true);
				Inspecteur.affiche("" + f.get(o));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for (Method m : classDeO.getDeclaredMethods() ) {
			Inspecteur.affiche(Modifier.isPublic(m.getModifiers()) ? "Public" : "Privée");
			Inspecteur.affiche(Modifier.isStatic(m.getModifiers()) ? "Static" : "Instance");
			
			if (m.getParameterTypes().length == 0) {
				if (m.getReturnType() == void.class) {
					try {
						m.invoke(o);
						Inspecteur.affiche("Appel OK");
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}					
				} else {
					try {
						Inspecteur.affiche("" + m.invoke(o));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}					
				}
			}
			
			Inspecteur.affiche("" + m);
			
		}
		
		for (Type t : classDeO.getGenericInterfaces()) {
			Inspecteur.affiche("" + t);
		}
		
		
	}
	
	private static void affiche(String s)
	{
		System.out.println("   "+s);
	}
}
