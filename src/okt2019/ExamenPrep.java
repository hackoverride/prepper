package okt2019;

public class ExamenPrep {

	public static void main(String[] args) {
		/*
		 * Oktober 2019
		 * Oppgave 1:
		 */
		
		
	}

}

//klassen under er abstract for å bare holde denne inn i denne filen. føler det blir mer rot med klasser man ikke skal bruke.
abstract class Seddel {
	private String land;
	private double verdi;
	private String valuta;
	private int year;
	private int kvalitet;

	public Seddel(/* Seddel bygger */) {
		// this = osv...
	}
	
	/*
	 * 2 stk get og set metoder()
	 * unødvendig
	 * */
	
	public boolean equals(Seddel other) {
		boolean resultatet = false;
		int counter = 0;
		int target = 5;
		// mulig jeg hadde nested alle if her, men for å lese lettere legger jeg en teller.
		if (this.land.equals(other.land)) {
			counter++;
		}
		if (this.valuta.equals(other.valuta)) {
			counter++;
		}
		if (this.verdi == other.verdi) {
			counter++;
		}
		if (this.year == other.year && this.kvalitet == other.kvalitet) {
			counter += 2;
		}
		
		if (counter == target) {
			resultatet = true;
		}
		
		return resultatet;
	}
	
	public String toString() {
		return "Land: " + land + "\n" +
				"Valuta: " + valuta + "\n" +
				"År: " + year;
		// orker ikke skrive ut alt...
	}
	/*
	private void svadas() {
		//oppgave 1b
		
		Seddel[] tab = new Seddel[100];
		
		for (Seddel s : tab) {
			if (s.year < 1960 && s.value >= 100) {
				s.toString();
			}
		}
		
		
	}*/
	
}
