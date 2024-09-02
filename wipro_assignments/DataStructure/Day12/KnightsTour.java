package dsa.assignment;

public class KnightsTour {

    static final int N = 8;

    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    static boolean SolveKnightsTour(int[][] board, int moveX, int moveY, int moveCount, int[] xMove, int[] yMove) {
        if (moveCount == N * N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            int nextX = moveX + xMove[i];
            int nextY = moveY + yMove[i];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (SolveKnightsTour(board, nextX, nextY, moveCount + 1, xMove, yMove)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        int moveX = 0, moveY = 0;
        board[moveX][moveY] = 0;

        if (SolveKnightsTour(board, moveX, moveY, 1, xMove, yMove)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists for Knight's Tour problem");
        }
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}