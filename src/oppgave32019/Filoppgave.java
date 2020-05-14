package oppgave32019;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Filoppgave {

	public static void main(String[] args) {
		
		 /*
		  *  Få innput av filnavn.
		  *  tell opp antall studenter på mnd eller år
		  *  sorter på dato
		  *  skriv ut i ny fil med "res" forrant opprinnelige filen.
		  *  eks: 1992: 2 etc.
		  *  Eller Feb: 2.
		  *  */ 
		
		
		String filnavn = JOptionPane.showInputDialog("Filnavn: ");
		File fil = new File(filnavn);
		
		int hoy = 0;
		int lav = 2030;
		
		try {
			Scanner les = new Scanner(fil);
			while (les.hasNext()) {
				
				// "29.06.1998"
				String tempS = les.next();
				
				//String[] dataTab = tempS.split(".");
				
				//int year = Integer.parseInt(dataTab[2]);
				
				int year = Integer.parseInt(tempS.substring(6, 10));

				if (year > hoy) {
					hoy = year;
				}
				if (year < lav) {
					lav = year;
				}
				
			}
			les.close();
			
		} catch (Exception e) {
			//
		}
		
		int[] years = new int[hoy-lav+1];
		int[] antall = new int[years.length];

		for (int i = 0; i < years.length; i++ ) {
			years[i] = lav + i;
		}
		
		try {
			Scanner les = new Scanner(fil);
			while (les.hasNext()) {
				String tempS = les.next();
				int year = Integer.parseInt(tempS.substring(6, 10));
				
				for ( int i = 0; i < years.length; i++) {
					if (year == years[i]) {
						antall[i]++;
					}
				}
				
			}
			les.close();
		} catch (Exception e) {
			//
		}
		for (int i = 0; i < years.length; i++) {
			System.out.println(years[i] +" " +antall[i]);
		}
		
		
		
	}
	
	

}
