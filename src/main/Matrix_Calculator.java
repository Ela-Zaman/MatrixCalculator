/**
	 * Launch the application.
	 */
package main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.StringTokenizer;

public class Matrix_Calculator extends JFrame {

	private static final long serialVersionUID = 1L;

	private static int decimals = 3;

	private static NumberFormat nf;
	private JPanel contentPane;

	

	public Matrix_Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea MatrixA = new JTextArea();
		MatrixA.setBackground(Color.WHITE);
		MatrixA.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		MatrixA.setForeground(Color.BLUE);
		MatrixA.setBounds(44, 27, 113, 207);
		contentPane.add(MatrixA);
		JTextArea Output = new JTextArea();
		Output.setBackground(Color.WHITE);
		Output.setForeground(Color.BLUE);
		Output.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		Output.setBounds(569, 27, 200, 457);
		contentPane.add(Output);

		JButton btnDeterminant = new JButton("Determinant(A)");
		btnDeterminant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Output.setText("Determinant (A): \n"
							+ nf.format(determinantOfMatrix(
									readInMatrix(MatrixA),
									readInMatrix(MatrixA).length)));
				} catch (Exception e) {
					Output.setText("Error: \n Incompatible Matrix");
				}
			}
		});
		btnDeterminant.setForeground(Color.BLUE);
		btnDeterminant.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnDeterminant.setBounds(187, 245, 140, 75);
		contentPane.add(btnDeterminant);

		JButton btnAdjoint = new JButton("Adjoint(A)");
		btnAdjoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					displayMatrix(adjointOfMatrix(readInMatrix(MatrixA)),
							Output);
				} catch (Exception e) {
					Output.setText("Error: \n Incompatible Matrix");
				}
			}
		});
		btnAdjoint.setForeground(Color.BLUE);
		btnAdjoint.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnAdjoint.setBounds(187, 361, 140, 75);
		contentPane.add(btnAdjoint);

		JButton btnTranspose = new JButton("Transpose(A)");
		btnTranspose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					displayMatrix(transposeMatrix(readInMatrix(MatrixA)),
							Output);
				} catch (Exception e) {
					Output.setText("Error: \n Incompatible Matrix");
				}
			}

		});
		btnTranspose.setForeground(Color.BLUE);
		btnTranspose.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnTranspose.setBounds(187, 35, 140, 75);
		contentPane.add(btnTranspose);

		JButton btnInverse = new JButton("Inverse(A)");
		btnInverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					displayMatrix(inverseMatrix(readInMatrix(MatrixA)), Output);
				} catch (Exception e) {
					Output.setText("Error: \n Incompatible Matrix");
				}
			}
		});
		btnInverse.setForeground(Color.BLUE);
		btnInverse.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnInverse.setBounds(187, 150, 140, 75);
		contentPane.add(btnInverse);

		JTextArea MatrixB = new JTextArea();
		MatrixB.setBackground(Color.WHITE);
		MatrixB.setForeground(Color.BLUE);
		MatrixB.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		MatrixB.setBounds(44, 267, 113, 217);
		contentPane.add(MatrixB);

		JButton btnAdd = new JButton("A+B");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					displayMatrix(
							addMatrix(readInMatrix(MatrixA),
									readInMatrix(MatrixB)), Output);
				} catch (Exception e) {
					Output.setText("Error: \n Incompatible Matrix");
				}

			}
		});
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		btnAdd.setBounds(359, 66, 129, 75);
		contentPane.add(btnAdd);

		JButton btnSubtract = new JButton("A-B");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					displayMatrix(
							subtractMatrix(readInMatrix(MatrixA),
									readInMatrix(MatrixB)), Output);
				} catch (Exception e) {
					Output.setText("Error: \n Incompatible Matrix");
				}

			}
		});
		btnSubtract.setForeground(Color.BLUE);
		btnSubtract.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		btnSubtract.setBounds(359, 199, 129, 75);
		contentPane.add(btnSubtract);

		JButton btnMultiply = new JButton("A*B");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					displayMatrix(
							multiplyMatrix(readInMatrix(MatrixA),
									readInMatrix(MatrixB)), Output);
				} catch (Exception e) {
					Output.setText("Error: \n Incompatible Matrix");
				}
			}
		});
		btnMultiply.setForeground(Color.BLUE);
		btnMultiply.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		btnMultiply.setBounds(359, 334, 129, 75);
		contentPane.add(btnMultiply);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setText("  Matrix A");
		textArea.setForeground(Color.BLUE);
		textArea.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		textArea.setBounds(44, 0, 113, 30);
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setText("  Matrix B");
		textArea_1.setForeground(Color.BLUE);
		textArea_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		textArea_1.setBounds(44, 232, 113, 43);
		contentPane.add(textArea_1);

		JTextArea txtrOutput = new JTextArea();
		txtrOutput.setBackground(Color.WHITE);
		txtrOutput.setText("          Output");
		txtrOutput.setForeground(Color.BLUE);
		txtrOutput.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		txtrOutput.setBounds(569, 0, 200, 30);
		contentPane.add(txtrOutput);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Matrix_Calculator.class
				.getResource("/images/800px_COLOURBOX12992284.jpg")));
		lblNewLabel.setBounds(0, 0, 769, 497);
		contentPane.add(lblNewLabel);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matrix_Calculator frame = new Matrix_Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(1);
		nf.setMaximumFractionDigits(decimals);
	}

	public double[][] readInMatrix(JTextArea ta) throws Exception {

		/* == Parse Text Area == */
		String rawtext = ta.getText();

		/* == Determine Matrix Size/Valid == */
		StringTokenizer ts = new StringTokenizer(rawtext, "\n");

		double matrix[][] = new double[ts.countTokens()][];

		StringTokenizer st2;
		int row = 0;
		int col = 0;
		// making sure rows are same length
		int last = -5;
		int curr = -5;
		while (ts.hasMoreTokens()) {
			st2 = new StringTokenizer(ts.nextToken(), " ");
			last = curr;
			curr = st2.countTokens();
			if (last != -5 && curr != last)
				throw new Exception("Rows not of equal length");

			matrix[row] = new double[st2.countTokens()];
			while (st2.hasMoreElements()) {
				matrix[row][col++] = Float.parseFloat(st2.nextToken());
			}
			row++;
			col = 0;
		}

		return matrix;
	}

	// --------------------------------------------------------------
	// Display Matrix in TextArea
	// --------------------------------------------------------------
	public void displayMatrix(double[][] matrix, JTextArea ta) {

		/* == TODO: Better Formatting of Resultant Matrix == */

		String rstr = "";
		String dv = "";

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				dv = nf.format(matrix[i][j]);
				rstr = rstr.concat(dv + "  ");
			}

			rstr = rstr.concat("\n");
		}

		ta.setText(rstr);
	}

	public double[][] transposeMatrix(double[][] a) {

		double m[][] = new double[a[0].length][a.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				m[j][i] = a[i][j];

			}

		}
		return m;
	}

	public double determinantOfMatrix(double[][] a, int N) throws Exception {

		double det = 0;

		int columns = a[0].length;
		int rows = a.length;
		if (columns != rows) {
			throw new Exception("Matrix incompatible for determinant");

		}

		if (N == 1) {
			det = a[0][0];
		} else if (N == 2) {
			det = a[0][0] * a[1][1] - a[1][0] * a[0][1];
		} else {
			det = 0;
			for (int j1 = 0; j1 < N; j1++) {
				double[][] m = new double[N - 1][];
				for (int k = 0; k < (N - 1); k++) {
					m[k] = new double[N - 1];
				}
				for (int i = 1; i < N; i++) {
					int j2 = 0;
					for (int j = 0; j < N; j++) {
						if (j == j1)
							continue;
						m[i - 1][j2] = a[i][j];
						j2++;
					}
				}
				det += Math.pow(-1.0, 1.0 + j1 + 1.0) * a[0][j1]
						* determinantOfMatrix(m, N - 1);
			}
		}
		return det;

	}

	public double[][] adjointOfMatrix(double[][] a) throws Exception {

		int tms = a.length;
		int columns = a[0].length;
		int rows = a.length;
		if (columns != rows) {
			throw new Exception("Matrix incompatible for inverse");

		}

		double adjMat[][] = new double[tms][tms];

		int ii, jj, ia, ja;
		double det;

		for (int i = 0; i < tms; i++)
			for (int j = 0; j < tms; j++) {
				ia = ja = 0;

				double ap[][] = new double[tms - 1][tms - 1];

				for (ii = 0; ii < tms; ii++) {
					for (jj = 0; jj < tms; jj++) {

						if ((ii != i) && (jj != j)) {
							ap[ia][ja] = a[ii][jj];
							ja++;
						}

					}
					if ((ii != i) && (jj != j)) {
						ia++;
					}
					ja = 0;
				}

				det = determinantOfMatrix(ap, ap.length);
				adjMat[i][j] = (double) Math.pow(-1, i + j) * det;
			}

		adjMat = transposeMatrix(adjMat);

		return adjMat;

	}

	public double[][] inverseMatrix(double[][] a) throws Exception {

		int tms = a.length;
		int columns = a[0].length;
		int rows = a.length;
		if (columns != rows) {
			throw new Exception("Matrix incompatible for inverse");

		}

		double m[][] = new double[tms][tms];

		// Formula used to Calculate Inverse:
		// inv(A) = 1/det(A) * adj(A)

		double mm[][] = adjointOfMatrix(a);

		double det = determinantOfMatrix(a, a.length);
		double dd = 0;

		if (det == 0) {
			throw new Exception("Determinant Equals 0, Not Invertible.");

		} else {
			dd = 1 / det;
		}

		for (int i = 0; i < tms; i++) {
			for (int j = 0; j < tms; j++) {
				m[i][j] = dd * mm[i][j];
			}
		}

		return m;

	}

	public double[][] addMatrix(double[][] a, double[][] b) throws Exception {
		int tms = a.length;
		int rms = a[0].length;
		int tmsB = b.length;
		if (tms != tmsB) {
			throw new Exception("Matrices incompatible for Addition");
		}

		double matrix[][] = new double[tms][rms];

		for (int i = 0; i < tms; i++)
			for (int j = 0; j < rms; j++) {
				matrix[i][j] = a[i][j] + b[i][j];
			}

		return matrix;
	}

	public double[][] subtractMatrix(double[][] a, double[][] b)
			throws Exception {
		int tms = a.length;
		int rms = a[0].length;
		int tmsB = b.length;
		if (tms != tmsB) {
			throw new Exception("Matrices incompatible for Subtraction");
		}

		double matrix[][] = new double[tms][rms];

		for (int i = 0; i < tms; i++)
			for (int j = 0; j < tms; j++) {
				matrix[i][j] = a[i][j] - b[i][j];
			}

		return matrix;
	}

	public double[][] multiplyMatrix(double[][] a, double[][] b)
			throws Exception {

		if (a[0].length != b.length)
			throw new Exception("Matrices incompatible for multiplication");
		double matrix[][] = new double[a.length][b[0].length];

		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b[i].length; j++)
				matrix[i][j] = 0;

		// cycle through answer matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = calculateRowColumnProduct(a, i, b, j);
			}
		}
		return matrix;
	}

	public double calculateRowColumnProduct(double[][] A, int row,
			double[][] B, int col) {
		double product = 0;
		for (int i = 0; i < A[row].length; i++)
			product += A[row][i] * B[i][col];
		return product;
	}

}
