import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = recursiveGCD(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    static int recursiveGCD(int a, int b) {
        if (a == b) return a;
        if (a > b) return recursiveGCD(a - b, b);
        else return recursiveGCD(a, b - a);
    }

    /*
     * Time Complexity: O(max(a, b))
     * 說明：輾轉相減法的遞迴次數最差會達到 a + b 次，約為 O(max(a, b))；
     * 不如輾轉相除法（O(log n)）效率高，但仍可正確求得 GCD，進而計算 LCM。
     */
}
