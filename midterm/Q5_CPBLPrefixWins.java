import java.util.Scanner;

public class Q5_CPBLPrefixWins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {  
            result[i] = sc.nextInt();
        }

        int k = sc.nextInt();        

        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + result[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 建前綴和表需線性掃描 n 場，每次加總 O(1)。
 * 2. 輸出前 k (≤ n) 個值至多再掃 n 次，同階線性。
 * 3. 主要操作皆與 n 成正比，總時間複雜度為 O(n)。
 */
