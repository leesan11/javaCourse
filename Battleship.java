import java.util.*;
import java.io.*;

public class Battleship {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean winner=false;
        char[][] playerOne = { { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' } };
        char[][] playerOneShow = { { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' } };
        char[][] playerTwo = { { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' } };
        char[][] playerTwoShow = { { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-' } };
        System.out.println("Welcome to Battleship!");
        playerOne = getCoord(playerOne, "1", input);
        printBattleShip(playerOne);
        hide();
        playerTwo = getCoord(playerTwo, "2", input);
        printBattleShip(playerTwo);
        hide();
        do{
            playerTwoShow = runTurn(playerTwo,playerTwoShow,"1",input);
            printBattleShip(playerTwoShow);
            if(checkWin(playerTwoShow)){
                winner = true;
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                System.out.println("Final boards:");
                printBattleShip(mergeBoard(playerOne, playerOneShow));
                printBattleShip(playerTwoShow);
                break;
            }
            playerOneShow = runTurn(playerOne,playerOneShow,"2",input);
            printBattleShip(playerOneShow);
            if(checkWin(playerOneShow)){
                winner = true;
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                System.out.println("Final boards:");
                printBattleShip(playerOneShow);
                printBattleShip(mergeBoard(playerTwo, playerTwoShow));
                break;
            }
        }while(!winner);
        
    }

    private static void hide(){
        for(int i=0;i<100;i++){
            System.out.println("\n");
        }
    }

    private static char[][] mergeBoard(char[][] playerBoard, char[][] playerBoardShow){
        for(int row=0;row<5;row++){
            for(int col=0;col<5;col++){
                if(playerBoard[row][col] == '@' && playerBoardShow[row][col]!='X'){
                    playerBoardShow[row][col] = '@';
                }
            }
        }
        return playerBoardShow;
    }

    private static boolean checkWin(char[][] playerBoard){
        int counter = 0;
        for (int row=0; row<5;row++){
            for (int col=0;col<5;col++){
                if(playerBoard[row][col]=='X'){
                    counter++;
                }
            }
        }
        if(counter == 5){
            return true;
        }else{
            return false;
        }
    }

    private static char[][] runTurn(char[][] playerBoard,char[][] playerBoardShow, String playerNum, Scanner input){
        String otherPlayer = playerNum.equals("1")?"2":"1";
        int x;
        int y;
        boolean already;
            do{
                System.out.println("Player "+ playerNum +", enter hit row/column:");
                x = input.nextInt();
                y = input.nextInt();
                already = false;
                if(!(x >= 0 && x < 5) || !(y >= 0 && y < 5)){
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }else if(playerBoardShow[x][y]=='O' || playerBoardShow[x][y]=='X'){
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                    already = true;
                }else if(playerBoard[x][y]=='-'){
                    System.out.println("PLAYER "+playerNum+" MISSED!");
                    playerBoardShow[x][y]='O';
                }else{
                    System.out.println("PLAYER " +playerNum+ " HIT PLAYER "+ otherPlayer +"’s SHIP!");
                    playerBoardShow[x][y]= 'X';
                }
            }while(!(x>=0 && x<5) || !(y>=0 && y<5) || already);
            
        return playerBoardShow;
    }

    private static char[][] getCoord(char[][] playerBoard, String playerNum, Scanner input) {
        System.out.println("PLAYER " + playerNum + ", ENTER YOUR SHIPS' COORDINATES.");
        for (int i = 0 + 1; i < 5 + 1; i++) {
            System.out.println("Enter ship " + i + " location:");
            int x = input.nextInt();
            int y = input.nextInt();
            if ((x >= 0 && x < 5) && (y >= 0 && y < 5) && playerBoard[x][y]=='-') {
                playerBoard[x][y] = '@';
            }else {
                do {
                    if((x >= 0 && x < 5) && (y >= 0 && y < 5) && playerBoard[x][y]=='@'){
                        System.out.println("You already have a ship there. Choose different coordinates.");
                    }else{
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    }
                    System.out.println("Enter ship " + i + " location:");
                    x = input.nextInt();
                    y = input.nextInt();
                } while (!(x >= 0 && x < 5) || !(y >= 0 && y < 5) || playerBoard[x][y]=='@');
                playerBoard[x][y] = '@';
            }

        }
        return playerBoard;

    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

}