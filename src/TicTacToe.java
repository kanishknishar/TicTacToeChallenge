import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


    private static final Scanner scanner = new Scanner(System.in);
    private static final char[][] gameBoard = new char[3][3];
    private static final Random random = new Random();

    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe");
        int count = 1;
        while (count < 5) {
            askUser();
            computerPlays();
            printBoard();
            count++;
        }
        System.out.println("It was a tie.");

    }


    public static void printBoard() {
        for (char[] chars : gameBoard) {
            System.out.println("\t");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println("\n\n");
        }

    }

    private static boolean pickASquare(String player, int rowNumber, int columnNumber) {
        if (gameBoard[rowNumber][columnNumber] == 'X' || gameBoard[rowNumber][columnNumber] == 'O') {
            return false;
        }

        gameBoard[rowNumber][columnNumber] = player.equals("User") ? 'X' : 'O';
        return true;
    }

    private static void askUser() {
        boolean quit;
        do {
            System.out.println("Pick a row number: ");
            int rowNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Pick a column number: ");
            int columnNumber = scanner.nextInt();
            scanner.nextLine();

            quit = pickASquare("User", rowNumber - 1, columnNumber - 1);
        } while (!quit);
        checkWinner();

    }

    private static void computerPlays() {
        boolean quit;
        do {
            int rowNumber = random.nextInt(0,3);
            int columnNumber = random.nextInt(0,3);
            quit = pickASquare("Computer", rowNumber, columnNumber);
        } while (!quit);
        checkWinner();

    }

    private static void checkRow() {
        for (char[] chars : gameBoard) {
            int rowCount = 0;
            for (char aChar : chars) {
                if (aChar == 'X') rowCount += 1;
                else if (aChar == 'O') rowCount -= 1;
            }
            if (rowCount == 3) {
                printBoard();
                System.out.println("The player wins!");
                System.exit(0);
            }
            else if (rowCount == -3) {
                printBoard();
                System.out.println("The computer wins!");
                System.exit(0);

            }
        }
    }

    private static void checkColumn() {
        int rowCount = 0;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == 'X') rowCount += 1;
                else if (gameBoard[i][j] == 'O') rowCount -= 1;
            }
            
            if (rowCount == 3) {
                System.out.println("The player wins!");
                System.exit(0);
            }
            else if (rowCount == -3) {
                System.out.println("The computer wins!");
                System.exit(0);
            }
        }
    }
    
    public static void checkLeftDiagonal() {
        int rowCount = 0;
        for (int i = 0, j = 0; i < 3 && j < 3; i++, j++) {
            if (gameBoard[i][j] == 'X') rowCount += 1;
            else if (gameBoard[i][j] == 'O') rowCount -= 1;
        }
        
        if (rowCount == 3) {
            System.out.println("The player wins!");
            System.exit(0);
        }
        
        else if (rowCount == -3) {
            System.out.println("The computer wins!");
            System.exit(0);
        }
    }

    public static void checkRightDiagonal() {
        int rowCount = 0;
        for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
            if (gameBoard[i][j] == 'X') rowCount += 1;
            else if (gameBoard[i][j] == 'O') rowCount -= 1;
        }

        if (rowCount == 3) {
            System.out.println("The player wins!");
            System.exit(0);
        }

        else if (rowCount == -3) {
            System.out.println("The computer wins!");
            System.exit(0);

        }

    }

    public static void checkWinner() {
    checkRow();
    checkColumn();
    checkRightDiagonal();
    checkLeftDiagonal();
    }

}
