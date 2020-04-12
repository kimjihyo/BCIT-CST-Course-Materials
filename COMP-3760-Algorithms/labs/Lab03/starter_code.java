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

		//-----------------------------------------------------------------
		//
		// CHANGE THE INPUT FILE NAME HERE:
		//
		String INPUT_FILE_NAME = "14_names.txt";
		String[] names = read_input_file(INPUT_FILE_NAME);


		//-----------------------------------------------------------------
		//
		// ASSIGNMENT PART 3: Code for your main-body processing starts here:
		//

		System.out.println("Hello, world");
		System.out.println("JUSTIN alpha score is " + alpha_score("JUSTIN"));
		System.out.println("JUSTIN zeta score is " + zeta_score("JUSTIN"));

	}

	//-----------------------------------------------------------------
	//
	// ASSIGNMENT PART 1: Complete this function.
	// Do not change the function signature (arguments or return type)
	//
	public static int alpha_score(String name) {
		return -37;   // Wait, that can't be right, can it?
	}

	//-----------------------------------------------------------------
	//
	// ASSIGNMENT PART 2: Complete this function.
	// Do not change the function signature (arguments or return type)
	//
	public static long zeta_score(String name) {
		return -37;   // Wait, that can't be right, can it?
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
