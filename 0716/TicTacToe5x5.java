import java.util.Scanner;

public class TicTacToe5x5 {

    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private final char[][] board = new char[SIZE][SIZE];
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 5x5 井字遊戲 ===\n");
        new TicTacToe5x5().play();
    }

    /** 主要流程 */
    private void play() {
        initBoard();
        printBoard();

        char current = PLAYER_X;
        while (true) {
            int[] pos = readMove(current);
            int r = pos[0], c = pos[1];
            board[r][c] = current;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子%n", current, r, c);
            printBoard();

            if (isWin(current)) {
                System.out.printf("玩家 %c 獲勝！%n", current);
                break;
            }
            if (isFull()) {
                System.out.println("平手！");
                break;
            }
            current = (current == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }
    }

    /** 初始化棋盤為 EMPTY */
    private void initBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                board[r][c] = EMPTY;
            }
        }
    }

    /** 讀取並驗證玩家輸入 */
    private int[] readMove(char player) {
        while (true) {
            System.out.printf("請玩家 %c 輸入 row col (0–4): ", player);
            if (!sc.hasNextInt()) {
                System.out.println("請輸入整數！");
                sc.nextLine();
                continue;
            }
            int r = sc.nextInt();
            if (!sc.hasNextInt()) {
                System.out.println("請輸入兩個整數！");
                sc.nextLine();
                continue;
            }
            int c = sc.nextInt();
            sc.nextLine(); // consume 換行

            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) {
                System.out.println("座標超出範圍，請重新輸入。");
                continue;
            }
            if (board[r][c] != EMPTY) {
                System.out.println("該位置已被佔用，請重新輸入。");
                continue;
            }
            return new int[]{r, c};
        }
    }

    /** 列印棋盤 (含行、列索引) */
    private void printBoard() {
        System.out.print("\n  ");
        for (int c = 0; c < SIZE; c++) System.out.print(" " + c);
        System.out.println();
        for (int r = 0; r < SIZE; r++) {
            System.out.print(r + " ");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** 是否全部填滿 */
    private boolean isFull() {
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                if (board[r][c] == EMPTY) return false;
        return true;
    }

    /** 勝負判定：檢查行、列、兩條對角線是否全為 player */
    private boolean isWin(char player) {
        // 行
        for (int r = 0; r < SIZE; r++) {
            boolean rowWin = true;
            for (int c = 0; c < SIZE; c++)
                if (board[r][c] != player) { rowWin = false; break; }
            if (rowWin) return true;
        }
        // 列
        for (int c = 0; c < SIZE; c++) {
            boolean colWin = true;
            for (int r = 0; r < SIZE; r++)
                if (board[r][c] != player) { colWin = false; break; }
            if (colWin) return true;
        }
        // 主對角線
        boolean diag1 = true;
        for (int i = 0; i < SIZE; i++)
            if (board[i][i] != player) { diag1 = false; break; }
        if (diag1) return true;

        // 反對角線
        boolean diag2 = true;
        for (int i = 0; i < SIZE; i++)
            if (board[i][SIZE - 1 - i] != player) { diag2 = false; break; }
        return diag2;
    }
}
