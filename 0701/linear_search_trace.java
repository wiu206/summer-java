
import java.util.Scanner;

public class linear_search_trace {

    public static void main(String[] args) {

        int[] s = {1, 3, 5, 7, 9};

        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字：");
        int target = sc.nextInt();

        boolean found = false;  

        for (int value : s) {
            System.out.printf("比對中：%d vs %d%n", target, value);

            if (value == target) {   
                found = true;
                break;           
            }
        }

        System.out.println("結果：" + (found ? "找到" : "未找到"));
    }
}
