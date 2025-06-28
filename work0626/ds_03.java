package work0626;

import java.util.Scanner;

public class ds_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = scanner.nextLine();

        System.out.print("請輸入年齡：");
        int age = scanner.nextInt();
        scanner.nextLine();              

        System.out.print("請輸入城市：");
        String city = scanner.nextLine();

        System.out.printf("姓名：%s%n年齡：%d%n城市：%s%n", name, age, city);

        scanner.close();
    }
}
