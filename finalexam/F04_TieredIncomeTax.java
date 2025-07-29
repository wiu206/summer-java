import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] income = new int[n];
        int[] tax = new int[n];
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            income[i] = sc.nextInt();
            tax[i] = calculateTax(income[i]);
            totalTax += tax[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Tax: $" + tax[i]);
        }

        int avg = totalTax / n;
        System.out.println("Average: $" + avg);
    }

    static int calculateTax(int income) {
        if (income <= 560000)
            return (int) Math.round(income * 0.05);
        else if (income <= 1260000)
            return (int) Math.round(income * 0.12 - 39200);
        else if (income <= 2520000)
            return (int) Math.round(income * 0.20 - 140000);
        else if (income <= 4720000)
            return (int) Math.round(income * 0.30 - 392000);
        else
            return (int) Math.round(income * 0.40 - 864000);
    }

    /*
     * Time Complexity: O(n)
     * 說明：每筆收入皆獨立計算稅額，總共走訪 n 筆資料，且每筆稅額依固定級距試算，無巢狀迴圈，因此整體時間複雜度為 O(n)。
     */
}
