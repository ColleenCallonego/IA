import java.util.Scanner;

public class Game {

    static String board;

    static void board_init() {
        board = "1111111111111111";
    }

    static void board_display() {
        System.out.println("   " + board.charAt(0));
        System.out.println("  " + board.substring(1, 4));
        System.out.println(" " + board.substring(4, 9));
        System.out.println(board.substring(9));
    }


    static void play2P() {
        Scanner s = new Scanner(System.in);
        String choice = "";
        String newLine = "";
        board_init();
        int playerTurn = 1;
        while (!board.equals("0000000000000000")) {
            board_display();
            System.out.println("Player " + (playerTurn > 0 ? "1" : "2") + " select a line to modify (type 1,2,3 or 4)");
            do {
                choice = s.nextLine();
            }
            while (!choice.matches("[1234]"));
            System.out.println("Type the modified line");
            newLine = s.nextLine();
            while (!LineIsValid(choice, newLine)) {
                System.out.println("Incorrect entry, please type the correct number of only 0 and 1");
                newLine = s.nextLine();
            }
            switch (choice) {
                case "1":
                    board = newLine + board.substring(1);
                    break;
                case "2":
                    board = board.substring(0, 1) + newLine + board.substring(4);
                    break;
                case "3":
                    board = board.substring(0, 4) + newLine + board.substring(9);
                    break;
                case "4":
                    board = board.substring(0, 9) + newLine;
                    break;
            }
            playerTurn *= -1;
        }
        System.out.println("Player " + (playerTurn > 0 ? "1" : "2") + " wins !!!");

    }

    private static boolean LineIsValid(String lineID, String checkedLine) {
        int lineLength = Integer.valueOf(lineID) * 2 - 1;
        return checkedLine.matches("[01]{" + String.valueOf(lineLength) + "}");
    }
}
