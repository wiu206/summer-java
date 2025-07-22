import java.util.Scanner;

public class FactorialExampleinput {

    public static int factorial(int n, StringBuilder steps) {
        if (n <= 1) {
            steps.append("1");
            return 1;
        } else {
            steps.append(n).append(" * ");
            return n * factorial(n - 1, steps);
        }
    }

    public static void printFactorial(int n) {
        StringBuilder steps = new StringBuilder();
        int result = factorial(n, steps);
        System.out.println(n + "! = " + steps.toString() + " = " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個非負整數：");
        int input = scanner.nextInt();

        if (input < 0) {
            System.out.println("不支援負數的階乘計算！");
        } else {
            printFactorial(input);
        }

        scanner.close();
    }
}
