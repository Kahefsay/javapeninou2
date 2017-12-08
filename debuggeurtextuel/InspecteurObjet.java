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
