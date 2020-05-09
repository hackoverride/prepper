package prepper;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Katalog {

	private Kontakt[] listen;
	private String filnavn = "kontakter.txt";
	
	public Katalog() {
		listen = new Kontakt[0];
		lesFil();
		
	}
	
	public void remove(String name) {
		name = name.toLowerCase();
		int pos = 0;
		boolean found = false;
		for (Kontakt k : listen) {
				String tempNavn = k.getNavn().toLowerCase();
				if (tempNavn.equals(name)) {
					found = true;
				} else {
					pos++;
				}
				if (found) {
					removeKontakt(pos);
					break;
				}	
		}
	}
	
	public void add(int nr, String name) {
		listen = addArray(listen);
		listen[listen.length-1] = new Kontakt(nr, name); 
		lagre();
	}
	
	private Kontakt[] addArray(Kontakt[] kont) {
		Kontakt[] nytt = new Kontakt[kont.length+1];
		for ( int i = 0; i < kont.length; i++ ) {
			nytt[i] = kont[i];
		}
		return nytt;
	}
	
	private void removeKontakt(int n) {
		try {
			Kontakt[] temp = new Kontakt[this.listen.length-1];
			int place = 0;
			for (int i = 0; i < this.listen.length; i++ ) {
				if (i == n) {
					// do nothing
				} else {
					temp[place++] = this.listen[i];
				}
			}
			this.listen = temp;
		} catch (Exception e) {
			System.err.print("!outofbounds");
		}
		lagre();
	}
	
	public void sortNames() {
		Arrays.sort(this.listen); 
		lagre();
	}
	
	private void lesFil() {
		try {
			File fil = new File(this.filnavn);
			Scanner les = new Scanner(fil);
			while (les.hasNextLine()) {
				int tempTlf = 0;
				String name = "";
				String temp = les.nextLine();
				Scanner linjeLes = new Scanner(temp);
				tempTlf = linjeLes.nextInt();
				name = linjeLes.next();
				linjeLes.close();
				add(tempTlf, name);
			}
			les.close();
		} catch (Exception e) {
			//
		}
	}
	
	private void lagre() {
		try {
			PrintWriter skriv = new PrintWriter(filnavn);
			for (Kontakt k : this.listen) {
				skriv.println(k.toString(true));
			}
			skriv.close();
		} catch (Exception e) {
			System.err.print("Katalog .lagre() <-- ");
		}
	}
	
	public void sorterNummer() {
		int pos = 0;
		int[] nummer = new int[listen.length];
		String[] navn = new String[listen.length];
		for (Kontakt k : listen) {
			nummer[pos] = k.getTlf();
			navn[pos] = k.getNavn();
			pos++;
		}
		
		//manuell sortering
		boolean done = false;
		while (!done) {
			int moves = 0;
			for (int i = 1; i < nummer.length; i++) {
				if (nummer[i] < nummer[i-1]) {
					moves++;
					String temp = navn[i];
					int tempnr = nummer[i];
					nummer[i] = nummer[i-1];
					navn[i] = navn[i-1];
					nummer[i-1] = tempnr;
					navn[i-1] = temp;
					
					
				}
			}
			if (moves == 0) {
				done = true;
			}
			moves = 0;
		}
		
		for ( int i = 0; i < listen.length; i++ ) {
			listen[i].setNavn(navn[i]);
			listen[i].setTlf(nummer[i]);
		}
		lagre();
		
		
	}
	
	public String toString() {
		String temp = "";
		for (Kontakt k: listen) {
			temp += k.toString();
			temp += "\n";
		}
		return temp;
	}
	
}
