import java.util.*;
import java.io.*;

public class Anagram {

    public static void main(String args[]) {
        try {
            String[] words = convertTextFileToStringArray("words.txt");
//
            System.out.println(words.length);
            long start = System.currentTimeMillis();
            findNumOfAnagramsWithDeleting(words);
            long end = System.currentTimeMillis();
            System.out.println("Deleting one took: " + ((end - start) / 1000));

            long start = System.currentTimeMillis();
            findNumOfAnagramsWithSorting(words);
            long end = System.currentTimeMillis();
            System.out.println("Sorting one took: " + ((end - start) / 1000));

            start = System.currentTimeMillis();
            findNumOfAnagramsWithLinearApproach(words);
            end = System.currentTimeMillis();
            System.out.println("Linear approach one took: " + ((end - start) / 1000));

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(checkAnagramByLinearApproach("Hello", "ellHo"));
    }

    private static void findNumOfAnagramsWithLinearApproach(String[] words) {
        int most = 0;
        String winner = "";
        for (int i = 0; i < words.length; i++) {
            int counter = 0;
            for (int j = i; j < words.length; j++) {
                if (checkAnagramByLinearApproach(words[i].toLowerCase(), words[j].toLowerCase())) {
                    counter++;
                }
            }
            if (counter > most) {
                most = counter;
                winner = words[i];
            }
        }

        System.out.println(winner + " " + most);
    }

    private static void findNumOfAnagramsWithDeleting(String[] words) {
        int most = 0;
        String winner = "";
        for (int i = 0; i < words.length; i++) {
            int counter = 0;
            for (int j = i; j < words.length; j++) {
                if (checkAnagramByDeleteing(words[i].toLowerCase(), words[j].toLowerCase())) {
                    counter++;
                }
            }
            if (counter > most) {
                most = counter;
                winner = words[i];
            }
        }

        System.out.println(winner + " " + most);
    }

    //
    private static void findNumOfAnagramsWithSorting(String[] words) {
        int most = 0;
        String winner = "";
        for (int i = 0; i < words.length; i++) {
            int counter = 0;
            for (int j = i; j < words.length; j++) {
                if (checkAnagramBySorting(words[i].toLowerCase(), words[j].toLowerCase())) {
                    counter++;
                }

            }
            System.out.println(words[i] + " " + counter);
            if (counter > most) {
                most = counter;
                winner = words[i];
            }
        }

        System.out.println(winner + " " + most);
    }

    private static String[] convertTextFileToStringArray(String fileName) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        bufferedReader.close();
        String[] words = line.split("\\s+");
        return words;
    }

    // n^2
    private static boolean checkAnagramByDeleteing(String word1, String word2) {
        for (char letter : word1.toCharArray()) {
            if (word2.isEmpty()) {
                return false;
            }
            if (word2.contains(String.valueOf(letter))) {
                word2 = word2.replaceFirst(String.valueOf(letter), "");
                System.out.println(word2);
            } else {
                return false;
            }
        }
        return word2.isEmpty();
    }

    // nlog(n)
    private static boolean checkAnagramBySorting(String word1, String word2) {
        char[] aWord1 = word1.toCharArray();
        char[] aWord2 = word2.toCharArray();
        Arrays.sort(aWord1);
        Arrays.sort(aWord2);

        return Arrays.equals(aWord1, aWord2);
    }

    // n
    private static boolean checkAnagramByLinearApproach(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            if (map.containsKey(word1.charAt(i))) {
                map.replace(word1.charAt(i), map.get(word1.charAt(i)) + 1);
            } else {
                map.put(word1.charAt(i), 1);
            }

            if (map.containsKey(word2.charAt(i))) {
                map.replace(word2.charAt(i), map.get(word2.charAt(i)) - 1);
            } else {
                map.put(word2.charAt(i), -1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
}