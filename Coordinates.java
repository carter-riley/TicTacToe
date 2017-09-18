/**
 * This program implments TicTacToe using OOP
 * CPSC 312-01, Fall 2017
 * Programming Assignment #1
 * No sources to cite.
 * filename: Coordinates.java
 * @author Carter Riley
 * @version v1.0 9/14/17
 */

/*
 * Coordinates class displays coordinates as object with two integers
 */
public class Coordinates {
    private int row;
    private int col;

    /**
     * getRow returns the value for current Row coordinate
     * @return integer
     */
    public int getRow() {
        return row;
    }

    /**
     * setRow sets the value for the current Row coordinate
     * @param row coordinate
     * @return void
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * getCol returns the value for current Col coordinate
     * @return integer
     */
    public int getCol() {
        return col;
    }

    /**
     * setCol sets the value for the current Column coordinate
     * @param col column coordinate
     * @return void
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Coordinates default value constructor sets the value for the current Column coordinate
     * @return none
     */
    public Coordinates() {
        this.row = 0;
        this.col = 0;
    }

    /**
     * Coordinates explicit value constructor sets the value for the current Column coordinate
     * @param row, col column coordinate and int row coordinate
     * @return nothing
     */
    public Coordinates(int col, int row) {
        this.row = row;
        this.col = col;
    }

    /**
     * overridden toString function returns coordinates
     * @return Coordinate String
     */
    @Override
    public String toString() {
        String coordinatesStr = " ";
        coordinatesStr += "(" + this.col + ", " + this.row + ")";
        return coordinatesStr;
    }


}
