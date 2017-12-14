package debuggeurtextuel;


import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

import personne.Personne;
import utilitaires.Keyboard;


public class InspecteurObjet {

	/**
	 * M�thode permettant d'afficher :
	 * - les attributs de o,
	 * - si ce sont des objets : les attributs de ces objets
	 * - de fa�on r�cursive
	 * @param o		Objet que l'on veut inspecter 
	 * @param dec	D�calage �cran pour indenter les sous-objets
	 */
	private static void inspectObject (Object o, String dec)
	{
		// todo / ICI
		Class <?> classeDeO = o.getClass();
		for(Field f : classeDeO.getDeclaredFields()) {
			InspecteurObjet.afficheInspecteurObjet(dec + "Les attributs");
			dec += " ";
			try {
				f.setAccessible(true);
				InspecteurObjet.afficheInspecteurObjet(dec + f + "  " + "Valeur : " + f.get(o));
				if (!Modifier.isStatic(f.getModifiers())) {
					if (!f.getType().isPrimitive() & !f.getType().isArray()) {
						System.out.println("on passe ici");
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dec += " ";
		}
		
		
	}
	public static void inspectObject (Object o)
	{
		Class <?> classeDeO = o.getClass();
		
		InspecteurObjet.afficheInspecteurObjet(""+o);
		InspecteurObjet.afficheInspecteurObjet(""+classeDeO);
		InspecteurObjet.inspectObject(o, "");
	}
	
	private static void afficheInspecteurObjet(String s)
	{
		System.out.println("   "+s);
	}
}
