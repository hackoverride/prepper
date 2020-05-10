package sunday;
 
	

public class Utstyr implements Comparable<Utstyr>{
	private int id;
	private String leverandor, navn, farge, plassering;

	public Utstyr(String l, String n, String f, String p) {
		this.leverandor = l;
		this.navn = n;
		this.farge = f;
		this.plassering = p;
		
	}public Utstyr(int id, String l, String n, String f, String p) {
		this.id = id;
		this.leverandor = l;
		this.navn = n;
		this.farge = f;
		this.plassering = p;
		
	}
	
	public String toString() {
		return 	"Leverandør: " + this.leverandor +" | "+
				"Navn: " + this.navn + " | " +
				"Farge: " + this.farge + " | " +
				"Plassering: " + this.plassering + "\n";
	}
	
	
	
	
	
	
	
	
	@Override
	public int compareTo(Utstyr o) {
		int res = this.farge.toLowerCase().compareTo(o.farge.toLowerCase());
		if (res == 0) {
			return this.navn.toLowerCase().compareTo(o.navn.toLowerCase());
		} else {
			return res;
		}
	}
	
	
	
}
