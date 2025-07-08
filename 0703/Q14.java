import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, v = 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) a[top][j] = v++;
            top++;
            for (int i = top; i <= bottom; i++) a[i][right] = v++;
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) a[bottom][j] = v++;
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) a[i][left] = v++;
                left++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) sb.append(' ');
                sb.append(a[i][j]);
            }
            if (i < n - 1) sb.append('\n');
        }
        System.out.print(sb);
        sc.close();
    }
}
