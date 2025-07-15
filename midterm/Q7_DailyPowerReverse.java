import java.util.Scanner;

public class Q7_DailyPowerReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] power = new int[7];         
        for (int i = 0; i < 7; i++) {
            power[i] = sc.nextInt();
        }

        int left = 0, right = 6;
        while (left < right) {
            int tmp = power[left];
            power[left] = power[right];
            power[right] = tmp;
            left++;
            right--;
        }

        for (int i = 0; i < 7; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(power[i]);
        }
        System.out.println();

        sc.close();
    }
}
