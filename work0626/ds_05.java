package work0626;

public class ds_05 {
    public static void main(String[] args) {

        int[] numbers = { 3, 7, 11, 15, 19, 23, 27, 31, 35, 39 };

        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        System.out.println("陣列元素總和 = " + sum);
    }
}
