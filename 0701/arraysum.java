public class arraysum {
   
    public static int countAboveAverage(int[] arr, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        double average = (double) total / n;
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > average) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40, 50};
        int result = countAboveAverage(data, data.length);
        System.out.println("大於平均值的元素個數為：" + result);
    }
}
