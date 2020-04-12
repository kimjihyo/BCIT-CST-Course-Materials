import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Find_the_Keycode {

	public static void main(String[] args) throws IOException {
		
		//
		// Set the input data file name here
		//
		String fn = "length_5_N_27100.txt";

		//
		// Call helper function to read the input file
		//
		int[] data = read_array(fn);
		
		//
		// We need to know the length of the "strings" in this data file (for output 
		// purposes later), but we read and saved them as integers, so the best way to 
		// determine this now is to loop over the list, find the largest item, and 
		// assume that all of the items are as long as that one.
		//
		int max = 0;
		for (int i=0; i<data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		int length_of_keycodes = String.valueOf(max).length();
		System.out.println("length of keycodes is " + length_of_keycodes);
		
		//
		// Print out the list of input data, for no particular reason
		//
		for (int i=0; i<data.length; i++) {
			//
			// Format the numbers with the correct number of leading zeroes as
			// needed according to the length of the keycodes being processed.
			//
			String fmt = "%0" + length_of_keycodes + "d";
			System.out.println(String.format(fmt, data[i]));
		}
		System.out.println(data.length + " data items in the file");
		
		//
		//---------------------------------------------------------------
		// PUT YOUR MAIN PROGRAM LOGIC HERE
		//  1) Call your function to sort the input list
		//  2) Call your function to find the smallest missing number
		//  3) Print out the smallest missing number
		//---------------------------------------------------------------
		//

		int[] sortedArray = mergeSort(data);
		System.out.print("The keycode is ");
		System.out.println(findMissingBinarySearch(sortedArray));
	}

	public static int[] mergeSort(int[] array) {
		if (array.length == 1) {
			return array;
		}

		int[] leftArray = Arrays.copyOfRange(array, 0, array.length / 2);
		int[] rightArray = Arrays.copyOfRange(array, array.length / 2, array.length);
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
		return mergeArrays(leftArray, rightArray);
	}

	public static int[] mergeArrays(int[] leftArray, int[] rightArray) {
		int index = 0;
		int i = 0;
		int j = 0;
		int[] mergedArray = new int[leftArray.length + rightArray.length];

		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] < rightArray[j]) {
				mergedArray[index] = leftArray[i];
				i++;
			} else {
				mergedArray[index] = rightArray[j];
				j++;
			}
			index++;
		}

		while (i < leftArray.length) {
			mergedArray[index] = leftArray[i];
			i++;
			index++;
		}

		while (j < rightArray.length) {
			mergedArray[index] = rightArray[j];
			j++;
			index++;
		}

		return mergedArray;
	}

	public static int findMissingBinarySearch(int[] array) {
		return findMissingBinarySearch(array, 0, array.length - 1);
	}

	public static int findMissingBinarySearch(int[] array, int left, int right) {
		int mid = (left + right) / 2;
		if (left >= right) {
			return -1;
		}
		if (array[mid] != (left + right) / 2) {
			return array[mid - 1] + 1;
		} else {
			int leftResult = findMissingBinarySearch(array, left, mid);
			int rightResult = findMissingBinarySearch(array, mid + 1, right);
			if (leftResult != -1) {
				return leftResult;
			} else return rightResult;
		}
	}

	public static int[] read_array(String filename) throws IOException {
		//
		// Reads the input file given by "filename", assumed to contain a list of
		// integer numbers. Stores the numbers into an array and returns the
		// array.
		//
		File file = new File(filename);
		Scanner sc = new Scanner(file);

		//
		// Read the items initially into an ArrayList (for dynamic growth)
		//
		ArrayList<Integer> input_list = new ArrayList<Integer>();
		while (sc.hasNext()) {			
			int n = sc.nextInt();
			input_list.add(n);
		}

		//
		// Copy the ArrayList to an Integer[] array of the proper size
		//
        int[] arr = new int[input_list.size()];
        for (int i = 0; i < input_list.size(); i++) {
        	arr[i] = input_list.get(i);
		}
		return arr;
	}
}
