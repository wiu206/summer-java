public class big_oc {
    public static void main(String[] args) {
        int n = 5; 
        int x = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                x = x + 1;
                count++;
            }
        }

        System.out.println("x = " + x);
        System.out.println("執行次數: " + count); 
    }
}
