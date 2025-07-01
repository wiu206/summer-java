
public class matrix_multiplication_trace {

    public static void main(String[] args) {

        int[][] a = { {1, 2}, {3, 4} };
        int[][] b = { {5, 6}, {7, 8} };

        int n = a.length;         
        int[][] c = new int[n][n];  

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                StringBuilder trace = new StringBuilder();
                int sum = 0;

                for (int k = 0; k < n; k++) {
                    int term = a[i][k] * b[k][j];
                    sum += term;

                    trace.append(a[i][k]).append("*").append(b[k][j]);

                    if (k < n - 1) trace.append(" + ");
                }

                c[i][j] = sum;  

                System.out.printf("計算位置 c[%d][%d]：%s = %d%n", i, j, trace, sum);
            }
        }

        System.out.println("\n結果矩陣：");
        for (int[] row : c) {
            for (int v : row) {
                System.out.printf("%4d", v);
            }
            System.out.println();
        }
    }
}
