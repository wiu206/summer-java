public class ArrayUtility {

    public static void printArray(int[] array) {
        System.out.print('[');
        for (int i = 0; i < array.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println(']');
    }

    public static void reverseArray(int[] array) {
        for (int l = 0, r = array.length - 1; l < r; l++, r--) {
            int tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
        }
    }

    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    public static int findSecondLargest(int[] array) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int v : array) {
            if (v > first) {
                second = first;
                first = v;
            } else if (v > second && v < first) {
                second = v;
            }
        }
        return second;
    }

    public static void main(String[] args) {

        int[] data = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("Original : ");
        printArray(data);

        reverseArray(data);
        System.out.print("Reversed : ");
        printArray(data);

        int[] copy = copyArray(data);
        System.out.print("Copy     : ");
        printArray(copy);

        int secondLargest = findSecondLargest(data);
        System.out.println("Second largest value: " + secondLargest);
    }
}
