import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Silver {
    private static int N, M, T;
    private static int[][] previousGrid;
    private static int[][] nextGrid;
    private static int startRow, startCol, endRow, endCol;
    private static Scanner input;

    public static void main(String[] args) {
        File file = new File("files/ctravel.in");
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException x) {
            // file not found
        }

        N = Integer.parseInt(input.next());
        M = Integer.parseInt(input.next());
        T = Integer.parseInt(input.next());
        input.nextLine();

        populateGrid();

        startRow = Integer.parseInt(input.next());
        startCol = Integer.parseInt(input.next());
        endRow = Integer.parseInt(input.next());
        endCol = Integer.parseInt(input.next());

        previousGrid[startRow - 1][startCol - 1] = 1;

        for (int i = 0; i < T; i++) {
            moveOnce();
            // System.out.println(previousGrid[0][0]);
        }

        System.out.println(previousGrid[endRow - 1][endCol - 1]);
    }

    private static void populateGrid() {
        previousGrid = new int[N][M];
        String curLine;
        for (int row = 0; row < N; row++) {
            curLine = input.nextLine();
            // System.out.println(curLine);
            for (int col = 0; col < M; col++) {
                if (curLine.substring(col, col + 1).equals("*")) {
                    previousGrid[row][col] = -1;
                }
                else {
                    previousGrid[row][col] = 0;
                }
            }
        }
    }

    private static void moveOnce() {
        nextGrid = new int[N][M];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (previousGrid[row][col] != -1) {
                    nextGrid[row][col] = checkSquare(row - 1, col) + checkSquare (row + 1, col) + checkSquare(row, col - 1) + checkSquare(row, col + 1);
                }
                else {
                    nextGrid[row][col] = -1;
                } 
            }
        }

        previousGrid = nextGrid;
    }

    private static int checkSquare (int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return 0;
        }
        else if (previousGrid[row][col] == -1) {
            return 0;
        }
        else {
            return previousGrid[row][col];
        }
    }
}
