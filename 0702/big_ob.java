public class big_ob {
    public static void main(String[] args) {
        int n = 5; 
        int x = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            x = x + 1;
            count++;
        }

        System.out.println("x = " + x);
        System.out.println("執行次數: " + count); 
    }
}
