package personne;

public class Personne implements Comparable<Personne> {
	
	private String nom, prenom;

	public Personne () {
		this ("sans nom", "sans prenom");
	}
	
	public Personne (String n, String p) {
		this.nom = n;
		this.prenom = p;
	}

	public void setNomPrenom (String n, String p) {
		this.nom = n;
		this.prenom = p;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}
	
	@Override
	public String toString () {
		return "Nom : "+this.nom+", prénom : "+this.prenom;
	}

	public int compareTo(Personne arg0) {
		if (this.nom.compareTo(arg0.nom) == 0)
			return this.prenom.compareTo(arg0.prenom);
		else
			return this.nom.compareTo(arg0.nom);
	}
}
