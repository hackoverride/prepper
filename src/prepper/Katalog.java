package prepper;

public class Katalog {

	private Kontakt[] listen;
	private String filnavn = "kontakter.txt";
	
	public Katalog() {
		listen = new Kontakt[0];
		
	}
	
	public // <---- Fortsetter her i morgen.
	
	private Kontakt[] addArray(Kontakt[] kont) {
		Kontakt[] nytt = new Kontakt[kont.length+1];
		for ( int i = 0; i < kont.length; i++ ) {
			nytt[i] = kont[i];
		}
		return nytt;
	}
	
}
