package first.a;

public class Matrix {

	double[][] matrix;

	Matrix(int m, int n) {
		if (m < 0 || n < 0) {
			System.out.println("Error...keine negativen zahlen für m und n möglich");
		} else {
			matrix = new double[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0.0;
				}
			}
		}
	}

	public static String[][] toString(double[][] a) {
		String[][] string1 = new String[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				string1[i][j] = String.valueOf(a[i][j]);
		}
		return string1;
	}

	public static void printMatrix(String[][] s) {
		int i = 0, j = 0;
		for (i = 0; i < s.length; i++) {
			for (j = 0; j < s[0].length; j++) {
				System.out.print(" " + s[i][j]);
			}
			System.out.println();
		}
	}

	public void setValue(int i, int j, double x) {
		this.matrix[i - 1][j - 1] = x;
	}

	public void getValue(int i, int j) {
		System.out.println(this.matrix[i - 1][j - 1]);
	}

	public double[][] add(double[][] other) {
		if ((this.matrix.length == other.length) && (this.matrix[0].length == other[0].length))
			for (int i = 0; i < other.length; i++)
				for (int j = 0; j < other[0].length; j++)
					this.matrix[i][j] += other[i][j];
		else {
			System.out.println("Addition nicht möglich!");
		}
		return other;
	}
	public double[][] add(double[][] other, double [][] other1) {
		if ((this.matrix.length == other.length) && (this.matrix[0].length == other[0].length))
			for (int i = 0; i < other.length; i++)
				for (int j = 0; j < other[0].length; j++)
					this.matrix[i][j] += other[i][j];
		else {
			System.out.println("Addition nicht möglich!");
		}
		return other;
	}

	public double[][] multiply(double[][] other) {
		double[][] produkt = new double[this.matrix.length][other[0].length];
		double x = 0.0;
		if (this.matrix.length == other[0].length) {
			for (int spalte = 0; spalte < this.matrix.length; spalte++) {
				for (int zeile = 0; zeile < other[0].length; zeile++) {
					for (int k = 0; k < this.matrix[0].length; k++) {
						x = x + this.matrix[spalte][k] * other[k][zeile];
					}
					produkt[spalte][zeile] = x;
					x = 0.0;
				}
			}
		} else {
			System.out.println("Multiplikation nicht möglich!");
		}
		return produkt;
	}

	public static void main(String[] args) {

		Matrix matrix_test = new Matrix(5, 5);
		Matrix matrix_test2 = new Matrix(5, 5);
		matrix_test2.setValue(1,1,2);

		  matrix_test.setValue(1,1,2);
		  printMatrix(toString(matrix_test.matrix));
		 System.out.println();
		 double[][] summe = matrix_test.add(matrix_test2.matrix);
		  printMatrix(toString(summe));
		  matrix_test.getValue(1,1);

		  
		matrix_test.setValue(1, 5, -1);
		matrix_test.setValue(2, 1, 1);
		matrix_test.setValue(2, 5, -1);
		matrix_test.setValue(3, 2, 1);
		matrix_test.setValue(3, 5, 2);
		matrix_test.setValue(4, 3, 1);
		matrix_test.setValue(5, 4, 1);
		matrix_test.setValue(5, 5, 1);

		printMatrix(toString(matrix_test.matrix));
		System.out.println();

		double[][] produkt = matrix_test.multiply(matrix_test.matrix);
		printMatrix(toString(produkt));
		System.out.println();

		for (int i = 0; i < 18; i++) {
			produkt = matrix_test.multiply(produkt);
			printMatrix(toString(produkt));
			System.out.println();
		}
	}
}