import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] colSum = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                colSum[j] += sc.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            if (j > 0) sb.append(' ');
            sb.append(colSum[j]);
        }
        System.out.println(sb);
        sc.close();
    }
}
