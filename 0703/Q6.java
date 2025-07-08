import java.util.Scanner;

public class Q6 {                 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int    n = sc.nextInt();       
        double x = sc.nextDouble();   
        double sum = n + x;          

        System.out.printf("%.2f%n", sum);

        sc.close();                    
    }
}
