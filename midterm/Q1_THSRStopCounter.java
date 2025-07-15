import java.util.Scanner;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();         
        String[] stops = new String[n];  
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();     
        String end   = sc.next();    

        int startIdx = -1, endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end))   endIdx   = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(startIdx - endIdx) + 1; 
            System.out.println(count);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 單次 for 迴圈線性掃描 n 站，找出起訖索引。
 * 2. 其餘皆 O(1) 操作，總成本與 n 成正比。
 */
