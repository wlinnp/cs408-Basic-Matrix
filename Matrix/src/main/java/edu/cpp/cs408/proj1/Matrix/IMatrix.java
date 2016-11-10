package edu.cpp.cs408.proj1.Matrix;

/**
 * @author Wai Phyo
 */
public interface IMatrix {
    public void setMatrixCell(final int i, final int j, final double value);
    public IMatrix add(final IMatrix right);
    public IMatrix subtract(final IMatrix right);
    public IMatrix multiply(final IMatrix right);
    public int getSize();
    public double[][] getMatrix();
}
