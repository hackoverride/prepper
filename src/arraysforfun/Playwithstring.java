package arraysforfun;

import java.util.Scanner;

public class Playwithstring {

	public static void main(String[] args) {
		
		System.out.println("!!");
		
		
		String temp = "1;Michael Lund;Norway;Vestfold";
		
		String[] holder = temp.split(";");
		
		for (String s: holder) {
			System.out.println(s);
		}
		
		System.out.println("-------------");
		
		Scanner les = new Scanner(temp).useDelimiter(";");
		while (les.hasNext()) {
			System.out.println(les.next());
		}
		les.close();
		
	}
}
