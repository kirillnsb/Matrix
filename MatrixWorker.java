package kirillnsb.matrixworker;

public class MatrixWorker implements IMatrixWorker {

    @Override
    public void print(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
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

    double[][] m;

    private double[][] getMinor(double A[][], int n, int p) {
        m = new double[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == p)
                    continue;
                m[i - 1][c] = A[i][j];
                c++;
            }
        }
        return m;
    }

    public double getDeterminant(double A[][]) {
        double res;
        int n = A.length;
        if (n == 1) res = A[0][0];//1x1
        else if (n == 2) res = A[0][0] * A[1][1] - A[1][0] * A[0][1];//2x2
        else {
            res = 0;
            for (int p = 0; p < n; p++) {
                m = getMinor(A, n, p);
                res += Math.pow(-1.0, 1.0 + p + 1.0) * A[0][p] * getDeterminant(m);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        double[][] m1 = {{1, 2, 3},
                {4, 3, 2}};

        double[][] m2 = {{3, 5},
                {1, 2},
                {3, 4}};

        double[][] c = {{2, -5, 1, 2},
                {-3, 7, -1, 4},
                {5, -9, 2, 7},
                {4, -6, 1, 2}};

        double[][] b = {{1, 2, 3},
                {3, 2, 1}, {1, 1, 1}};

        MatrixWorker mx = new MatrixWorker();

        System.out.println(mx.getDeterminant(c));


        /*Matrix mat1 = new Matrix(m1);                                          //
        Matrix mat2 = new Matrix(m1);                                          //
        Matrix mat3 = new Matrix(m2);                                          //
        System.out.println("mat1(m1) == mat2(m1) " + mat1.equals(mat2));       //
        System.out.println("mat1(m1) == mat3(m2) " + mat1.equals(mat3));       //equals check

        System.out.println("mat1.hashCode " + mat1.hashCode());        //
        System.out.println("  m1 hashCode " + Arrays.hashCode(m1));    //hashCode check

        System.out.println(mat1.toString());
*/
    }
}

