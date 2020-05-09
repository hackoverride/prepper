package prepper;

public class Kontakt implements Comparable<Kontakt>{
	private int tlf;
	private String navn;
	
	public Kontakt(int tlf, String navn) {
		this.tlf = tlf;
		this.navn = navn;
	}
	
	public String toString() {
		return tlf + ": " + navn;
	}
	public String toString(boolean x) {
		return tlf + " " + navn;
	}
	
	public int getTlf() {
		return tlf;
	}
	
	public void setTlf(int i) {
		this.tlf = i;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String s) {
		this.navn = s;
	}


	public int compareTo(Kontakt other) {

			return this.navn.compareTo(other.navn);

		
		
	}
	
}
