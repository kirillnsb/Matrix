package matrixworker;

import java.util.Arrays;

public class Matrix implements IMatrixWorker {
    private double[][] matrix;

    public Matrix() {
    }

    public Matrix(double[][] m) {
        this.matrix = m;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    @Override
    public void print(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        return m1.length == m2.length && m1[0].length == m2[0].length;
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2) {
        double[][] c = new double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                c[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return c;
    }

    @Override
    public double[][] subtract(double[][] m1, double[][] m2) { //m1 - m2
        double[][] c = new double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                c[i][j] = m1[i][j] - m2[i][j];
            }
        }
        return c;
    }

    @Override
    public double[][] multiply(double[][] m1, double[][] m2) { // m1 * m2
        double[][] c = null;
        if (m1[0].length == m2.length) {                 //conformity check
            c = new double[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; ++i) {
                for (int k = 0; k < m2[0].length; ++k) {
                    for (int j = 0; j < m1[0].length; j++) {
                        c[i][k] += m1[i][j] * m2[j][k];
                    }
                }
            }
        }
        return c;
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
    public String toString() { //custom toString
        String str="";
        for (int i = 0; i < matrix.length; i++) {
            str += "[";
            for (int j = 0; j < matrix[i].length; j++) {
                str += matrix[i][j] + ", ";
            }
            str += "\b\b]";
        }
        return str;
    }

/* default IDE toString version
    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
*/
    /*
    public static void main(String[] args) {

        double[][] m1 = {{1, 2, 3},
                         {4, 3, 2}};

        double[][] m2 = {{3, 5},
                         {1, 2},
                         {3, 4}};

        Matrix mat1 = new Matrix(m1);                                          //
        Matrix mat2 = new Matrix(m1);                                          //
        Matrix mat3 = new Matrix(m2);                                          //
        System.out.println("mat1(m1) == mat2(m1) " + mat1.equals(mat2));       //
        System.out.println("mat1(m1) == mat3(m2) " + mat1.equals(mat3));       //equals check

        System.out.println("mat1.hashCode " + mat1.hashCode());        //
        System.out.println("  m1 hashCode " + Arrays.hashCode(m1));    //hashCode check

        System.out.println(mat1.toString());

    }
    */
}

