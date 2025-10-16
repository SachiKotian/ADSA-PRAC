import java.util.Scanner;

public class NQueens 
{

    static int solutionCount = 0; // to track number of solutions

    // Function to print the board with Q1, Q2, etc.
    static void printBoard(int[][] board, int n) 
    {
        solutionCount++;
        System.out.println("Solution " + solutionCount + ":");
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (board[i][j] > 0)
                    System.out.print("Q" + board[i][j] + " ");
                else
                    System.out.print("-  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if a queen can be placed on board[row][col]
    static boolean isSafe(int[][] board, int row, int col, int n) 
    {
        // Check column
        for (int i = 0; i < row; i++) 
        {
            if (board[i][col] > 0)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) 
        {
            if (board[i][j] > 0)
                return false;
        }

        // Check upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) 
        {
            if (board[i][j] > 0)
                return false;
        }

        return true;
    }

    // Recursive function to solve N-Queen problem
    static boolean solveNQ(int[][] board, int row, int n) 
    {
        if (row == n) 
        {
            printBoard(board, n);  // All queens placed
            return true;
        }

        boolean res = false;

        for (int col = 0; col < n; col++) 
        {
            if (isSafe(board, row, col, n)) 
            {
                board[row][col] = row + 1;  // Place Q(row+1)

                res = solveNQ(board, row + 1, n) || res;

                board[row][col] = 0;  // Backtrack
            }
        }
        return res;
    }

    // Main function
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queens (N): ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        if (!solveNQ(board, 0, n))
            System.out.println("No solution exists");
    }
}
