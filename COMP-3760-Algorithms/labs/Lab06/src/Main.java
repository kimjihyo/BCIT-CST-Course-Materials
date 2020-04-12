import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        try {
            while (true) {
                Scanner userInputScanner = new Scanner(System.in);
                System.out.println("Enter number");
                int userInput = userInputScanner.nextInt();

                if (userInput < 0 ) {
                    break;
                }

                long start = System.currentTimeMillis();
                int count = primeCounterBetterWay(userInput);
                long end = System.currentTimeMillis();
                long timeElapsed = end - start;

                long startForBruteForce = System.currentTimeMillis();
                int countForBruteForce = primeCounterBruteForce(userInput);
                long endForBruteForce = System.currentTimeMillis();
                long timeElapsedForBruteForce = endForBruteForce - startForBruteForce;

                System.out.println(String.format("The time elapsed: %d ms", timeElapsed));
                System.out.println(String.format("The number of primes: %d", count));

                System.out.println(String.format("\nThe time elapsed (Brute Force): %d ms", timeElapsedForBruteForce));
                System.out.println(String.format("The number of primes (Brute Force): %d", countForBruteForce));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int primeCounterBruteForce(int number) {
        int counter = 0;
        for (int i = 0; i < number; i++) {
            if (isPrimeBruteForce(i)) {
                counter++;
            }
        }
        return counter;
    }

    private static int primeCounterBetterWay(int number) {
        int count = 0;
        boolean[] table = isPrimeBetterWay(number);
        for (boolean isPrime : table) {
            if (isPrime)
                count++;
        }
        return count;
    }

    private static boolean isPrimeBruteForce(int number) {
        if (number == 0 || number == 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
          return false;
        } else {

            for (int i = 3; i < number; i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean[] isPrimeBetterWay(int number) {
        boolean[] table = new boolean[number];
        Arrays.fill(table, true);
        table[0] = false;
        table[1] = false;
        table[2] = true;
        int index = 2;
        int multiplier = index;

        while (multiplier < number) {
            index = multiplier;
            if (table[index]) {
                while (index + multiplier < number) {
                    index += multiplier;
                    table[index] = false;
                }
            }
            multiplier++;
        }
        return table;
    }
}