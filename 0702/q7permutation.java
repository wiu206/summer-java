import java.util.Scanner;

public class q7permutation {

    static int n;             
    static int[] perm;        
    static boolean[] used;     
    static long ops = 0;      

    static void dfs(int depth) {
        if (depth == n) {              
            for (int i = 0; i < n; i++) {
                System.out.print(perm[i]);
                if (i < n - 1) System.out.print(" ");
            }
            System.out.println();
            ops++;                 
            return;
        }

        for (int i = 1; i <= n; i++) {    
            if (!used[i]) {
                used[i] = true;
                perm[depth] = i;
                dfs(depth + 1);          
                used[i] = false;       
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        n = sc.nextInt();

        if (n < 0 || n > 8) {            
            System.err.println("n 必須介於 0 到 8 之間");
            return;
        }

        perm  = new int[n];
        used  = new boolean[n + 1];       

        dfs(0);                          
        System.out.println(ops);          
    }
}
