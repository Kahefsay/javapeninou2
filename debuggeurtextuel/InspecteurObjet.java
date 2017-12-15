package debuggeurtextuel;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class InspecteurObjet {

	/**
	 * Méthode permettant d'afficher :
	 * - les attributs de o,
	 * - si ce sont des objets : les attributs de ces objets
	 * - de façon récursive
	 * @param o		Objet que l'on veut inspecter 
	 * @param dec	Décalage écran pour indenter les sous-objets
	 */
	private static void inspectObject (Object o, String dec)
	{
		// todo / ICI
		Class <?> classeDeO = o.getClass();
		
		InspecteurObjet.afficheInspecteurObjet(dec + "Les attributs");
		dec += " ";
		for(Field f : classeDeO.getDeclaredFields()) {
			try {
				f.setAccessible(true);
				InspecteurObjet.afficheInspecteurObjet(dec + f + "  " + "Valeur : " + f.get(o));
				if (!Modifier.isStatic(f.getModifiers())) {
					if (!f.getType().isPrimitive() & !f.getType().isArray()) {
						InspecteurObjet.inspectObject(f.get(o), dec += " ");
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
