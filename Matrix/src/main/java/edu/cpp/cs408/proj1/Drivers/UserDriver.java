package edu.cpp.cs408.proj1.Drivers;

import edu.cpp.cs408.proj1.Matrix.IMatrix;
import edu.cpp.cs408.proj1.Matrix.Matrix;

import java.util.Scanner;

/**
 * Menu for basic menu operations
 * <p>
 * @author Wai Phyo
 */
public class UserDriver extends Driver {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
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
                    size = input;
                    fillMatrices();
                    operationMenu();
                    break;
            }
        }
    }

    private void fillMatrices() {
        if (size < 1) {
            throw new RuntimeException("Invalid matrix size");
        }
        left = new Matrix(size);
        right = new Matrix(size);
        System.out.println("For first matrix");
        fillSingleMatrix(left, size);
        System.out.println("For second matrix");
        fillSingleMatrix(right, size);
    }

    private void fillSingleMatrix(final IMatrix matrix, int size) {
        size *= size;
        while (size > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.println("Enter value for cell [" + i +"][" + j + "]");
                    matrix.setMatrixCell(i, j, scanner.nextDouble());
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
                    System.out.println((left.add(right)).toString());
                    break;
                case 2:
                    System.out.println((left.subtract(right)).toString());
                    break;
                case 3:
                    System.out.println((left.multiply(right)).toString());
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
