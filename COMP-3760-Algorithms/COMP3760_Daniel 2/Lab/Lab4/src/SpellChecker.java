import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SpellChecker {
    private String[] dictArray;
    private int dictSize;
    private String[] testArray;
    private int testSize;

    public SpellChecker(String dictFile, String testFile) {
        try {
            String dict_text = new String(Files.readAllBytes(Paths.get(dictFile))).toLowerCase();
            this.dictArray = dict_text.split("\n");
            this.dictSize = this.dictArray.length;

            String test_text = new String(Files.readAllBytes(Paths.get(testFile))).toLowerCase();
            this.testArray = test_text.split(" ");
            this.testSize = this.testArray.length;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Dictionary file size: " + this.dictSize + " words");
            System.out.println("Test file size: " + this.testSize + " words");
        }
    }

    private int seqSearch() {
        long start = System.nanoTime();
        int count = 0;
        for (int i = 0; i < this.testSize; i++) {
            for (int j = 0; j < this.dictSize; j++) {
                if (this.testArray[i].equals(this.dictArray[j])) {
                    count ++;
                    break;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Sequential searching took " + (end-start)/(double)1000000 + " ms");
        return this.testSize - count;
    }

    private int binSearch() {
        long start = System.nanoTime();
        int count = 0;
        for (int i = 0; i < this.testSize; i++) {
            int lowestIndex = 0;
            int highestIndex = this.dictSize - 1;
            int middleIndex = 0;
            while (lowestIndex <= highestIndex) {
                middleIndex = (lowestIndex + highestIndex) / 2;

                if (this.testArray[i].compareTo(this.dictArray[middleIndex]) > 0) {
                    lowestIndex = middleIndex + 1;
                } else if (this.testArray[i].compareTo(this.dictArray[middleIndex]) < 0) {
                    highestIndex = middleIndex - 1;
                } else {
                    count++;
                    break;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Binary searching took " + (end-start)/(double)1000000 + " ms");
        return this.testSize - count;
    }

    public static void main (String args[]) {
        SpellChecker test = new SpellChecker("lab4_wordlist.txt", "lab4_testdata.txt");
        int theTotalNumberOfMisspelled = test.seqSearch();
        System.out.println("According to sequential search, test data has " + theTotalNumberOfMisspelled + " misspelled words.");
        theTotalNumberOfMisspelled = test.binSearch();
        System.out.println("According to binary search, test data has " + theTotalNumberOfMisspelled + " misspelled words.");
    }
}
