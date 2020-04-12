import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RearrangeAlbumStack {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("album_stack.txt"));
        int numberOfTestCases = Integer.parseInt(sc.next());

        ArrayList<String> originalOrder;
        ArrayList<String> desiredOrder;

        for (int i = 0; i < numberOfTestCases; ++i) {
            System.out.println("-------Start the test case-------");
            int numberOfAlbums = sc.nextInt();
            sc.nextLine();

            originalOrder = new ArrayList<>();
            desiredOrder = new ArrayList<>();

            for (int j = 0; j < numberOfAlbums; ++j)
                originalOrder.add(sc.nextLine());

            for (int j = 0; j < numberOfAlbums; ++j)
                desiredOrder.add(sc.nextLine());

            int indexOfOriginalOrder = originalOrder.size() - 1;
            int indexOfDesiredOrder = desiredOrder.size() - 1;

            for (int j = indexOfOriginalOrder; j >= 0; j--)
                if (originalOrder.get(indexOfOriginalOrder).equals(desiredOrder.get(indexOfDesiredOrder))) {
                    indexOfDesiredOrder--;
                    indexOfOriginalOrder--;
                } else
                    indexOfOriginalOrder--;

            while (indexOfDesiredOrder >= 0)
                System.out.println(desiredOrder.get(indexOfDesiredOrder--));

            System.out.println();
        }
        sc.close();
    }
}