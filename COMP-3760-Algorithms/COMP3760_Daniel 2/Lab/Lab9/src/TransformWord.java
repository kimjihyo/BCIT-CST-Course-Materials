import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class TransformWord {
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        ArrayList<String> wordsList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));

        String line;
        int numberOfTestSets = Integer.parseInt(br.readLine());
        br.readLine();
        for (int i = 0; i < numberOfTestSets; ++i) {
            while ((line = br.readLine()) != null) {
                if (line.equals("*"))
                    break;
                wordsList.add(line);
            }

            int v = wordsList.size();
            matrix = new int[v][v];

            for (int j = 0; j < matrix.length - 1; ++j) {
                for (int k = j + 1; k < matrix.length; ++k)
                    if (adjacencyCheck(wordsList.get(j), wordsList.get(k))) {
                        matrix[j][k] = 1;
                        matrix[k][j] = 1;
                    }
            }

            while (br.ready()) {
                String line1 = br.readLine();
                String[] words1 = line1.split("\\s+");
                System.out.print(words1[0] + " " + words1[1] + " ");
                BFS(wordsList.indexOf(words1[0]), wordsList.indexOf(words1[1]));
            }
        }

    }

    private static void BFS(int beg, int end) {
        boolean[] visit = new boolean[matrix.length];
        visit[beg] = true;
        int count = 0;
        LinkedList<Integer> temp = new LinkedList<>();

        temp.add(beg);

        while (!temp.isEmpty() && temp.get(0) != null) {
            int f = temp.get(0);
            count++;
            int adjCount = -1;

            for (int j = 0; j < matrix[f].length; ++j) {
                if ((matrix[f][j] != 1) || visit[j]) {
                    continue;
                }
                adjCount++;
                visit[j] = true;
                if (j == end)
                    System.out.println(count);
                temp.add(j);
            }
            temp.remove(0);
            count -= adjCount;
        }
    }


    private static boolean adjacencyCheck(String first, String second) {
        int counter = 0;
        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); ++i) {
                if (first.charAt(i) != second.charAt(i)) ++counter;
                if (counter > 1) return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
