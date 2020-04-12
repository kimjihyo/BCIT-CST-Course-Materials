import java.util.Arrays;

/**
 * COMP3760
 * Lab5
 * 10 Oct 2019
 * Dongsun Kim
 * A01052311
 * Set 3O
 */

public class Lab5 {

    //First problem
    public static int max(int[] arr, int first, int last) {
        if (first > last)
            return -1;
        else if (first == last)
            return first;
        else {
            int mid = (first + last) / 2;
            int left = max(arr, first, mid);
            int right = max(arr, mid + 1, last);
            return (arr[left] >= arr[right]) ? left : right;
        }
    }

    //Second problem
    public static int[] sort(int[] arr) {
        if (arr.length < 2)
            return arr;

        int mid = arr.length / 2;
        int[] low_arr = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] high_arr = sort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] mergedArr = new int[arr.length];
        int m = 0, l = 0, h = 0;
        while (l < low_arr.length && h < high_arr.length) {
            if (low_arr[l] < high_arr[h])
                mergedArr[m++] = low_arr[l++];
            else
                mergedArr[m++] = high_arr[h++];
        }
        while (l < low_arr.length)
            mergedArr[m++] = low_arr[l++];
        while (h < high_arr.length)
            mergedArr[m++] = high_arr[h++];

        return mergedArr;
    }

    //Third problem
    public static int search(int[] arr, int low, int high) {
        if(high >= low) {
            int mid = (low + high)/2;
            if(mid == arr[mid])
                return mid;
            if(mid > arr[mid])
                return search(arr, (mid + 1), high);
            else
                return search(arr, low, (mid -1));
        } else {
            //if there are no elements of A[i] = i
            return -1;
        }
    }

    public static void generateTests(int[] arr) {
        System.out.println("Given Array: " + Arrays.toString(arr));
        //First problem
        System.out.println("The position of the maximum element found(-1 if not exists): " + max(arr, 0, arr.length-1));
        //Second problem
        System.out.println("Sorted array: " + Arrays.toString(sort(arr)));
        //Third problem
        System.out.println("The position of the element of 'arr[i]=i'(-1 if not exists): " + search(sort(arr), 0, arr.length-1) + '\n');
    }

    public static void main(String[] args) {

        /**
         * Array of even length that does not have elements of arr[i]=i
         */
        int[] arr = {19, 11, 13, 5, -6, 7};
        generateTests(arr);

        /**
         * Array of odd length that has an element of arr[i]=i
         */
        arr = new int[]{13, -1, 2, 5, 20};
        generateTests(arr);

        /**
         * Array of no elements
         */
        arr = new int[]{};
        generateTests(arr);

        /**
         * Array of only one element
         */
        arr = new int[]{100};
        generateTests(arr);

        /**
         * Array of two elements
         */
        arr = new int[]{1, -1};
        generateTests(arr);

        /**
         * First problem test with an array with more than one largest number
         */
        arr = new int[]{7, -16, 7, 0, 7};
        System.out.println("Given Array: " + Arrays.toString(arr));
        System.out.println("The position of the maximum element found(-1 if not exists): " + max(arr, 0, arr.length-1) + "\n");

        /**
         * Second problem test with an array that is already sorted
         */
        arr = new int[]{-30, -10, 0, 10, 20};
        System.out.println("Given Array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(sort(arr)));
    }
}
