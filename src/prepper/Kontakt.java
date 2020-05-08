package prepper;

public class Kontakt {
	private int tlf;
	private String navn;
	
	public Kontakt(int tlf, String navn) {
		this.tlf = tlf;
		this.navn = navn;
	}
	
	public String toString() {
		return tlf + ": " + navn;
	}
	
}
