package kirillnsb.matrixworker;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;

    public Matrix(double[][] m) {
        this.matrix = m;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < matrix.length; i++) {
            str += "[";
            for (int j = 0; j < matrix[i].length; j++) {
                str += matrix[i][j] + ", ";
            }
            str += "\b\b]";
        }
        return str;
    }
}
