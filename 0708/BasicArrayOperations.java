public class BasicArrayOperations {
    public static void main(String[] args) {
        int[] nums = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        System.out.println("Array length: " + nums.length);

        nums[2] = 99;              
        nums[nums.length - 1] = 100;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + ": " + nums[i]);
        }
    }
}
