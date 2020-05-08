package prepper;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Mai2018 {
	/*
	 * I klassen er det brukt innkapsling, og det er private access p� alle objektvariablene.
	 * Deklarer de objektvariablene du mener f�lger beskrivelsen for klassen Billett
	 * Deklarer en konstrukt�r for denne klassen med inndata
	 * Bruk innkapsling krever deklarasjon av set og get metoder. Skriv kun en av set og en av get metodene for denne klassen.
	 * 
	 */
	
	// Jeg later som Mai2018 er billett klassen under: Oppgave 1:
	
	/*
	private String startPlassering, startDatoTid;
	private String sluttPlassering, sluttDatoTid;
	private String person;
	int antallReisende;
	double discount;
	double totalPris;
	
	public Mai2018(String startPlassering, int antallReisende) {
		// jeg orker ikke skrive ut hele konstrukt�ren for �vingen her.
		this.startPlassering = startPlassering;
		this.antallReisende = antallReisende;
		
	}
	
	public void setPerson(String s) {
		this.person = s;
	}
	
	public String getPerson() {
		return person;
	}
	*/
	
	/* Oppgave 2 */
	
	/*
	 * P� sekvensielle tekstfiler er det lagret f�dselsdatoer for ulike studentgrupper, en fil per studentgruppe. 
	 * Datoene har formatet: DD.MM.����
	 * 
	 * Skriv et komplett Javaprogram som leser inn navnet p� filen fra brukeren.
	 * Tell opp antall studenter i den aktuelle gruppen i ulike �rstall (laveste til h�yeste) skriv ut i tabell oppsett 
	 * i en ny fil med "res" foran det opprinnelige filnavnet.
	 */
	
	public Mai2018() {
		String filnavn = JOptionPane.showInputDialog("Filnavn:");
		oppgave2(filnavn);
		
	}
	
	private void oppgave2(String filen) {
		Map<String, Integer> kart = new HashMap<String, Integer>();
		try {
			File fil = new File(filen);
			Scanner leser = new Scanner(fil);
			
			while (leser.hasNext()) {
				String year = leser.next().substring(6, 10);
				kart.put(year, +1);
			}
			leser.close();
		} catch (Exception e) {
			//
		}
		try {
			PrintWriter skriv = new PrintWriter("res" + filen);
			
			kart.forEach((key,value) -> skriv.println(key + ": " + value)); //i<3lambda
			skriv.close();
		} catch (Exception e) {
			//
		}
		
	}
	
	
	
	
	
	
	
}
