/**
 * This program implments TicTacToe using OOP
 * CPSC 312-01, Fall 2017
 * Programming Assignment #1
 * No sources to cite.
 * filename TicTacToeBoard.java
 * @author Carter Riley
 * @version v1.0 9/14/17
 */

/*
 * TicTacToeBoard Class contains the game board
 */
public class TicTacToeBoard {
    private int N;
    private Cell[][] grid;

    /**
     * getGrid returns the current grid
     * @return grid
     */
    public Cell[][] getGrid()
    {

        return grid;
    }

    /**
     * setGrid sets the value(s) for the current grid
     * @param grid of 2D Arrays
     * @return void
     */
    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    /**
     * TicTacToeBoard default value constructor sets the array for the board
     * @return none
     */
    public TicTacToeBoard() {
        grid = new Cell[N][N];
        this.N = 3;
        this.grid = new Cell[this.N][this.N];
    }

    /**
     * getGrid returns the current grid
     * @return grid
     */
    public int getN() {
        return N;
    }

    /**
     * setGrid sets the value of N
     * @param n of 2D Arrays
     * @return void
     */
    public void setN(int n) {
        N = n;
    }

    /**
     * TicTacToeBoard explicit value constructor sets the array for the board
     * @param size
     * @return nothing
     */
    public TicTacToeBoard(int size) {
        setN(size);
        grid = new Cell[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = new Cell();
            }
        }
        setGrid(grid);
    }

    /**
     * overridden toString function returns ticTacToeBoard
     * @return ticTacToeBoard String
     */
    @Override
    public String toString() {
        String ticTacToeBoardStr = " ";
        for(int k = 0; k < N; k++) {
            ticTacToeBoardStr += " " + k;
        }
        ticTacToeBoardStr += "\n";
        for(int i = 0; i < N; i++) {
            ticTacToeBoardStr += i;
            for(int j = 0; j < N; j++) {
                ticTacToeBoardStr += " " + grid[i][j];
            }
            ticTacToeBoardStr += "\n";
        }
        return ticTacToeBoardStr;
    }

    /**
     * isValidMove accepts the coordinate of a cell. Returns true if the coordinates are valid and the cell is unoccuppied; otherwise returns false.
     * @param location coordinates
     * @return boolean
     */
    public boolean isValidMove(Coordinates location) {
        Cell currCell = grid[location.getRow()][location.getCol()];
        char piece = currCell.getSymbol();
        if(piece == 'O' || piece == 'X') {
            return false;
        }
        return true;
    }

    /**
     * makeMove accepts the coordinates of a cell and a player’s symbol. Marks the cell with the symbol.
     * @param location coordinate, playerSymbol character
     * @return void
     */
    public void makeMove(Coordinates location, char playerSymbol) {
        Cell currCell = grid[location.getRow()][location.getCol()];
        currCell.setSymbol(playerSymbol);
    }

    /**
     * isWinner accepts a player symbol (‘X’ or ‘O’). Returns true if there are N in a row of the player’s symbol; otherwise returns false
     * @param playerSymbol character
     * @return boolean
     */
    public boolean isWinner(char playerSymbol) {
        int counterHorizontal = 0;
        int counterVertical = 0;
        int counterDiagonal = 0;

        // Horizontal
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Cell currCell = grid[i][j];
                char piece = currCell.getSymbol();
                if(piece == playerSymbol) {
                    counterHorizontal++;
                }
            }
            if(counterHorizontal == N) {
                return true;
            } else {
                counterHorizontal = 0;
            }
        }

        // Vertical
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Cell currCell = grid[i][j];
                char piece = currCell.getSymbol();
                if(piece == playerSymbol) {
                    counterVertical++;
                }
            }
            if(counterVertical == N) {
                return true;
            } else {
                counterVertical = 0;
            }
        }

        // Diagonal
        // Top Left to Bottom Right
        for(int j = 0; j < N; j++) {
            Cell currCell = grid[j][j];
            char piece = currCell.getSymbol();
            if(piece == playerSymbol) {
                counterDiagonal++;
            }
        }
        if(counterDiagonal == N) {
            return true;
        } else {
            counterDiagonal = 0;
        }

        // Bottom Left to Top Right
        for(int i = 0; i < N; i++) {
            for(int j = N - 1; j > 0; j--) {
                Cell currCell = grid[i][j];
                char piece = currCell.getSymbol();
                if (piece == playerSymbol) {
                    counterDiagonal++;
                }

            }
        }
        if(counterDiagonal == N) {
            return true;
        }
        return false;
    }
}
