import java.util.Scanner;

public class fibonacciSlow {

    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入 n：");
        int n = scanner.nextInt();

        System.out.println("\n[標準遞迴] 第 " + n + " 項為：" + fibonacciSlow(n));
        
        int[] memo = new int[n + 1]; 
        System.out.println("[記憶化遞迴] 第 " + n + " 項為：" + fibonacciFast(n, memo));

        scanner.close();
    }
}
