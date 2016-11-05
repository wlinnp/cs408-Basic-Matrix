package edu.cpp.cs408.proj1.Drivers;

import edu.cpp.cs408.proj1.Drivers.Executor.AddExecutor;
import edu.cpp.cs408.proj1.Drivers.Executor.IExecutor;
import edu.cpp.cs408.proj1.Drivers.Executor.ProductExecutor;
import edu.cpp.cs408.proj1.Drivers.Executor.SubtractExecutor;
import edu.cpp.cs408.proj1.Matrix.IMatrix;
import edu.cpp.cs408.proj1.Matrix.Matrix;

/**
 * @author Wai Phyo
 */
public class AdvancedDriver {
    private static AdvancedDriver INSTANCE;
    private static final int START = 1000;
    private static final int END = 2001;
    private static final int LOWER_BOUND = -10;
    private static final int UPPER_BOUND = 10;
    private IMatrix left;
    private IMatrix right;
    private Utils utils;

    private AdvancedDriver() {
        utils = Utils.getInstance();
    }

    public static AdvancedDriver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdvancedDriver();
        }
        return INSTANCE;
    }

    public String performanceTest() {
        StringBuilder result = new StringBuilder("Performance Test\n");
        for (int i = START; i < END; i += 100) {
            result.append("for size: ").append(i).append(IMatrix.NEXT_LINE_CHARACTER);
            createMatrixes(i);
            result.append("addition: ").append(testPerformance(new AddExecutor())).append(IMatrix.NEXT_LINE_CHARACTER);
            result.append("subtraction: ").append(testPerformance(new SubtractExecutor())).append(IMatrix.NEXT_LINE_CHARACTER);
            result.append("multiplication: ").append(testPerformance(new ProductExecutor())).append(IMatrix.NEXT_LINE_CHARACTER);
            result.append(IMatrix.NEXT_LINE_CHARACTER);
        }
        return result.toString();
    }

    private long testPerformance(final IExecutor executor) {
        long startTime = System.nanoTime();
        executor.execute(left, right);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private void createMatrixes(final int size) {
        left = new Matrix(size);
        right = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                left.setMatrixCell(i, j, utils.getRandom(LOWER_BOUND, UPPER_BOUND));
                right.setMatrixCell(i, j, utils.getRandom(LOWER_BOUND, UPPER_BOUND));
            }
        }
    }
}
