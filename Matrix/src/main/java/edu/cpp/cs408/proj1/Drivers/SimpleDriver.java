package edu.cpp.cs408.proj1.Drivers;

import edu.cpp.cs408.proj1.Matrix.IMatrix;
import edu.cpp.cs408.proj1.Matrix.Matrix;

/**
 * @author Wai Phyo
 */
public class SimpleDriver {
    private static double[] array1;
    private static double[] array2;
    private static int size;
    private IMatrix left;
    private IMatrix right;
    private static SimpleDriver INSTANCE;

    private SimpleDriver() {
        array1 = new double[] {1.0, 2.0, 3.0, 4.0, 5.0,2.0, 2.0, 2.0, 2.0, 2.0, 3.0, 1.0, 1.0, 1.0, 3.0,0.0, 0.0, 2.0, 3.0, -2.0, 4.0, 4.0, -4.0, 0.0, 0.0};
        array2 = new double[] {1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 2.0, 1.0, 2.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, -2.0, 2.0, 2.0};
        size = 5;
        setMatrixes();
    }

    private void setMatrixes() {
        left = new Matrix(5);
        right = new Matrix(5);
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left.setMatrixCell(i, j, array1[counter]);
                right.setMatrixCell(i, j, array2[counter]);
                counter++;
            }
        }
    }

    public static SimpleDriver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleDriver();
        }
        return INSTANCE;
    }

    public String showLeft() {
        return left.toString();
    }

    public String showRight() {
        return right.toString();
    }

    public String performAddition() {
        return left.add(right).toString();
    }

    public String performSubtraction() {
        return left.subtract(right).toString();
    }

    public String performMultiplication() {
        return left.multiply(right).toString();
    }
}
