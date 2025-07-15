import java.util.Arrays;
import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    private static int toMinutes(String hhmm) {
        int h = Integer.parseInt(hhmm.substring(0, 2));
        int m = Integer.parseInt(hhmm.substring(3));
        return h * 60 + m;
    }

    private static String toHHMM(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       
        sc.nextLine();               

        int[] times = new int[n];     
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine().trim();
            times[i] = toMinutes(t);
        }

        String queryStr = sc.nextLine().trim();
        int query = toMinutes(queryStr);

        int idx = Arrays.binarySearch(times, query);
        if (idx >= 0) {                
            idx++;                     
        } else {
            idx = -(idx + 1);         
        }

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(toHHMM(times[idx]));
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：
 * 1. 使用 Arrays.binarySearch 於已排序的 n 筆時刻表，耗時 log₂n。
 * 2. 其餘轉換與輸出皆為 O(1)，總時間支配項為二分搜尋。
 */
