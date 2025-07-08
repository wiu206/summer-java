import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine().trim();

        int a, b;
        if (line.contains("+")) {               
            String[] p = line.split("\\+");
            a = Integer.parseInt(p[0].trim());
            b = Integer.parseInt(p[1].trim());
        } else {

            a = Integer.parseInt(line);
            b = sc.nextInt();
        }

        System.out.println(a + b);
        sc.close();
    }
}