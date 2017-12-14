package personne;


public class Adresse 
	
{
	private int numero;
	private String rue;
	private String codePost;
	private String ville;

	public Adresse() {
		this(0, "","","");
	}
	
	public Adresse(int numero, String rue, String codePost, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePost = codePost;
		this.ville = ville;
	}
	
	public String getCodePost() {
		return codePost;
	}
	public void setCodePost(String codePost) {
		this.codePost = codePost;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Adresse ["+System.identityHashCode(this)+", numero=" + numero + ", rue=" + rue + ", codePost="
				+ codePost + ", ville=" + ville + "]";
	}

}
