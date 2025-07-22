import java.util.Scanner;

public class isSorted {

    public static boolean isSorted(int[] arr, int index) {

        if (index >= arr.length - 1) {
            return true;
        }

        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入整數陣列（以空格分隔）：");

        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        if (isSorted(arr, 0)) {
            System.out.println("這個陣列是升序排列的。");
        } else {
            System.out.println("這個陣列不是升序排列的。");
        }

        scanner.close();
    }
}
