import java.util.Scanner;

public class Q3_NightMarketRanking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();      
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
   
            double tmp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = tmp;
        }

        int k = Math.min(5, n);
        for (int i = 0; i < k; i++) {
            System.out.printf("%.1f%n", scores[i]);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n²)
 * 說明：
 * 1. 選擇排序兩層迴圈：外層 n-1 次、內層平均 (n-i-1) 次比較，
 * 2. 總比較約 n(n-1)/2，與 n² 同階，故時間複雜度為 O(n²)。
 */
