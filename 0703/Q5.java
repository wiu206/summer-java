import java.util.Scanner;

public class Q5 {                       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        double c = sc.nextDouble();           

        double f = c * 9 / 5 + 32;            

        if (f == Math.floor(f)) {
            System.out.println((int) f);     
        } else {
            System.out.printf("%.1f%n", f);    
        }

        sc.close();                        
    }
}
