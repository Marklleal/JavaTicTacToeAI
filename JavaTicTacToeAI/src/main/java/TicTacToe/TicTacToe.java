package TicTacToe;

public class TicTacToe {

    private static final int SIZE = 3;
    private final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[SIZE][SIZE];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    public final void resetGame() {
    	initializeBoard();
    	currentPlayer = 'X';
    }

    public final void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkForWin() {
        // Checks rows, columns and diagonals
        return (checkRowsAndColumns() || checkDiagonals());
    }
    
    private boolean checkRowsAndColumns() {
    	for (int i = 0; i < SIZE; i++) {
    		if (checkRowCol(board[i][0], board[i][1], board[i][2]) || checkRowCol(board[0][i], board[1][i], board[2][i])) {
    			return true;
    		}
    	}
    	return false;
    }

    private boolean checkDiagonals() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) ||
                (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

	public char getCurrentPlayer() {
		return currentPlayer;
	}
}