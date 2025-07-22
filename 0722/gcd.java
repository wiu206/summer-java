import java.util.Scanner;

public class gcd {

    public static int gcd(int a, int b) {
        a = Math.abs(a); 
        b = Math.abs(b);
        
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入第一個整數：");
        int a = scanner.nextInt();

        System.out.print("請輸入第二個整數：");
        int b = scanner.nextInt();

        int result = gcd(a, b);
        System.out.println("最大公因數為：" + result);

        scanner.close();
    }
}
