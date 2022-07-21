import java.util.ArrayList;
import java.util.Scanner;

public class RomanNumeral {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Ecrire un nombre: ");

			//Reads the integer written by the user and assigns it  
		
			int nombre = scanner.nextInt();

			System.out.format(" In roman numeral %d is: %s ", nombre, numeral(nombre));
		}
		catch (Exception e){
			System.out.println("you must put an integer");
		}
		

	}

	// This function will concatenate n times letter EX: concatenate ("I", 3) -> III

	public static String concatenate(String letter, int n) {
		String b = "";
		for (int i = 0; i < n; i++) {
			b += letter;
		}
		return b;
	}

	// This function defines the rules for conversion to Roman numerals
	// It takes a table containing ( I, V, X) or (X,L,C) or (C, D, M) in order and i
	// which define the case and the rule to apply.
	// it returns Roman numerals

	public static String ordonate(ArrayList<String> tableau, int i) {

		String rom_numeral = "";

		if (i < 4) { // case i<4
			rom_numeral = concatenate(tableau.get(0), i);
		}

		if (i > 5 && i < 9) { // case 5<i<10

			rom_numeral = tableau.get(1) + concatenate(tableau.get(0), Math.abs(5 - i));
		}
		if (i == 5) {

			rom_numeral = tableau.get(1);
		}
		if (i == 9) {

			rom_numeral = tableau.get(0) + tableau.get(2);
		}
		if (i == 4) {
			rom_numeral = tableau.get(0) + tableau.get(1);

		}

		return rom_numeral;
	}

//  the numeral function will handle the different cases of going from thousand to unit
//	and concatenating

	public static String numeral(int value) {

		String Roman = "";
		int var = 1000;
		int flag = 0; // use to detect the beginning of valid number in tab (different to zero)
		ArrayList<String> tableau = new ArrayList<String>(3);
		ArrayList<Integer> tab = new ArrayList<Integer>(5);

		if (value < 0) {
			return "impossible to convert negative value";
		}
		if (value == 0) {
			return "Nulla";
		}

		// This part will break down a number into units ten hundred thousand and
		// arrange them in a tab

		while (var != 0) {
			tab.add(value / var);
			value = value - var * (value / var);
			var = var / 10;
		}

		for (int i = 0; i < tab.size(); i++) {

			if (tab.get(i) != 0) {
				flag = 1;
			}

			if (flag != 0) { // valid number

				switch (i) {

				// case 0: for thousand

				case 0:

					Roman = concatenate("M", tab.get(i));
					break;

				// case 1: for hundred

				case 1:
					tableau.clear();
					tableau.add("C");
					tableau.add("D");
					tableau.add("M");
					Roman += ordonate(tableau, tab.get(i));

					break;

				// case 2: for ten

				case 2:
					tableau.clear();
					tableau.add("X");
					tableau.add("L");
					tableau.add("C");

					Roman += ordonate(tableau, tab.get(i));

					break;

				// case 3: for unit

				case 3:
					tableau.clear();
					tableau.add("I");
					tableau.add("V");
					tableau.add("X");

					Roman += ordonate(tableau, tab.get(i));
					break;

				default:
					break;
				}
			}

		}

		return Roman;

	}

}