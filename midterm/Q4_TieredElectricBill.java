import java.util.Scanner;

public class Q4_TieredElectricBill {

    private static final int[] LIMIT =  {120, 330, 500, 700, 1000, Integer.MAX_VALUE};
    private static final double[] PRICE = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};

    private static int calc(int kWh) {
        double fee = 0;
        int prev = 0; 

        for (int i = 0; i < LIMIT.length && kWh > 0; i++) {
            int curLimit = LIMIT[i];
            int segment = Math.min(kWh, curLimit - prev); 
            fee += segment * PRICE[i];
            kWh -= segment;
            prev = curLimit;
        }
        return (int) Math.round(fee);  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();            
        long total = 0;               

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int bill = calc(kWh);
            total += bill;
            System.out.println("Bill: $" + bill);
        }

        long avg = Math.round((double) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 主要流程線性掃描 n 戶；每戶 calc(kWh) 最多 6 段常數計算。
 * 2. 常數 × n ⇒ 時間複雜度與 n 成線性，故為 O(n)。
 */
