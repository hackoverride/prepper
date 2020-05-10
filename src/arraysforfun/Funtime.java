package arraysforfun;

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
	
}
