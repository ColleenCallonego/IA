package BaseGAME;

import MINMAX.MinMax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    static String board;
    enum modes{
        TWO_PLAYERS,
        PLAYER_FIRST,
        AI_FIRST,
    }
    static modes gameMode;

    static void board_init() {
        board = "1111111111111111";
    }

    static void board_display() {
        System.out.println("   " + board.charAt(0));
        System.out.println("  " + board.substring(1, 4));
        System.out.println(" " + board.substring(4, 9));
        System.out.println(board.substring(9));
    }

    static void menu(){
        Scanner s=new Scanner(System.in);
        String choice;
        System.out.println("Welcome to this game. Please select a game mode:");
        System.out.println("1. Player vs AI : player starts          2. Player vs AI : AI starts");
        System.out.println("3. Two Players");

        choice=s.nextLine();
        switch (choice){
            case "1":gameMode=modes.PLAYER_FIRST;
                System.out.println("Single player, player first selected");break;
            case "2":gameMode=modes.AI_FIRST;
                System.out.println("Single player, AI first selected");break;
            case "3":gameMode=modes.TWO_PLAYERS;
                System.out.println("Player vs Player selected");break;
            default :System.out.println("Wrong answer, please type select 1,2 or 3 next time.");
                menu();break;
        }
        System.out.println("Now, please select the way you want to initialize the board:");
        System.out.println("1. Default board          2. Load board from file");
        System.out.println("3. Create board from the console");

        choice=s.nextLine();
        switch (choice){
            case "1":board_init();break;
            case "2":System.out.println("Please indicate file path");
            board=loadFromFile(s.nextLine());break;
            case "3":System.out.println("Please type a string of length 16 composed of only 1s and 0s");
                board=s.nextLine();break;
        }
        if (!board.matches("[01]{16}")){
            System.out.println("Invalid format, please try again");
            menu();
        }


        switch (gameMode){
            case TWO_PLAYERS : play2P(s);break;
            case AI_FIRST : playAiFirst(s);break;
            case PLAYER_FIRST : playPlayerFirst(s);break;
        }
        s.close();
    }

    static void playAiFirst(Scanner s) {
        int playerTurn = -1;
        while (!board.equals("0000000000000000")) {
            board_display();
            System.out.println((playerTurn > 0 ? "Player select a line to modify (type 1,2,3 or 4)": "AI is playing...") );
            if (playerTurn>0){
                playerPlay(s);
            }else{
                board=convert(MinMax.IAPlay(board_read()));
            }

            playerTurn *= -1;
        }
        System.out.println("Player " + (playerTurn > 0 ? "1" : "2") + " wins !!!");
        s.close();
    }

    static void playPlayerFirst(Scanner s){
        int playerTurn = 1;
        while (!board.equals("0000000000000000")) {
            board_display();
            System.out.println((playerTurn > 0 ? "Player select a line to modify (type 1,2,3 or 4)": "AI is playing..."));
            if (playerTurn>0){
                playerPlay(s);
            }else{
                board=convert(MinMax.IAPlay(board_read()));
            }

            playerTurn *= -1;
        }
        System.out.println("Player " + (playerTurn > 0 ? "1" : "2") + " wins !!!");
        s.close();
    }
    

    private static String loadFromFile(String path){
        File f=new File(path);
        Scanner s= null;
        String result="";
        try {
            s = new Scanner(f);
            result=s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return result;
    }

    static String board_read() {
        String result = "";
        char c;
        int[] array = new int[]{1, 4, 9, 16};
        int startId = 0;
        int stickNumber;
        for (int i = 0; i < 4; i++) {
            stickNumber = 0;
            for (int j = startId; j < array[i]; j++) {
                c = board.charAt(j);
                if (c == '1') {
                    stickNumber++;
                }
                if (c == '0' && stickNumber != 0) {
                    result += String.valueOf(stickNumber);
                    stickNumber = 0;
                }
            }
            if (stickNumber != 0)
                result += String.valueOf(stickNumber);
            if (i < 3)
                result += '|';
            startId = array[i];

        }
        return result;
    }

    static String convert(String str) {
        StringBuilder sb = new StringBuilder("0000000000000000");
        int row = 1;
        char c;
        int n = 0;
        char previous;
        int writeindex = 0;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (c == '|') {

                row++;
                switch (row) {
                    case 2:
                        writeindex = 1;
                        break;
                    case 3:
                        writeindex = 4;
                        break;
                    case 4:
                        writeindex = 9;
                        break;
                }
            } else {
                n = Integer.parseInt(String.valueOf(c));

                for (int j = 0; j < n; j++) {
                    sb.setCharAt(writeindex + j, '1');
                }
                writeindex += n + 1;


            }
        }
        return sb.toString();
    }


    static void play2P(Scanner s) {

        int playerTurn = 1;
        while (!board.equals("0000000000000000")) {
            board_display();
            System.out.println("Player " + (playerTurn > 0 ? "1" : "2") + " select a line to modify (type 1,2,3 or 4)");
            playerPlay(s);
            playerTurn *= -1;
        }
        System.out.println("Player " + (playerTurn > 0 ? "1" : "2") + " wins !!!");
        s.close();

    }

    private static void playerPlay(Scanner s){
        String choice="";
        String newLine = "";
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
    }

    private static boolean LineIsValid(String lineID, String checkedLine) {
        int lineLength = Integer.valueOf(lineID) * 2 - 1;
        return checkedLine.matches("[01]{" + String.valueOf(lineLength) + "}");
    }
}
