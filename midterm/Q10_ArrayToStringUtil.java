import java.util.Scanner;

public class Q10_ArrayToStringUtil {

    public static String arrayToString(int[] arr) {
        if (arr == null) return "null";
        int n = arr.length;
        if (n == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[').append(arr[0]);     

        for (int i = 1; i < n; i++) {        
            sb.append(", ").append(arr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();            
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        System.out.println(arrayToString(data));
        sc.close();
    }
}
