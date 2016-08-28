package gol;

import java.util.Random;

class MatrixBuilder {
	private int X_LENGTH = 50;
	private int Y_LENGTH = 50;
	private int PRECISION = 1;

	private Random rand = new Random();

	private int[][] 
		board = new int[Y_LENGTH][X_LENGTH],
		tempBoard = new int[Y_LENGTH][X_LENGTH];

	private int generation = 0;

	public MatrixBuilder() {
		initializeBoard();
	}

	public MatrixBuilder(int xMax, int yMax, int precision) {
		X_LENGTH = xMax;
		Y_LENGTH = yMax;
		PRECISION = precision;
		board = new int[yMax][xMax];
		tempBoard = new int[yMax][xMax];
		initializeBoard();
	}

	public int[][] getInitialMatrix() {
		return board;
	}

	public int[][] nextGeneration() {
		int liveNeighbors = 0;
		for (int y = 0; y < Y_LENGTH; y++) {
			for (int x = 0; x < X_LENGTH; x++) {
				liveNeighbors = countLiveNeighbors(x, y);
				tempBoard[y][x] = setState(liveNeighbors, board[y][x]);
			}
		}
		copy2DArray(tempBoard, board);
		generation++;
		return board;
	}

	public int getGeneration() {
		return generation;
	}

	public int getXLength() {
		return X_LENGTH;
	}

	public int getYLength() {
		return Y_LENGTH;
	}

	private void copy2DArray(int[][] src, int[][] to) {
		for (int y = 0; y < Y_LENGTH; y++) {
			System.arraycopy(src[y], 0, to[y], 0, src[y].length);
		}
	}

	private void initializeBoard() {
		for (int y = 0; y < Y_LENGTH; y++) {
			for (int x = 0; x < X_LENGTH; x++) {
				if (y > ((Y_LENGTH - 1) / 2 - ((Y_LENGTH - 1) / PRECISION)) 
					&& y < ((Y_LENGTH - 1) / 2 + ((Y_LENGTH - 1) / PRECISION))
					&& x > ((X_LENGTH - 1) / 2 - ((X_LENGTH - 1) / PRECISION)) 
					&& x < ((X_LENGTH - 1) / 2 + ((X_LENGTH - 1) / PRECISION))) {
					board[y][x] = rand.nextInt(2);
				}
				//board[y][x] = 0;
			}
		}
		// glider gun
		/*board[1][25] = 1; board[2][23] = 1; board[2][25] = 1; board[3][13] = 1; board[3][14] = 1;
		board[3][21] = 1; board[3][22] = 1; board[3][35] = 1; board[3][36] = 1; board[4][12] = 1;
		board[4][16] = 1; board[4][21] = 1; board[4][22] = 1; board[4][35] = 1; board[4][36] = 1;
		board[5][1] = 1; board[5][2] = 1; board[5][11] = 1; board[5][17] = 1; board[5][21] = 1;
		board[5][22] = 1; board[6][1] = 1; board[6][2] = 1; board[6][11] = 1; board[6][15] = 1;
		board[6][17] = 1; board[6][18] = 1; board[6][23] = 1; board[6][25] = 1; board[7][11] = 1;
		board[7][17] = 1; board[7][25] = 1; board[8][12] = 1; board[8][16] = 1; board[9][13] = 1;
		board[9][14] = 1;*/
	}

	private int countLiveNeighbors(int xPos, int yPos) {
		int count = 0;
		int state = 0;
		for (int i = 0; i <= 7; i++) {
			try {
				switch(i) {
					case 0 :
						state = board[yPos - 1][xPos - 1];
						break;
					case 1 :
						state = board[yPos - 1][xPos];
						break;
					case 2 : 
						state = board[yPos - 1][xPos + 1];
						break;
					case 3 :
						state = board[yPos][xPos - 1];
						break;
					case 4 : 
						state = board[yPos][xPos + 1];
						break;
					case 5 :
						state = board[yPos + 1][xPos - 1];
						break;
					case 6 :
						state = board[yPos + 1][xPos];
						break;
					case 7 : 
						state = board[yPos + 1][xPos + 1];
						break;
					default :
						break;
				}
				if (state == 1) {
					count++;
				}
			}	catch(ArrayIndexOutOfBoundsException e) {
				// do nothing
			}
		}
		return count;
	}

	private int setState(int liveNeighbors, int currentState) {
		int state = 0;
		if (liveNeighbors < 2) {
			state = 0;
		}	else if(liveNeighbors > 3) {
			state = 0;
		}	else if(currentState == 0 && liveNeighbors == 3) {
			state = 1;
		}	else if(liveNeighbors == 2 || liveNeighbors == 3) {
			state = currentState;
		}
		return state;
	}
}
