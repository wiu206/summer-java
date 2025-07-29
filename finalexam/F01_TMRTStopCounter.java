import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        String[] stops = new String[n];

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int startIdx = -1, endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(endIdx - startIdx) + 1);
        }
    }

    /*
     * Time Complexity: O(n)
     * 說明：需線性掃描整個停靠站序列一次，找出起訖站的索引位置，
     * 最多進行 n 次比對操作，因此時間複雜度為 O(n)。
     */
}
