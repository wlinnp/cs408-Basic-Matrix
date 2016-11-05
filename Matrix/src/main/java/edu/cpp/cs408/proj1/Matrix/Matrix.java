package edu.cpp.cs408.proj1.Matrix;

import edu.cpp.cs408.proj1.Operations.Addition;
import edu.cpp.cs408.proj1.Operations.Operator;
import edu.cpp.cs408.proj1.Operations.Subtraction;

/**
 * This is a nxn Matrix class.
 * <p>
 * This class can perform basic operations of addition, subtraction, and multiplication
 * <p>
 * The purpose of this class is to compare the performance with C++ class of the same logic
 * <p>
 * There are better algorithms on how to do multiplication such as Strassen's algorithm
 * but this class will use a classic method of looping 3 times with complexity of )O(n^3).
 * <p>
 * @author Wai Phyo
 */

public class Matrix implements IMatrix {
    private int size;
    private double[][] matrix;

    public Matrix(final int size) {
        if (size < 1) {
            throw new RuntimeException("Size cannot be less than 1");
        }
        this.size = size;
        matrix = new double[size][size];
    }

    public int getSize() {
        return size;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrixCell(final int i, final int j, final double value) {
        if (validDimension(i, j)) {
            matrix[i][j] = value;
        } else {
            throw new RuntimeException("Assigning at invalid cell.");
        }
    }

    private boolean validDimension(final int i, final int j) {
        return i > -1 && i < size && j > -1 && j < size;
    }

    public IMatrix add(final IMatrix right) {
        return operate(right, new Addition());
    }

    public IMatrix subtract(final IMatrix right) {
        return operate(right, new Subtraction());
    }

    private IMatrix operate(final IMatrix right, final Operator operator) {
        if (right.getSize() != size) {
            return null;
        }
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.setMatrixCell(i, j, operator.operate(matrix[i][j], right.getMatrix()[i][j]));
            }
        }
        return result;
    }

    public IMatrix multiply(IMatrix right) {
        if (right.getSize() != size) {
            return null;
        }
        Matrix result = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double cellResult = 0;
                for (int k = 0; k < size; k++) {
                    cellResult += matrix[i][k] * right.getMatrix()[j][k];
                }
                result.setMatrixCell(i, j, cellResult);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(NEXT_LINE_CHARACTER);
        for (double[] row : matrix) {
            for (double cell : row) {
                result.append(cell).append(TAB_CHARACTER);
            }
            result.append(NEXT_LINE_CHARACTER);
        }
        return result.toString();
    }
}
