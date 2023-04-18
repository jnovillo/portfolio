import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Bronze {
    private static int[][] grid;
    private static int[][] instructions;
    private static Scanner input;
    private static int R, C, E, N;

    public static void main (String[] args) {
        File file = new File("files/makelake.in");
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException x) {
            // file not found
        }

        R = Integer.parseInt(input.next());
        C = Integer.parseInt(input.next());
        E = Integer.parseInt(input.next());
        N = Integer.parseInt(input.next());

        populateGrid();
        // System.out.println(grid[0][0]);
        populateInstructions();
        // System.out.println(instructions[0][0]);

        // stomp through the instructions
        for (int i = 0; i < N; i++) {
            stomp(i);
        }
        // System.out.println(grid[0][0]);

        fillWithWater();
        // for (int row = 0; row < R; row++) {
        //     for (int col = 0; col < C; col++) {
        //         System.out.println(grid[row][col]);
        //     }
        // }

        System.out.println(calculateWater());
    }

    private static void populateGrid() {
        grid = new int[R][C];
        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                grid[row][col] = Integer.parseInt(input.next());
            }
        }
    }

    private static void populateInstructions() {
        instructions = new int[N][3];
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < 3; col++) {
                instructions[row][col] = Integer.parseInt(input.next());
            }
        }
    }

    private static void stomp (int instructionNumber) {
        int startRow = instructions[instructionNumber][0] - 1;
        int startCol = instructions[instructionNumber][1] - 1;
        int stomp = instructions[instructionNumber][2];
        int highestLevel = 0;

        for(int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + startRow][col + startCol] > highestLevel) {
                    highestLevel = grid[row + startRow][col + startCol];
                }
            }
        }

        int stompTo = highestLevel - stomp;
        if (stompTo < 0) stompTo = 0;

        for(int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + startRow][col + startCol] > stompTo) {
                    grid[row + startRow][col + startCol] = stompTo;
                }
            }
        }
    }

    private static void fillWithWater() {
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                grid[row][col] = E - grid[row][col];
                if (grid[row][col] < 0) grid[row][col] = 0;
            }
        }
    }

    private static int calculateWater() {
        int waterHeight = 0;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                waterHeight += grid[row][col];
            }
        }
        // System.out.println(waterHeight);

        return waterHeight * 72 * 72;
    }
}
