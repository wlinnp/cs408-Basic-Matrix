package edu.cpp.cs408.proj1.Drivers.Executor;

import edu.cpp.cs408.proj1.Matrix.IMatrix;

/**
 * @author Wai Phyo
 */
public class ProductExecutor implements IExecutor {
    public void execute(IMatrix left, IMatrix right) {
        left.multiply(right);
    }
}
