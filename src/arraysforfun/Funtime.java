package arraysforfun;

import java.util.HashMap;
import java.util.Scanner;

public class Funtime {

	public static void main(String[] args) {
		/*
		Scanner x = new Scanner(System.in);
		System.out.print("input your name: ");
		String holder = x.next();
		System.out.println(holder);
		x.close();
		*/
		int[] tester = { 1, 2, 3, 88, 89, 99, 1, 12, 33, 15, 32, 155 };
		tester = sorting(tester);
		for (int i: tester) {
			System.out.print(i + " ");
		}
		System.out.println("");
		tester = sortingDesc(tester);
		for (int i: tester) {
			System.out.print(i + " ");
		}
		
		int[] nummer = {123, 456, 789};
		String[] navn = {"Bjarne", "Thorleif", "Gudrun"};
		
		HashMap<Integer, String> kat = changeToHash(nummer, navn);
		
		kat.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});
		
		final int HEIGHT = 10;
		final int WIDTH = (int)(HEIGHT*1.618);
		
		for (int i = 0; i < WIDTH; i++) {
			
			for (int j = 0; j < HEIGHT; j++) {
				if (i == 0 || i == WIDTH -1) {
					System.out.print("-");
				} else {
				
				if(j == 0 || j == HEIGHT-1) {
					System.out.print("|");
				} else {
					System.out.print("O");
				}
				}
				
			}
			System.out.println("");
		}
		
		
		
		
		
		
	}
	
	private static int[] sorting(int[] tab) {
		int moves = 1;
		while (moves != 0) {
			moves = 0;
			for ( int i = 1; i < tab.length; i++) {
				if (tab[i] < tab[i-1]) {
					int temp = tab[i-1];
					tab[i-1] = tab[i];
					tab[i] = temp; 
					moves++;
				}
			}
		}
		return tab;
	}
	
	private static int[] sortingDesc(int[] tab) {
		int moves = 1;
		while (moves != 0) {
			moves = 0;
			for ( int i = 1; i < tab.length; i++) {
				if (tab[i] > tab[i-1]) {
					int temp = tab[i-1];
					tab[i-1] = tab[i];
					tab[i] = temp; 
					moves++;
				}
			}
		}
		return tab;
	}
	
	private static HashMap<Integer, String> changeToHash(int[] nr, String[] nvn) {
		HashMap<Integer, String> katalog = new HashMap<Integer, String>();
		for (int i = 0; i < nr.length ; i++) {
			katalog.put(nr[i], nvn[i]);
		}
		return katalog;
	}
	
	
	
}
