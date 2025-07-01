
public class array_sum_trace {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5};

        int total = 0; 

        for (int value : arr) {
            System.out.printf("加總過程：total = %d + %d = %d%n",
                              total, value, total + value);
            total += value;  
        }

        System.out.println("總和為：" + total);
    }
}
