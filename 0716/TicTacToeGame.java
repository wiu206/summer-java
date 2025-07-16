import java.util.Scanner;

class TicTacToeGame {
    private static final int SIZE = 5;       // 棋盤大小
    private static final int WIN_LENGTH = 4; // 幾顆連線獲勝
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    /** 初始化 SIZE×SIZE 棋盤 */
    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    /** 顯示棋盤 */
    static void printBoard(char[][] board) {
        System.out.println("\n  棋盤");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    /** 放置棋子 */
    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("❌ 無效座標，請重新輸入");
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.println("❌ 該位置已被佔用，請重新輸入");
            return false;
        }
        board[row][col] = player;
        return true;
    }

    /** 檢查是否有連續 WIN_LENGTH 子 */
    static char checkWinner(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char current = board[row][col];
                if (current == EMPTY) continue;

                // 檢查四個方向
                if (col + WIN_LENGTH <= SIZE &&
                    allEqual(board, row, col, 0, 1, current)) return current;
                if (row + WIN_LENGTH <= SIZE &&
                    allEqual(board, row, col, 1, 0, current)) return current;
                if (row + WIN_LENGTH <= SIZE && col + WIN_LENGTH <= SIZE &&
                    allEqual(board, row, col, 1, 1, current)) return current;
                if (row + WIN_LENGTH <= SIZE && col - WIN_LENGTH + 1 >= 0 &&
                    allEqual(board, row, col, 1, -1, current)) return current;
            }
        }
        return EMPTY;
    }

    /** 幫助檢查連續子是否一致 */
    static boolean allEqual(char[][] board, int r, int c, int dr, int dc, char player) {
        for (int i = 1; i < WIN_LENGTH; i++) {
            if (board[r + dr * i][c + dc * i] != player) {
                return false;
            }
        }
        return true;
    }

    /** 檢查是否平手 */
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = initializeBoard();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER_X;

        System.out.println("=== 井字遊戲 5x5（連續 " + WIN_LENGTH + " 子獲勝） ===");

        while (true) {
            printBoard(board);
            System.out.printf("玩家 %c 請輸入座標 (row col)：", currentPlayer);
            int row, col;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("❌ 輸入格式錯誤，請輸入兩個整數！");
                scanner.nextLine(); // 清除錯誤輸入
                continue;
            }

            if (!placePiece(board, row, col, currentPlayer)) {
                continue;
            }

            if (checkWinner(board) == currentPlayer) {
                printBoard(board);
                System.out.printf("\n🎉 玩家 %c 獲勝！\n", currentPlayer);
                break;
            }

            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("\n🤝 平手！");
                break;
            }

            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        scanner.close();
    }
}
