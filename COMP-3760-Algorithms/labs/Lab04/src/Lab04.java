// Name: Jihyo Kim
// Student number: A01017545
// Set: 3M

// This source code contains two functions that generate all permutations of 0, 1 and 2 by given length.

import java.util.ArrayList;

public class Lab04 {
    static public void main(String[] args) {
        System.out.println("Generating all patterns of a given length");
        for (int i = 1; i < 11; i++) {
            System.out.println(String.format("Length %d produces %d patterns.",
                    i, generatePossiblePatternsOfLights(i).size()));
        }
        System.out.println("Generating patterns without double-digits");
        for (int i = 1; i < 11; i++) {
            System.out.println(String.format("Length %d produces %d patterns.",
                    i, generatePossiblePatternsOfLightsWithoutDoubleDigits(i).size()));
        }
    }

    static public ArrayList<String> generatePossiblePatternsOfLights(int n) {
        ArrayList<String> patterns = new ArrayList<>();
        if (n == 1) {
            patterns.add("0");
            patterns.add("1");
            patterns.add("2");
        } else if (n > 1) {
            ArrayList<String> prevPatterns = generatePossiblePatternsOfLights(n - 1);
            // Append 0, 1 and 2 to each previous pattern.
            for (String pattern : prevPatterns) {
                patterns.add(pattern.concat("0"));
                patterns.add(pattern.concat("1"));
                patterns.add(pattern.concat("2"));
            }
        }
        return patterns;
    }

    static public ArrayList<String> generatePossiblePatternsOfLightsWithoutDoubleDigits(int n ) {
        ArrayList<String> patterns = new ArrayList<>();
        if (n == 1) {
            patterns.add("0");
            patterns.add("1");
            patterns.add("2");
        } else if (n > 1) {
            ArrayList<String> prevPatterns = generatePossiblePatternsOfLightsWithoutDoubleDigits(n - 1);
            // Append 0, 1 and 2 to each pattern.
            // If a pattern ends with 0, only 1 and 2 are appended to the pattern.
            // If a pattern ends with 1, only 0 and 2 are appended to the pattern.
            // If a pattern ends with 2, only 0 and 1 are appended to the pattern.
            for (String pattern : prevPatterns) {
                if (pattern.endsWith("0")) {
                    patterns.add(pattern.concat("1"));
                    patterns.add(pattern.concat("2"));
                } else if (pattern.endsWith("1")) {
                    patterns.add(pattern.concat("0"));
                    patterns.add(pattern.concat("2"));
                } else {
                    patterns.add(pattern.concat("0"));
                    patterns.add(pattern.concat("1"));
                }
            }
        }
        return patterns;
    }
}
