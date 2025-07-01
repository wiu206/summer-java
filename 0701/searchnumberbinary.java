public class searchnumberbinary {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5, 6, 8, 10};  // 請確認這裡是已排序陣列
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("請輸入要搜尋的數字: ");
        int target = scanner.nextInt();
        boolean found = false;

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                found = true;
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("數字 " + target + " 在陣列中找到。");
        } else {
            System.out.println("數字 " + target + " 在陣列中未找到。");
        }
    }
}
