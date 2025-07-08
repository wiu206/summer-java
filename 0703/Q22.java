import java.util.Scanner;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        for (int i = 2; i <= n; i += 2) sum += i;
        System.out.println(sum);
        sc.close();
    }
}
