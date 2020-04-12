// Name: Jihyo Kim
// Student Number: A01017545
// Set: 3M

import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class PickABetterName {

	// -----------------------------------------------------------------------
	// 
	// COMP 3760, Winter 2020, Lab 3
	//
	// 
	// 
	// -----------------------------------------------------------------------

	public static void main(String[] args) throws FileNotFoundException {
		// IMPORTANT!
		// This program expects to have res folder with names text files in the working directory.
		// Otherwise, the program will not run as expected.

		File folder = new File("./res");
		File[] files = folder.listFiles();

		if (files == null) {
			System.out.println("res folder is empty!");
			return;
		}

		for (File file : files) {
			String[] names = read_input_file(file.toString());


			System.out.println(String.format("Input file is %s", file.toString()));
			System.out.println(String.format("%d names processed", names.length));

			String nameWithHighestAlphaScore = "";
			String nameWithHighestZetaScore = "";
			int highestAlphaScore = 0;
			long highestZetaScore = 0;

			for (String name : names) {
				int alphaScore = alpha_score(name);
				long zetaScore = zeta_score(name);

				if (alphaScore > highestAlphaScore) {
					highestAlphaScore = alphaScore;
					nameWithHighestAlphaScore = name;
				}

				if (zetaScore > highestZetaScore) {
					highestZetaScore = zetaScore;
					nameWithHighestZetaScore = name;
				}
			}

			System.out.println(String.format("Highest alpha_score is %s with %d", nameWithHighestAlphaScore, highestAlphaScore));
			System.out.println(String.format("Highest zeta_score is %s with %d\n", nameWithHighestZetaScore, highestZetaScore));
		}
	}

	//-----------------------------------------------------------------
	//
	// ASSIGNMENT PART 1: Complete this function.
	// Do not change the function signature (arguments or return type)
	//
	public static int alpha_score(String name) {
		int alpha_score = 0;
		for (char letter : name.toCharArray()) {
			alpha_score += letter - 'A' + 1;
		}
		return alpha_score;
	}

	//-----------------------------------------------------------------
	//
	// ASSIGNMENT PART 2: Complete this function.
	// Do not change the function signature (arguments or return type)
	//
	public static long zeta_score(String name) {
		if (name.isEmpty()) {
			return 0;
		}

		long zeta_score = 1;
		for (char letter : name.toCharArray()) {
			zeta_score *= letter - 'A' + 1;
		}
		return zeta_score;
	}

	//-----------------------------------------------------------------
	//
	// YOU SHOULD NOT NEED TO, AND THEREFORE SHOULD NOT, CHANGE ANYTHING 
	// ABOUT THIS FUNCTION.
	// If you think you want to, please check with me first.
	// 
	public static String[] read_input_file(String fname) throws FileNotFoundException {
	    File file = new File(fname); 
	    Scanner sc = new Scanner(file); 
	    String str = sc.nextLine();
	    sc.close();
	    String[] names = str.split(",");
	    return names;
	}
	
}
