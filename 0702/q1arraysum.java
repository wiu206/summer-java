import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();       // 讀取整數 n
        int sum = 0;                     // 加總結果
        int ops = 0;                     // 加法次數

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt(); // 讀入每個數字
            sum += num;                  // 執行加總
            ops++;                       // 記錄加法次數
        }

        System.out.println(sum);
        System.out.println(ops);
    }
}
