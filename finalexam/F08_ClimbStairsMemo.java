import java.util.*;

public class F08_ClimbStairsMemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] memo = new int[n + 1];
        int ways = climb(n, memo);

        System.out.println("Ways: " + ways);
    }

    static int climb(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (memo[n] != 0) return memo[n];

        memo[n] = climb(n - 1, memo) + climb(n - 2, memo) + climb(n - 3, memo);
        return memo[n];
    }

}
