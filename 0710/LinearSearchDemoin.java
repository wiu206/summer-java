import java.util.Arrays;
import java.util.Scanner;

class LinearSearchDemoin {

    static int linearSearch(int[] array, int target) {
        int comparisons = 0;

        for (int i = 0; i < array.length; i++) {
            comparisons++;
            System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d%n",
                              comparisons, i, array[i], target);

            if (array[i] == target) {
                System.out.printf("找到目標值！總共比較了 %d 次%n", comparisons);
                return i; 
            }
        }

        System.out.printf("找不到目標值，總共比較了 %d 次%n", comparisons);
        return -1;  
    }

    static int[] linearSearchAll(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }

        if (count == 0) {
            return new int[0];   
        }

        int[] result = new int[count];
        int idx = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[idx++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入陣列長度：");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        System.out.printf("請依序輸入 %d 個整數（以空白分隔）：%n", n);
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("請輸入要搜尋的目標值：");
        int target = sc.nextInt();

        System.out.println("\n陣列內容：" + Arrays.toString(numbers));
        System.out.println("搜尋目標：" + target);
        System.out.println();

        System.out.println("=== 基本線性搜尋 ===");
        int firstPos = linearSearch(numbers, target);

        if (firstPos != -1) {
            System.out.printf("在索引位置 %d 找到目標值 %d%n", firstPos, target);
        } else {
            System.out.printf("找不到目標值 %d%n", target);
        }

        System.out.println("\n=== 搜尋所有符合位置 ===");
        int[] allPositions = linearSearchAll(numbers, target);

        if (allPositions.length > 0) {
            System.out.printf("目標值 %d 出現在以下位置：", target);
            for (int i = 0; i < allPositions.length; i++) {
                System.out.print(allPositions[i]);
                if (i < allPositions.length - 1) System.out.print(", ");
            }
            System.out.printf("%n總共出現 %d 次%n", allPositions.length);
        } else {
            System.out.printf("找不到目標值 %d%n", target);
        }
    }
}
