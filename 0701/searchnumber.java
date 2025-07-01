
public class searchnumber {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5, 6, 8, 10};
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("請輸入要搜尋的數字: ");
        int target = scanner.nextInt();
        boolean found = false;

        for (int number : numbers) {
            if (number == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("數字 " + target + " 在陣列中找到。");
        } else {
            System.out.println("數字 " + target + " 在陣列中未找到。");
        }
    }
    
}
