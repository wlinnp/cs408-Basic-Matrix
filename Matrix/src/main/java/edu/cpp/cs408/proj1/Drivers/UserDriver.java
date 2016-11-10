package edu.cpp.cs408.proj1.Drivers;

import edu.cpp.cs408.proj1.Matrix.Matrix;

import java.util.Scanner;

/**
 * Menu for basic menu operations
 * <p>
 * @author Wai Phyo
 */
public class UserDriver {
    private Scanner scanner = new Scanner(System.in);
    private int matrixSize = 0;
    private Matrix matrixA;
    private Matrix matrixB;

    public UserDriver () {
        showMainMenu();
    }

    private void showMainMenu() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("Welcome to basic Matrix Operations");
            System.out.println("Enter 0 to quit or other integer as matrix size");
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    repeat = false;
                    break;
                default:
                    matrixSize = input;
                    fillMatrices();
                    operationMenu();
                    break;
            }
        }
    }

    private void fillMatrices() {
        if (matrixSize < 1) {
            throw new RuntimeException("Invalid matrix size");
        }
        matrixA = new Matrix(matrixSize);
        matrixB = new Matrix(matrixSize);
        System.out.println("For first matrix");
        fillSingleMatrix(matrixA, matrixSize);
        System.out.println("For second matrix");
        fillSingleMatrix(matrixB, matrixSize);
    }

    private void fillSingleMatrix(final Matrix matrix, int size) {
        size *= size;
        while (size > 0) {
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    System.out.println("Enter value for cell [" + i +"][" + j + "]");
                    matrix.setMatrixCell(i, j, scanner.nextInt());
                    size--;
                }
            }
        }
    }

    private void operationMenu() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("Enter 1 to add those 2 matrices");
            System.out.println("Enter 2 to subtract those 2 matrices");
            System.out.println("Enter 3 to multiply those 2 matrices");
            System.out.println("Enter 0 to go back to main menu");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println((matrixA.add(matrixB)).toString());
                    break;
                case 2:
                    System.out.println((matrixA.subtract(matrixB)).toString());
                    break;
                case 3:
                    System.out.println((matrixA.multiply(matrixB)).toString());
                    break;
                case 0:
                    repeat = false;
                    break;
                default:
                    System.out.println("Invalid choice. try again");
                    break;
            }
        }
    }
}
