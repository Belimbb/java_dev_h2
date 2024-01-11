import java.util.Random;
import java.util.Scanner;

public class Game {
    private boolean isGameActive;
    private byte winner = 0;
    private char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private boolean isBoxEmpty = false;


    public void startGame() {
        initializeGame();
        while (isGameActive) {
            playerTurn();
            if (checkForWinner('X')) {
                winner = 1;
                break;
            }
            if (isDraw()) {
                winner = 3;
                break;
            }
            computerTurn();
            if (checkForWinner('O')) {
                winner = 2;
                break;
            }
        }
        printResult();
    }

    private void initializeGame() {
        isGameActive = true;
        winner = 0;
        isBoxEmpty = false;
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("You are 'X' and the computer is 'O'.");
        System.out.println("Enter a number from 1 to 9 to choose a box.");
        printBox();  //Displaying the playing field
    }


    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        System.out.println("Your turn. Enter a number from 1 to 9:");

        while (!validInput) {
            int input = scanner.nextInt();

            //Check if the entered number is in the range from 1 to 9
            if (input > 0 && input <= 9) {
                //Check if the cell is already occupied
                if (box[input - 1] != 'X' && box[input - 1] != 'O') {
                    box[input - 1] = 'X';
                    validInput = true;
                } else {
                    System.out.println("This box is already taken. Choose another one.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number from 1 to 9.");
            }
        }
    }

    private void computerTurn() {
        Random random = new Random();
        boolean validTurn = false;

        System.out.println("Computer's turn.");

        while (!validTurn) {
            int choice = random.nextInt(9);

            //Check if the cell is free
            if (box[choice] != 'X' && box[choice] != 'O') {
                box[choice] = 'O';
                validTurn = true;
            }
        }
        printBox();
    }

    private boolean checkForWinner(char player) {
        //Checking horizontals
        for (int i = 0; i < 9; i += 3) {
            if (box[i] == player && box[i + 1] == player && box[i + 2] == player) {
                return true;
            }
        }

        //Checking verticals
        for (int i = 0; i < 3; i++) {
            if (box[i] == player && box[i + 3] == player && box[i + 6] == player) {
                return true;
            }
        }

        //Checking the diagonals
        if (box[0] == player && box[4] == player && box[8] == player) {
            return true;
        }
        return box[2] == player && box[4] == player && box[6] == player;
    }

    private boolean isDraw() {
        //If there is at least one free cell, the game is not over yet
        for (char c : box) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }

        return true;
    }
    private void printBox(){
        //Displaying the playing field
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
        if(!isBoxEmpty){
            byte i;
            for(i = 0; i < 9; i++)
                box[i] = ' ';
            isBoxEmpty = true;
        }
    }
    private void printResult() {
        //Print the result of the game
        printBox();
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
