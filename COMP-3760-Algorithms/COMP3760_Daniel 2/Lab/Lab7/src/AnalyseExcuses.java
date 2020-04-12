import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AnalyseExcuses {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/q3test.txt"));

        String[] firstLine = sc.nextLine().split(" ");
        int wordCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);

        Map<String, Integer> wordM = new HashMap<>();

        int count = 0;

        while (sc.hasNext() && count++ < wordCount)
            wordM.put(sc.nextLine(), 0);

        count = 0;

        ArrayList<String> lineM = new ArrayList<>();

        while (sc.hasNext() && count < lineCount) {
            String temp = sc.nextLine();
            if (!lineM.contains(temp))
                lineM.add(temp);
        }

        int[] lineTrack = new int[lineCount - 1];
        int arrCount = 0;
        for (String value : lineM) {
            String[] temp = value.split(" ");
            for (String s : temp)
                if (wordM.containsKey(s))
                    lineTrack[arrCount]++;
            arrCount++;
        }

        Map<String, Integer> lexi = new TreeMap<>();

        int max = lineTrack[lineTrack.length - 1];
        for (int i = lineTrack.length - 1; i >= 0; i--)
            if (lineTrack[i] == max) lexi.put(lineM.get(i), 0);

        for (Object k : lexi.keySet())
            System.out.println(k);
    }
}
