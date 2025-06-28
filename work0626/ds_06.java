package work0626;

import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        final int SIZE = 10;         
        int[] nums = new int[SIZE];   
        Random rand = new Random();   

        for (int i = 0; i < SIZE; i++) {
            nums[i] = rand.nextInt(100) + 1; 
        }

        System.out.print("陣列內容：");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        int max = nums[0];
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }

        System.out.println("最大值 = " + max);
    }
}
