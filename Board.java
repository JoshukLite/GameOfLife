package gol;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Timer;
import java.util.TimerTask;

class Board extends JPanel {
	private int RECT_WIDTH = 10;
	private int RECT_HEIGHT = 10;

	private MatrixBuilder matrixBuilder;
	private int matrixXLength = 0;
	private int matrixYLength = 0;

	private int[][] matrix = null;
	private Rectangle[][] rectMatrix;

	private String genPop = "Generation : %1$d      Population : %2$d";

	private Timer timer;

	public Board(MatrixBuilder matrixBuilder) {
		this.matrixBuilder = matrixBuilder;
		initializeData();
		rectMatrix = new Rectangle[matrixYLength][matrixXLength];
		initBoard();
	}

	public Board(MatrixBuilder matrixBuilder, int cellWidthAndHeight) {
		this.matrixBuilder = matrixBuilder;
		RECT_WIDTH = cellWidthAndHeight;
		RECT_HEIGHT = cellWidthAndHeight;
		initializeData();
		rectMatrix = new Rectangle[matrixYLength][matrixXLength];
		initBoard();
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(RECT_WIDTH * (matrixXLength + 1), 
			RECT_HEIGHT * (matrixYLength + 1) + 15);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(RECT_WIDTH * (matrixXLength + 1), 
			RECT_HEIGHT * (matrixYLength + 1) + 15);
	}
	
	@Override
	public Dimension getMaximumSize() {
		return new Dimension(RECT_WIDTH * (matrixXLength + 1), 
			RECT_HEIGHT * (matrixYLength + 1) + 15);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
			RenderingHints.VALUE_RENDER_SPEED);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
			RenderingHints.VALUE_COLOR_RENDER_SPEED);
		int state = 0;
		int xPos = 0;
		int yPos = 0;
		int population = 0;
		for (int y = 0; y < matrixYLength; y++) {
			for (int x = 0; x < matrixXLength; x++) {
				state = matrix[y][x];
				if (state == 0) {
					g2d.setPaint(Color.WHITE);
				}	else {
					population++;
					g2d.setPaint(Color.BLACK);
				}
				g2d.fill(rectMatrix[y][x]);
			}
		}
		g2d.setPaint(Color.BLACK);
		g2d.drawString(String.format(genPop, matrixBuilder.getGeneration(), population), 
			20, RECT_HEIGHT * (matrixYLength + 1) + 10);
		g2d.dispose();
	}

	private void initBoard() {
		for (int y = 0; y < matrixYLength; y++) {
			for (int x = 0; x < matrixXLength; x++) {
				rectMatrix[y][x] = new Rectangle(
					x * RECT_WIDTH, y * RECT_HEIGHT,
					RECT_WIDTH, RECT_HEIGHT);
			}
		}
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 0, 50);
	}

	private void initializeData() {
		matrix = matrixBuilder.getInitialMatrix();
		matrixXLength = matrixBuilder.getXLength();
		matrixYLength = matrixBuilder.getYLength();
	}

	private class ScheduleTask extends TimerTask {
		@Override
		public void run() {
			matrix = matrixBuilder.nextGeneration();
			repaint();
		}
	}
}