/**
 * This program implments TicTacToe using OOP
 * CPSC 312-01, Fall 2017
 * Programming Assignment #1
 * No sources to cite.
 * filename: Cell.java
 * @author Carter Riley
 * @version v1.0 9/14/17
 */

/*
 * Cell Class contains symbol for each coordinate
 */
public class Cell {
    Coordinates location;
    private char symbol;

    /**
     * Cell default value constructor sets the symbol for the current location
     * @return none
     */
    public Cell() {
        this.location = new Coordinates();
        this.symbol = '-';
    }

    /**
     * Cell explicit value constructor sets the symbol for the current location
     * @param location, playerSymbol
     * @return nothing
     */
    public Cell(Coordinates location, char playerSymbol) {
        this.location = location;
        this.symbol = playerSymbol;
    }

    /**
     * getSymbol returns the value for current Symbol
     * @return char
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * setSymbol sets the value for the current Symbol
     * @param piece symbol ('X' or 'O')
     * @return void
     */
    public void setSymbol(char piece) {
        symbol = piece;
    }

    /**
     * overridden toString function returns cell
     * @return Cell String
     */
    @Override
    public String toString() {
        String cellStr = "";
        cellStr += getSymbol();
        return cellStr;
    }

}
