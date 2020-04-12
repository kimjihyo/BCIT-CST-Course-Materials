import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/love.txt"));

        Map<String, Integer> hm = new HashMap<>();

        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            if (!hm.containsKey(word))
                hm.put(word, 1);
            else if (hm.containsKey(word)) {
                int temp = hm.get(word);
                hm.put(word, ++temp);
            }
        }

        Map<String, Integer> sorted = new TreeMap<>(hm);
        for (Object k : sorted.keySet())
            System.out.println(k + " : " + sorted.get(k));

        sc.close();
    }
}
