import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder all = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringBuilder line = new StringBuilder();
            boolean first = true;
            for (int j = 1; j <= i; j++) {
                if (!first) line.append(' ');
                line.append(j);
                first = false;
            }
            for (int j = i - 1; j >= 1; j--) {
                line.append(' ').append(j);
            }
            all.append(line);
            if (i < n) all.append('\n');
        }
        System.out.print(all.toString());
        sc.close();
    }
}
