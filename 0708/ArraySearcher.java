public class ArraySearcher {
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        int[] data = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        int[] targets = {67, 100};
        for (int t : targets) {
            int idx = findElement(data, t);
            int cnt = countOccurrences(data, t);
            System.out.println("搜尋值 " + t + " -> 索引: " + idx + "，出現次數: " + cnt);
        }
    }
}
