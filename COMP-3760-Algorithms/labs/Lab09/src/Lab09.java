// Name: Jihyo Kim
// Student #: A01017545
// Set: 3M

public class Lab09 {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            long start = System.currentTimeMillis();
            long result = SW_Recursive(i, i);
            long end = System.currentTimeMillis();
            System.out.println(String.format("SW_Recursive(%d, %d) = %d, time is %d ms", i, i, result, end - start));
        }
        System.out.println();
        for (int i = 0; i < 15; i++) {
            long start = System.currentTimeMillis();
            long result = SW_DynamicProg(i, i);
            long end = System.currentTimeMillis();
            System.out.println(String.format("SW_DynamicProg(%d, %d) = %d, time is %d ms", i, i, result, end - start));
        }
    }

    public static long SW_Recursive(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        } else {
            return SW_Recursive(m - 1, n) + SW_Recursive(m, n-1);
        }
    }

    public static long SW_DynamicProg(int m, int n) {
        long[][] buffer = new long[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    buffer[i][j] = 1;
                } else {
                    buffer[i][j] = buffer[i - 1][j] + buffer[i][j - 1];
                }
            }
        }
        return buffer[m][n];
    }
}
