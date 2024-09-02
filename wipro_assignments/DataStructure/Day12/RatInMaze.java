package dsa.assignment;

public class RatInMaze {

    static final int N = 6;

    static boolean SolveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, solution)) {
            System.out.println("No solution exists");
            return false;
        }

        printSolution(solution);
        return true;
    }

    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            solution[x][y] = 1;

            if (solveMazeUtil(maze, x, y + 1, solution)) {
                return true;
            }

            if (solveMazeUtil(maze, x + 1, y, solution)) {
                return true;
            }

            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = { 
            {1, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
        };

        if (!SolveMaze(maze)) {
            System.out.println("No solution found");
        }
    }
}