import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            String[] hm = sc.nextLine().split(":");
            int minutes = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            times[i] = minutes;
        }

        String[] q = sc.nextLine().split(":");
        int query = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);

        int idx = binarySearch(times, query);

        if (idx == -1) {
            System.out.println("No bike");
        } else {
            int h = times[idx] / 60;
            int m = times[idx] % 60;
            System.out.printf("%02d:%02d\n", h, m);
        }
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    /*
     * Time Complexity: O(log n)
     * 說明：使用二分搜尋法找出第一個晚於查詢時間的時刻，
     * 時間表已排序，搜尋過程最多 log n 次比較，因此時間複雜度為 O(log n)。
     */
}
