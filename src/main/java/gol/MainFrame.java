package gol;

import java.awt.BorderLayout;
import javax.swing.JFrame;

class MainFrame extends JFrame {
	private Board board;
	
	public MainFrame() {
		board = new Board(new MatrixBuilder());
		initUI();
	}

	public MainFrame(int mWidth, int mHeight) {
		board = new Board(new MatrixBuilder(mWidth, mHeight, 1));
		initUI();
	}

	public MainFrame(int mWidth, int mHeight, int cellWidthAndHeight) {
		board = new Board(new MatrixBuilder(mWidth, mHeight, 1), cellWidthAndHeight);
		initUI();
	}

	public MainFrame(int mWidth, int mHeight, int cellWidthAndHeight, int precision) {
		board = new Board(new MatrixBuilder(mWidth, mHeight, precision), cellWidthAndHeight);
		initUI();
	}

	private void initUI() {
		setLayout(new BorderLayout());
		add(board);
		setTitle("Game Of Life");

		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
