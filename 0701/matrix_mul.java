import java.util.Scanner;

public class matrix_mul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        double[][] B = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        double[][] C = multiplyAndTrace(A, B);

        System.out.println("\n=== 最終結果矩陣 C ===");
        printMatrix(C);
    }

    private static double[][] multiplyAndTrace(double[][] a, double[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int kLen = b.length;

        double[][] c = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("\n計算 c[%d][%d] :\n", i, j);
                double sum = 0;

                for (int k = 0; k < kLen; k++) {
                    double term = a[i][k] * b[k][j];
                    sum += term;
                    System.out.printf("    a[%d][%d] * b[%d][%d] = %.0f * %.0f = %.0f\n",
                            i, k, k, j, a[i][k], b[k][j], term);
                }

                c[i][j] = sum;
                System.out.printf("=> c[%d][%d] = %.0f\n", i, j, sum);
            }
        }
        return c;
    }

    private static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double v : row) {
                System.out.printf("%6.0f", v);
            }
            System.out.println();
        }
    }
}
