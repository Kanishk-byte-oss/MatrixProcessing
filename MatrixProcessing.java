import java.util.Scanner;

public class MatrixProcessing {

    // Input matrix elements
    static void inputMatrix(Scanner sc, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    // Display matrix
    static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Check whether matrices can be added
    static boolean validateDimensions(int r1, int c1, int r2, int c2) {
        return r1 == r2 && c1 == c2;
    }

    // Add two matrices
    static int[][] addMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    // Calculate row totals
    static void rowTotals(int[][] matrix) {
        System.out.println("\nRow Totals:");

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                sum = sum + matrix[i][j];
            }

            System.out.println("Row " + (i + 1) + " = " + sum);
        }
    }

    // Calculate column totals
    static void columnTotals(int[][] matrix) {
        System.out.println("\nColumn Totals:");

        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;

            for (int i = 0; i < matrix.length; i++) {
                sum = sum + matrix[i][j];
            }

            System.out.println("Column " + (j + 1) + " = " + sum);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MATRIX PROCESSING SYSTEM =====");

        // Get dimensions
        System.out.print("Enter rows for first matrix: ");
        int r1 = sc.nextInt();

        System.out.print("Enter columns for first matrix: ");
        int c1 = sc.nextInt();

        System.out.print("Enter rows for second matrix: ");
        int r2 = sc.nextInt();

        System.out.print("Enter columns for second matrix: ");
        int c2 = sc.nextInt();

        // Validate dimensions
        if (!validateDimensions(r1, c1, r2, c2)) {
            System.out.println("\nMatrix addition is not possible.");
            System.out.println("Both matrices must have the same dimensions.");
            sc.close();
            return;
        }

        // Create matrices
        int[][] matrix1 = new int[r1][c1];
        int[][] matrix2 = new int[r2][c2];

        // Input first matrix
        System.out.println("\nEnter First Matrix:");
        inputMatrix(sc, matrix1);

        // Input second matrix
        System.out.println("\nEnter Second Matrix:");
        inputMatrix(sc, matrix2);

        // Display matrices
        System.out.println("\nFirst Matrix:");
        displayMatrix(matrix1);

        System.out.println("\nSecond Matrix:");
        displayMatrix(matrix2);

        // Add matrices
        int[][] result = addMatrices(matrix1, matrix2);

        // Display result
        System.out.println("\nResultant Matrix:");
        displayMatrix(result);

        // Calculate totals
        rowTotals(result);
        columnTotals(result);

        System.out.println("\n===== PROGRAM COMPLETED =====");

        sc.close();
    }
}