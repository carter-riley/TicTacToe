/**
 * This program implments TicTacToe using OOP
 * CPSC 312-01, Fall 2017
 * Programming Assignment #1
 * No sources to cite.
 * filename TicTacToeTester.java
 * @author Carter Riley
 * @version v1.0 9/14/17
 */

import java.util.Scanner;

/**
 * TicTacToeTester class contains main method for project
 */
public class TicTacToeTester {
    /**
     * Main method that calls the TicTacToeBoard class and contains several loops for the game state
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        boolean repeat = true;
        int xWins = 0;
        int oWins = 0;
        int scratch = 0;
        int numOfGames = 0;
        boolean gameState = true;
        char currentPlayerSymbol;
        int moveCounter;
        int N = 0;

        System.out.println("Welcome to Tic Tac Toe! There are two players, player 'X' and player 'O'.");

        while(repeat) {
            int num;
            boolean inValidInput = true;
            numOfGames++;
            while(inValidInput) {
                System.out.println("Please enter the dimension, N, of the NxN Tic Tac Toe board (an integer in [3, 9]): ");
                Scanner number = new Scanner(System.in);
                num = number.nextInt();
                if(num >= 3 && num <= 9) {
                    inValidInput = false;
                    N = num;
                } else {
                    System.out.println("That was an invalid input for dimension.");
                }
            }
            moveCounter = 0;
            // Player X is going first.
            System.out.println("Player X is going first.");
            // Print empty board with accurate dimensions
            TicTacToeBoard gameBoard = new TicTacToeBoard(N);
            System.out.println(gameBoard);

            while(gameState) {
                currentPlayerSymbol = 'X';
                inValidInput = true;
                while(inValidInput) {
                    System.out.print("Player X, please enter the Coordinates of your placement: ");
                    Scanner locationX = new Scanner(System.in);
                    String newLocX = locationX.nextLine();
                    String numbers [] = newLocX.split(" ");
                    int newRow = Integer.parseInt(numbers[0]);
                    int newCol = Integer.parseInt(numbers[1]);
                    Coordinates location = new Coordinates(newRow, newCol);
                    if(newRow >= N || newCol >= N) {
                        System.out.println(newLocX + " is not a valid move!");
                        break;
                    }
                    if(gameBoard.isValidMove(location)) {
                        gameBoard.makeMove(location, currentPlayerSymbol);
                        inValidInput = false;
                    } else {
                        System.out.println(newLocX + " is not a valid move!");
                    }
                }
                System.out.println(gameBoard);
                // Check if X won or Scratch game
                if(gameBoard.isWinner(currentPlayerSymbol)) {
                    xWins++;
                    System.out.println("X Won!");
                    break;
                }
                moveCounter++;
                if(moveCounter == N * N) {
                    scratch++;
                    System.out.println("Scratch game, too bad.");
                    break;
                }

                currentPlayerSymbol = 'O';
                inValidInput = true;
                while(inValidInput) {
                    System.out.print("Player O, please enter the Coordinates of your placement: ");
                    Scanner locationO = new Scanner(System.in);
                    String newLocO = locationO.nextLine();
                    String numbers [] = newLocO.split(" ");
                    int newRow = Integer.parseInt(numbers[0]);
                    int newCol = Integer.parseInt(numbers[1]);
                    Coordinates location = new Coordinates(newRow, newCol);

                    if(gameBoard.isValidMove(location)) {
                        gameBoard.makeMove(location, currentPlayerSymbol);
                        inValidInput = false;
                    } else {
                        System.out.println(newLocO + " is not a valid move!");
                    }
                }
                System.out.println(gameBoard);

                // Check if O won or scratch game
                if(gameBoard.isWinner(currentPlayerSymbol)) {
                    oWins++;
                    System.out.println("O Won!");

                    break;
                }
                moveCounter++;
                if(moveCounter == N * N) {
                    scratch++;
                    System.out.println("Scratch game, too bad.");
                    break;
                }

            }
            //After game has ended, play again?
            int input;
            System.out.println("Would you like to play again? Enter '1' to play or '0' to quit: ");
            Scanner number = new Scanner(System.in);
            input = number.nextInt();
            if(input == 0) {
                break;
            }
        }
        // End game stats
        System.out.println("Player X game stats");
        System.out.println("-------------------");
        System.out.println("Win to loss ratio: " + xWins + ":" + oWins);
        System.out.println("Win percentage: " + xWins * 100 / numOfGames + "%");
        System.out.println("Number of scratch games: " + scratch);
        System.out.println("");
        System.out.println("Player O game stats");
        System.out.println("-------------------");
        System.out.println("Win to loss ratio: " + oWins + ":" + xWins);
        System.out.println("Win percentage: " + oWins * 100 / numOfGames + " %");
        System.out.println("Number of scratch games: " + scratch);
    }
}
