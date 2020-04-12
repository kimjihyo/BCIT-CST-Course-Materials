import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DetermineDistinctWord {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/q2input.txt"));
        Set<String> s = new HashSet<>();
        int counter = 0;

        while (sc.hasNext()) {
            s.add(sc.next());
            counter++;
        }

        if (counter == s.size())
            System.out.println("DISTINCT");
        else
            System.out.println("NOT DISTINCT");
    }
}
