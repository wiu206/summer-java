import java.util.Scanner;

public class Q6_NightMarketMap {

    private static final int SIZE = 10;         

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();                 
        char[][] map = new char[SIZE][SIZE];

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                map[r][c] = '#';
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
                map[r][c] = '*';
            }
        }

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }

        sc.close();
    }
}

